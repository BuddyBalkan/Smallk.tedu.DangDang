<%@ page import="java.util.ArrayList" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %> <!-- 设置-->
<%@ page import="com.tedu.bean.DBook" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
 		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<link href="css/book.css" rel="stylesheet" type="text/css" />
		<link href="css/second.css" rel="stylesheet" type="text/css" />
		<link href="css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="css/list.css" rel="stylesheet" type="text/css" />
		<link href="css/book_head090107.css" rel="stylesheet"
			type="text/css" />
		<link href="css/public_footer.css" rel="stylesheet" type="text/css" />
	</head>
	<body>


		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="images/default/book_banner_081203.jpg"
					border="0" /> </a>
		</div>
		<!-- 头部开始 -->
		<div class="head_container">
			<div class="head_welcome">
				<div class="head_welcome_right">
					<span class="head_welcome_text"> </span>
					<span class="head_welcome_text"> <span class="little_n">
							| <a href="login.jsp" name="mydangdang" class="head_black12a">登录</a> |
							<a href="register.jsp" name="helpcenter" class="head_black12a"
							   target="_blank">注册</a> | </span> </span>
					<div class="cart gray4012">
						<a href="cart.html">购物车</a>
					</div>
				</div>
			</div>
			<div class="head_head_list">
				<div class="head_head_list_left">
					<span class="head_logo"><a href="#" name="backtobook"><img
								src="images/booksaleimg/book_logo.gif" /> </a> </span>
				</div>
				<div class="head_head_list_right">

					<div class="head_head_list_right_b">
					</div>
				</div>
			</div>
		</div>
		<!-- 头部结束 -->

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
			</div>
			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div >
							您现在的位置:&nbsp;
							<a href="#" style="font-size: 12pt;font-family: sans-serif;color: white">图书热卖场</a> 
						</div>
					</div>

					<!--商品条目开始-->
					<div class="list_r_line"></div>
					<div class="clear"></div>
                    <%
                        // 在jsp中 out request response 都是内置对象，可以直接调用
                        ArrayList<DBook> books = (ArrayList<DBook>) request.getAttribute("bs");
                        for (int i = 0; i < books.size(); i++){
                            DBook book = books.get(i);
					%>
					<div class="list_r_list">
						<span class="list_r_list_book">
							<a target='_blank' name="link_prd_img" href='#'>
								<img title="<%=book.getProductName()%>" class="dang_img"
								src='productImages/<%=book.getProductPic()%>' /> </a> </span>
						<h2>
							<a target='_blank' name="link_prd_name"
							   href='#'><%=book.getProductName()%></a>
						</h2>
						<h3>
							顾客评分：100
						</h3>
						<h4 class="list_r_list_h4">
							作 者:
							<a href='#' name='作者'><%=book.getAuthor()%></a>
						</h4>
						<h4>
							出版社：
							<a href='#' name='出版社'><%=book.getPublishing()%></a>
						</h4>
						<h4>
							出版日期：<%=book.getPublishTime()%>
						</h4>
						<h5>
							<%=book.getDescription()%>
						</h5>
						<div class="clear"></div>
						<h6>
							<span class="del">定价:<%=book.getFixedPrice()%></span>
							<span class="red">当当价:<%=book.getDangPrice()%></span> 节省：<%=book.getFixedPrice()-book.getDangPrice()%>
						</h6>
						<span class="list_r_list_button"> <img align="top"
															   src='images/buttom_goumai.gif'
															   onclick="javascript:window.location.href='cart.html'" /> </span>
						<span id="cartInfo_1"></span>
					</div>

                    <%
						}
                    %>




					<div class="clear"></div>
					<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->

		<div class="public_footer">
			<div class="public_footer_bottom">
				<div class="public_footer_icp" style="line-height: 48px;">
					Copyright (C) 当当网 2004-2008, All Rights Reserved
					<a href="#" target="_blank"><img
							src="images/bottom/validate.gif" border="0" align="middle" />
					</a>
					<a href="#" target="_blank" style="color: #666;">京ICP证041189号</a>
				</div>
			</div>
		</div>
		<!--页尾结束 -->
	</body>
</html>
