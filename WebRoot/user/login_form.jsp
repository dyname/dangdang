<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>登录 - 当当网</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script src="../js/jquery-1.4.3.js"></script>
		<script >
			var emailFlag=false;
			var passwordFlag=false;
			$(function(){
				//检测邮箱是否符合要求
				$('#txtEmail').bind("blur",function(){
					var reg =/^.+@.+(\.com|\.cn)$/;
					var email=$.trim($('#txtEmail').val());
					if(email.length==0){
						$('#divErrorMssage').html("邮箱不能为空.");
						emailFlag= false;
					}else{
						if(!reg.test(email)){
							$('#divErrorMssage').html("邮箱格式有误.");
							emailFlag= false;
						}else{
							$('#divErrorMssage').html("");
							emailFlag=true;
						}
					}
				});
				//检测密码是否符合要求
				$('#txtPassword').blur(function(){
					if(!emailFlag){
						return ;
					}
					var pwd =$.trim($('#txtPassword').val());
					var reg = new RegExp(/^([a-z]|[A-Z]|\d){6,20}$/);
					if(pwd.length==0){
						$('#divErrorMssage').html("密码不能为空.");
						passwordFlag= false;
						return ;
					}
					if(pwd.length>20||pwd.length<6){
						$('#divErrorMssage').html("密码长度有误.");
						passwordFlag= false;
						return ;
					}
					if(reg.test(pwd)){
						$('#divErrorMssage').html("");
						passwordFlag= true;
						return ;
					}else{
						$('#divErrorMssage').html("密码格式有误.");
						passwordFlag= false;
					}
				});
			});
			
			function clearMessage(){
				$('#divErrorMssage').html("");
				if(!emailFlag){
					$('#txtEmail').blur();
				}
				if(!passwordFlag){
					$('#txtPassword').blur();
				}
				return emailFlag && passwordFlag;
			}
		
		</script>
	</head>
	<body>

		<%@include file="../common/head1.jsp"%>

		<div class="enter_part">

			<%@include file="../common/introduce.jsp"%>

			<div class="enter_in">
				<div class="bj_top"></div>
				<div class="center">
					<div style="height:30px ; padding:5px ; color:red ;" id="divErrorMssage">
						${errorMessage}
					</div>
					<div class="main">
						<h3>
							登录当当网
						</h3>

						<form onsubmit="return clearMessage();" method="post" action="<%=request.getContextPath()%>/user/login.action" id="ctl00">
							<ul>
								<li>
									<span>请输入Email地址：</span>
									<input type="text" name="email" id="txtEmail" class="textbox" value="${email}"/>
								</li>
								<li>
									<span class="blank">密码：</span>
									<input type="password" name="password" id="txtPassword"
										class="textbox" value="${password}" />
								</li>
								<li>
									<input type="submit" id="btnSignCheck" class="button_enter"
										value="登 录" />
								</li>
							</ul>
							<input type="hidden" name="uri" value="${uri}" />
						</form>
					</div>
					<div class="user_new">
						<p>
							您还不是当当网用户？
						</p>
						<p class="set_up">
							<a href="../user/reg.action">创建一个新用户&gt;&gt;</a>
						</p>
					</div>
				</div>
			</div>
		</div>

		<%@include file="../common/foot1.jsp"%>

	</body>
</html>

