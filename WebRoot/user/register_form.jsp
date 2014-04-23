<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
		<script >
			
			var emailFlag=false;
			var nickNameFlag=false;
			var pwdFlag=false;
			var pwdVaildFlag=false;
			var validCodeFlag=false;
			$(function(){
				//检测邮箱
				$('#txtEmail').bind("blur",function(){
					var reg =/^.+@.+(\.com|\.cn)$/;
					var email=$.trim($('#txtEmail').val());
					if(email.length==0){
						$('#email\\.info').html("邮箱不能为空.");
						$('#email\\.info').attr("style","color:red");
						emailFlag=false;
					}else{
						if(!reg.test(email)){
							$('#email\\.info').html("邮箱格式有误.");
							$('#email\\.info').attr("style","color:red");
							
							emailFlag=false;
						}else{
							$('#email\\.info').html("<img src='../images/window_loading.gif'>正在验证...");
							$('#email\\.info').attr("style","color:green");
							$.ajax({
								"url":"vaildEmail",
								"type":"post",
								"data":"email="+email,
								"success":function(data){
									if(data){
										$('#email\\.info').html("邮箱可以使用.");
										$('#email\\.info').attr("style","color:green");
										emailFlag=true;
									}else{
										$('#email\\.info').html("邮箱被占用.");
										$('#email\\.info').attr("style","color:red");
										emailFlag=false;									
									}
								}
							});
						}
					}
				});
				
				//检测昵称
				$('#txtNickName').blur(function(){
					var str = $('#txtNickName').val();
					var len=0;
					var reg = new RegExp(/[\u4e00-\u9fa5]/);
					for(i=0;i<str.length;i++){
						if(reg.test(str[i])){
							len=len+2;
						}else{
							len=len+1;
						}
					}
					if(len>20){
						$('#name\\.info').html("昵称长度不能超过20个字符.");
						$('#name\\.info').attr("style","color:red");
						nickNameFlag=false;
					}else if(len<4){
						$('#name\\.info').html("昵称长度不能少于4个字符.");
						$('#name\\.info').attr("style","color:red");
						nickNameFlag=false;
					}
					else{
						$('#name\\.info').html("昵称可用.");
						$('#name\\.info').attr("style","color:green");
						nickNameFlag=true;
					}
				});
			
			});
			
			
			$(function(){
				//检测密码是否符合要求
				$('#txtPassword').blur(function(){
					var pwd =$.trim($('#txtPassword').val());
					var reg = new RegExp(/^([a-z]|[A-Z]|\d){6,20}$/);
					if(pwd.length==0){
						$('#password\\.info').html("密码不能为空.");
						$('#password\\.info').attr("style","color:red");
						pwdFlag=false;
						return ;
					}
					if(pwd.length>20||pwd.length<6){
						$('#password\\.info').html("密码长度有误.");
						$('#password\\.info').attr("style","color:red");
						pwdFlag=false;
						return ;
					}
					if(reg.test(pwd)){
						$('#password\\.info').html("密码可以使用.");
						$('#password\\.info').attr("style","color:green");
						pwdFlag=true;
					}else{
						$('#password\\.info').html("密码格式有误.");
						$('#password\\.info').attr("style","color:red");
						pwdFlag=false;
					}
				});
				
				
				//再次检测密码
				//检测密码是否符合要求
				$('#txtRepeatPass').blur(function(){
					var oldPwd =$.trim($('#txtPassword').val());
					var pwd=$.trim($('#txtRepeatPass').val());
					if(oldPwd.length==0){
						$('#password1\\.info').html("请输入密码.");
						$('#password1\\.info').attr("style","color:red");
						pwdVaildFlag=false;
						return ;
					}
					if(oldPwd==pwd){
						$('#password1\\.info').html("两次密码相同.");
						$('#password1\\.info').attr("style","color:green");
						pwdVaildFlag=true;
					}else{
						$('#password1\\.info').html("两次密码输入不同.");
						$('#password1\\.info').attr("style","color:red");
						pwdVaildFlag=false;
					}
				});
				
			});
			
			
			$(function(){
					//更换验证码
				$('#changeImage').bind("click",function(){
					$("#imgVcode").attr("src","imageCode.action?dt="+new Date().getTime());
					return false;
				
				});
				//ajax检测验证码是否正确
				$('#txtVerifyCode').blur(function(){
					var code=$.trim($('#txtVerifyCode').val());
					if(code.length==0){
						$('#number\\.info').html("验证码不能为空.");
						$('#number\\.info').attr("style","color:red");
						validCodeFlag=false;
						return ;
					}else{
						$('#number\\.info').html("<img src='../images/window_loading.gif'>正在验证...");
						$('#number\\.info').attr("style","color:red");
						$.ajax({
							"url":"validCode.action",
							"data":"code="+code,
							"type":"post",
							"success":function(data){
								if(data){
									submitFlag=true;
									$('#number\\.info').html("验证码正确.");
									$('#number\\.info').attr("style","color:green");
									validCodeFlag=true;
								}else{
									submitFlag=false;
									$('#number\\.info').html("验证码有误.");
									$('#number\\.info').attr("style","color:red");
									validCodeFlag=false;
								}	
							}
						});
					}
				});
			});
			
			//提交之前检所有的条件
			function checkAll(){
				//检查验证码是否真确，正确的话就不在验证
				  if(!emailFlag){
				  	$('#txtEmail').blur();
				  }
				  if(!nickNameFlag){
				  	$('#txtNickName').blur();
				  }
				  if(!pwdFlag){
				  	$('#txtPassword').blur();
				  }
				  if(!pwdVaildFlag){
				  	$('#txtRepeatPass').blur();
				  }
				  if(!validCodeFlag){
				  	$('#txtVerifyCode').blur();
				  }	
				  return emailFlag && nickNameFlag && pwdFlag && pwdVaildFlag && validCodeFlag;
			}
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
			<form  onsubmit="return checkAll();" name="ctl00" method="post" action="register.action" >
				<h2>
					以下均为必填项
				</h2>
				<table class="tab_login" >
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<input name="user.email" type="text" id="txtEmail" class="text_input"/>
							<div class="text_left" id="emailValidMsg">
								<p>
									请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。
								</p>
									<span id="email.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<input name="user.nickname" type="text" id="txtNickName" class="text_input" />
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p>
									长度4－20个字符，一个汉字为两个字符。
								</p>
								<span id="name.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<input name="user.password" type="password" id="txtPassword"
								class="text_input" />
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
								</p>
								<span id="password.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<input name="password1" type="password" id="txtRepeatPass"
								class="text_input"/>
							<div class="text_left" id="repeatPassValidMsg">
							<span id="password1.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<img class="yzm_img" id='imgVcode' src="imageCode.action" />
							<input name="number" type="text" id="txtVerifyCode"
								class="yzm_input"/>
							<div class="text_left t1">
								<p class="t1">
									<span id="vcodeValidMsg">请输入图片中的五个字母。</span>
									<a href="#" id="changeImage" >看不清楚？换个图片</a>
									<br/>
									<span id="number.info" style="color:red"></span>
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<input id="btnClientRegister" class="button_1" name="submit"  type="submit" value="注 册"/>
				</div>
				<s:token></s:token>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

