<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/shopping_vehicle.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
		<script type="text/javascript">
			
			function del(id){
				location="delete.action?productId="+id;
			}
			function recover(id){
				location="recover.action?productId="+id;
			}
			$(function(){
			
				var total=parseFloat($.trim($("#total_account").text()));
				$("#total_account").text(total.toFixed(2));
				var total=parseFloat($.trim($("#total_economy").text()));
				$("#total_economy").text(total.toFixed(2));
				$(".change").bind("click",function(){
					//修改是否成功的标志
					var changeSuccess=false;
					//当前要修改成的数量
					var num=$(this).prev().val();
					//当前修改对象的id
					var id=$(this).next(".hiddenId").val();
					var reg=/^\d+$/;
					if(num.length==0){
						alert("数量必须填写");
						return ;
					}
					var reg=/^[0-9]+$/;
					if(!reg.test(num)){
						alert("必须是数字");
						return ;
					}
					//.prev(".buy_td_1").children(".dangPriceSpan").html(id);
					//location="change.action?productId="+id+"&productNumber="+num;
					$.get("change.action", { productId:id, productNumber:num },
  						function(data){
   							if(data){
   								location="cartList.action";
   							}
  					});
				});
			});
		</script>
		
	</head>
	<body>
		<br />
		<br />
		<div class="my_shopping">
			<img class="pic_shop" src="../images/pic_myshopping.gif" />
		</div>
		
		<s:if test="cartItemInList.size()>0">
		<div id="div_choice" class="choice_merch">
			<h2 id="cart_tips">
				您已选购以下商品
			</h2>
			<div class="choice_bord">
				<table class="tabl_buy" id="tbCartItemsNormal">
					<tr class="tabl_buy_title">
						<td class="buy_td_6">
							<span>&nbsp;</span>
						</td>
						<td>
							<span class="span_w1">商品名</span>
						</td>
						<td class="buy_td_5">
							<span class="span_w2">市场价</span>
						</td>
						<td class="buy_td_4">
							<span class="span_w3">当当价</span>
						</td>
						<td class="buy_td_1">
							<span >数量</span>
						</td>
						<td class="buy_td_2">
							<span>变更数量</span>
						</td>
						<td class="buy_td_1">
							<span>删除</span>
						</td>
					</tr>
					<tr class='objhide' over="no">
						<td colspan="8">
							&nbsp;
						</td>
					</tr>
                      <!-- 购物列表开始 -->
                   	  <s:set name="all" value="0"></s:set>
                   	  <s:set name="save" value="0"></s:set>
                   	  <s:set name="lsitSize" value="cartItemInList.size()"></s:set>
                   	  <input type="hidden" value=""/>
                      <s:iterator value="cartItemInList">
						<tr class='td_no_bord' id="${productId}">
							<td style='display: none'>
								9317290
							</td>
							<td class="buy_td_6">
								<span class="objhide"><img /> </span>
							</td>
							<td>
								<a href="#"><s:property value="productName" /> </a>
							</td>
							<td class="buy_td_5">
								<span class="c_gray">￥<s:property value="fixedPrice" /></span>
							</td>
							<td class="buy_td_4">
								&nbsp;&nbsp;
								<span >￥<s:property value="dangPrice" /></span>
							</td>
							<td class="buy_td_1" >
								<span class="dangPriceSpan">
									<s:property value="productNum" />
								</span>
							</td>
							<td >
								<input type="hidden" value="${oneCha}" class="hiddenCha" />
								<input class="del_num" type="text" size="3" maxlength="4" />
								<a href="javascript:;" class="change" value="11" id="ddd" >变更</a>
								<input type="hidden" value="${productId}" class="hiddenId"/>
								<input type="hidden" value="${dangPrice}" class="hiddenDangPrice" />
							</td>
							<td>
								<a href="javascript:;" class="delete" onclick="del(${productId},document.getElementById('${productId}').value)" value="${productId}">删除</a>
							</td>
						</tr>
						 <s:set name="all" value="#all+amount"></s:set>
                   	 	 <s:set name="save" value="#save+cha"></s:set>
					</s:iterator>
					<!-- 设置总价格,优惠总价格到一个隐含域中 -->
					<input type="hidden" value="${all}" id="amount"/>
					<input type="hidden" value="${save}" id="save"/>
					
					<!-- 购物列表结束 -->
				</table>
				<div class="choice_balance">
					<div class="select_merch">
						<a href='../main/main.jsp'> 继续挑选商品>></a>
					</div>
					<div class="total_balance">
						<div class="save_total">
							您共节省：
							<span class="c_red"> ￥<span id="total_economy"><s:property value="#save" /> </span>
							</span>
							<span id='total_vip_economy' class='objhide'> ( 其中享有优惠： <span
								class="c_red"> ￥<span id='span_vip_economy'>0.00</span> </span>
								) </span>
							<span style="font-size: 14px">|</span>
							<span class="t_add">商品金额总计：</span>
							<span class="c_red_b"> ￥ <span id='total_account' ><s:property value="#all" /></span>
							</span>
						</div>
						<div id="balance" class="balance">
							<a name='checkout' href='../order/pay.action' > 
								<img src="../images/butt_balance.gif" alt="结算" border="0" title="结算" />
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		</s:if>
		<s:else>
			<div id="div_no_choice" >
				<div class="choice_title"></div>
				<div class="no_select">
					您还没有挑选商品 &nbsp;&nbsp;
					<div class="select_merch">
						<a href='../main/main.jsp'> 继续挑选商品>></a>
					</div>
				</div>
			</div>
		</s:else>
		<!-- 用户删除恢复区 -->

		<s:if test="cartItemOutList.size()>0">
		<div id="divCartItemsRemoved" class="del_merch">
			<div class="del_title">
				您已删除以下商品，如果想重新购买，请点击“恢复”
			</div>
			<table class=tabl_del id=del_table>
				<tbody>
				<s:iterator value="cartItemOutList">
					<tr>
						<td width="58" class=buy_td_6>
							&nbsp;
						</td>
						<td width="365" class=t2>
							<a href="#"><s:property value="productName" /></a>
						</td>
						<td width="106" class=buy_td_5>
							￥<s:property value="fixedPrice" />
						</td>
						<td width="134" class=buy_td_4>
							<span>￥<s:property value="dangPrice" /></span>
						</td>
						<td width="56" class=buy_td_1>
							<a href="javascript:;" onclick="recover(${productId});">恢复</a>
						</td>
						<td width="16" class=objhide>
							&nbsp;
						</td>
					</tr>
					<tr class=td_add_bord>
						<td colspan=8>
							&nbsp;
						</td>
					</tr>
				</s:iterator>
				</tbody>
			</table>
		</div>
		</s:if>
		<br />
		<br />
		<br />
		<br />
		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>



