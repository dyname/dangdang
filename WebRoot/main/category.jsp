<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>  
<html> 
<head>
	<script type="text/javascript" scr="../js/jquery-1.4.3.js" />
	<script type="text/javascript">

	</script>
</head>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		<s:iterator value="allCategoryList">
		<!--1级分类开始-->
			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<h3>
					[<a href='onePageOfProduct.action?categoryId=${categoryOwn.id}'><s:property value="categoryOwn.name"/></a>]
				</h3>
				<ul class="ul_left_list">
					<s:iterator value="categoryList">
						<!--2级分类开始-->	
						<li>
							<a href='onePageOfChildProduct.action?categoryId=${id}' ><s:property value="name" /></a>
						</li>
						<!--2级分类结束-->
					</s:iterator>
				</ul>
				<div class="empty_left">
				</div>
			</div>
			<div class="more2">
			</div>
		<!--1级分类结束-->
		</s:iterator>
		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
</html>
