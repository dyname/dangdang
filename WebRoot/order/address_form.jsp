<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script src="../js/jquery-1.4.3.js"></script>
		<script >
		
			var receivername=false;
			var fulladdress=false;
			var postalCode=false;
			var mobile=false;
			var phone=false;
			$(function(){
				$("#address").bind("change",function(){
					$("#address\\.receiveName").val("");
					$("#address\\.fullAddress").val("");
					$("#address\\.postalCode").val("");
					$("#address\\.phone").val("");
					$("#address\\.mobile").val("");
					var add=$("#address").val();
					if(add==0){
						return;
					}
					$.get('oneAddress.action',{"addressId":add},function(data,status){
						$("#address\\.receiveName").val(data.receiveName);
						$("#address\\.fullAddress").val(data.fullAddress);
						$("#address\\.postalCode").val(data.postalCode);
						$("#address\\.phone").val(data.phone);
						$("#address\\.mobile").val(data.mobile);
					},"json");
				
				});
			
			});
			//判断是否是一个新的的地址
			function check(){
					//先判断表格中填的数据是否符合要求
					if(!receivername){
						$("#address\\.receiveName").blur();
					}
					if(!fulladdress){
						$("#address\\.fullAddress").blur();
					}
					if(!postalCode){
						$("#address\\.postalCode").blur();
					}
					if(!phone){
						$("#address\\.phone").blur();
					}
					if(!mobile){
						$("#address\\.mobile").blur();
					}
					//如果电话和手机两个中填写了一个，那么两个提示的字体就为验证过的颜色
					if(mobile||phone){
						$("#phoneValidMsg").attr("style","color:break-all");
						$("#mobileValidMsg").attr("style","color:break-all");
					}
					//判断当前的地址是新地址还是旧地址,
					//如果是新的话，在提交订单时将当前的地址添加到数据库中
					var add=$("#address").val();
					alert(add);
					if(add==0){
						$("#newAddress").val("true");
					}else{
						$("#newAddress").val("false");
					}
					return receivername && fulladdress && postalCode && (mobile || phone);
			}
			
			$(function(){
				$("#address\\.receiveName").bind("blur",function(){
					var name=$.trim($(this).val());
					$("#nameValidMsg").attr("style","color:break-all");
					if(name.length<2){
						$("#nameValidMsg").attr("style","color:red");
						receivername=false;
					}else{
						receivername=true;
					}	
				});
				
				$("#address\\.fullAddress").bind("blur",function(){
					var address=$.trim($(this).val());
					$("#addressValidMsg").attr("style","color:break-all");
					if(address.length<10){
						$("#addressValidMsg").attr("style","color:red");
						fulladdress=false;
						
					}else{			
						fulladdress=true;
					}	
				});
				
				$("#address\\.postalCode").bind("blur",function(){
					var post=$.trim($(this).val());
					$("#codeValidMsg").attr("style","color:break-all");
					var reg=/^[0-9]{6}$/;
					if(!reg.test(post)){
						postalCode=false;
						$("#codeValidMsg").attr("style","color:red");
					}else{	
						postalCode=true;
					}	
				});
				
				$("#address\\.phone").bind("blur",function(){
					var ph=$.trim($(this).val());
					$("#phoneValidMsg").attr("style","color:break-all");
					var reg=/^[0-9]{7,9}$/;
					if(!reg.test(ph)){
						phone=false;
						$("#phoneValidMsg").attr("style","color:red");
					}else{
						phone=true;
					}	
				});
				
				$("#address\\.mobile").bind("blur",function(){
					var mb=$.trim($(this).val());
					$("#mobileValidMsg").attr("style","color:break-all");
					var reg=/^[0-9]{11}$/;
					if(!reg.test(mb)){
						mobile=false;
						$("#mobileValidMsg").attr("style","color:red");
						
					}else{	
						mobile=true;
					}	
				});
				
			});
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			生成订单骤: 1.确认订单 >
			<span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
		</div>
		<div class="fill_message">
			<p>
					<s:debug></s:debug>
				选择地址：
				<select id="address" >
					<option id="0" value="0">
						填写新地址
					</option >
					<s:iterator value="addressList">
						<option id="${id}" value="${id}">
							<s:property value="fullAddress" />
						</option >
					</s:iterator>
				</select>
			</p>
			<form onsubmit="return check();" name="ctl00" method="post" action="buy.action" id="submit">
				<input type="hidden" value="" id="newAddress" name="newAddress"/>
				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							收件人姓名：
						</td>
						<td>
							<input type="text" class="text_input" name="address.receiveName"
								id="address.receiveName" />
							<div class="text_left" id="nameValidMsg">
								<p>
									请填写有效的收件人姓名
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							收件人详细地址：
						</td>
						<td>
							<input type="text" name="address.fullAddress" class="text_input"
								id="address.fullAddress" />
							<div class="text_left" id="addressValidMsg">
								<p>
									请填写有效的收件人的详细地址
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							邮政编码
						</td>
						<td>
							<input type="text" class="text_input" name="address.postalCode"
								id="address.postalCode" />
							<div class="text_left" id="codeValidMsg">
								<p>
									请填写有效的收件人的邮政编码
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							电话
						</td>
						<td>
							<input type="text" class="text_input" name="address.phone"
								id="address.phone" />
							<div class="text_left" id="phoneValidMsg">
								<p>
									请填写有效的收件人的电话
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							手机
						</td>
						<td>
							<input type="text" class="text_input" name="address.mobile"
								id="address.mobile" />
							<div class="text_left" id="mobileValidMsg">
								<p>
									请填写有效的收件人的手机
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<a href="order_info.jsp"><input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="取消" /></a>
			
				<input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="下一步" />
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

