<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品管理</title>
<%@include file="../public/Header.jsp" %>
</HEAD>
<BODY class="bg_color">
 	<div class="top bg_color">
        <div class="logo"><a href="Index.html"><img src="${path }/statics/images/logo.png" /></a></div>
    </div>
	<DIV class="i_bg bg_color">
		<!--Begin 用户中心 Begin -->
		<DIV class=m_content>
			<DIV class=m_left>
				<DIV class=left_n>管理中心</DIV>
				<DIV class=left_m>
					<DIV class="left_m_t t_bg1">订单中心</DIV>
					<UL>
						<LI><A
							href="http://localhost:8080/EasyBuy/admin/order?action=index&amp;userId=2">我的订单</A>
						</LI>
						<LI><A
							href="http://localhost:8080/EasyBuy/admin/order?action=queryAllOrder">全部订单</A>
						</LI>
					</UL>
				</DIV>
				<DIV class=left_m>
					<DIV class="left_m_t t_bg2">会员中心</DIV>
					<UL>
						<LI><A
							href="http://localhost:8080/EasyBuy/admin/user?action=index">用户信息</A>
						</LI>
						<LI><A
							href="http://localhost:8080/EasyBuy/admin/user?action=queryUserList">用户列表</A>
						</LI>
					</UL>
				</DIV>
				<DIV class=left_m>
					<DIV class="left_m_t t_bg2">商品管理</DIV>
					<UL>
						<LI><A
							href="http://localhost:8080/EasyBuy/admin/productCategory?action=index">分类管理</A>
						</LI>
						<LI><A class=now
							href="http://localhost:8080/EasyBuy/admin/product?action=index">商品管理</A>
						</LI>
						<LI><A
							href="http://localhost:8080/EasyBuy/admin/product?action=toAddProduct">商品上架</A>
						</LI>
					</UL>
				</DIV>
				<DIV class=left_m>
					<DIV class="left_m_t t_bg2">资讯中心</DIV>
					<UL>
						<LI><A
							href="http://localhost:8080/EasyBuy/admin/news?action=queryNewsList">资讯列表</A>
						</LI>
					</UL>
				</DIV>
			</DIV>
			<DIV id=content class=m_right>
				<DIV class=mem_tit>商品列表</DIV>
				<BR>
				<TABLE style="TEXT-ALIGN: center; WIDTH: 930px; MARGIN-BOTTOM: 30px"
					class=order_tab border=0 cellSpacing=0 cellPadding=0>
					<TBODY>
						<TR>
							<TD width="10%">商品名称</TD>
							<TD width="10%">商品图片</TD>
							<TD width="5%">库存</TD>
							<TD width="10%">价格</TD>
							<TD width="10%" colSpan=2>操作</TD>
						</TR>
						<TR>
							<TD>aaaa</TD>
							<TD><A
								href="http://localhost:8080/EasyBuy/Product?action=queryProductDeatil&amp;id=732"
								target=_blank><IMG src="" width=50 height=50> </A>
							</TD>
							<TD>200</TD>
							<TD>111111.0</TD>
							<TD><A
								href="http://localhost:8080/EasyBuy/admin/product?action=toUpdateProduct&amp;id=732">修改</A>
							</TD>
							<TD><A onclick="deleteById('732');"
								href="javascript:void(0);">删除</A>
							</TD>
						</TR>
						<TR>
							<TD>香奈儿</TD>
							<TD><A
								href="http://localhost:8080/EasyBuy/Product?action=queryProductDeatil&amp;id=733"
								target=_blank><IMG
									src="product_files/27A1789ED5764D82A5506DF3DC3933F9.jpg"
									width=50 height=50> </A>
							</TD>
							<TD>94</TD>
							<TD>152.0</TD>
							<TD><A
								href="http://localhost:8080/EasyBuy/admin/product?action=toUpdateProduct&amp;id=733">修改</A>
							</TD>
							<TD><A onclick="deleteById('733');"
								href="javascript:void(0);">删除</A>
							</TD>
						</TR>
						<TR>
							<TD>洗面奶</TD>
							<TD><A
								href="http://localhost:8080/EasyBuy/Product?action=queryProductDeatil&amp;id=734"
								target=_blank><IMG
									src="product_files/D6C9BD438C5643D6B1A6C52E5426FE22.jpg"
									width=50 height=50> </A>
							</TD>
							<TD>995</TD>
							<TD>152.0</TD>
							<TD><A
								href="http://localhost:8080/EasyBuy/admin/product?action=toUpdateProduct&amp;id=734">修改</A>
							</TD>
							<TD><A onclick="deleteById('734');"
								href="javascript:void(0);">删除</A>
							</TD>
						</TR>
						<TR>
							<TD>啫喱水</TD>
							<TD><A
								href="http://localhost:8080/EasyBuy/Product?action=queryProductDeatil&amp;id=735"
								target=_blank><IMG
									src="product_files/1A836D2B3A3348DDAB19807E6CEA8028.jpg"
									width=50 height=50> </A>
							</TD>
							<TD>998</TD>
							<TD>152.0</TD>
							<TD><A
								href="http://localhost:8080/EasyBuy/admin/product?action=toUpdateProduct&amp;id=735">修改</A>
							</TD>
							<TD><A onclick="deleteById('735');"
								href="javascript:void(0);">删除</A>
							</TD>
						</TR>
						<TR>
							<TD>香水5853</TD>
							<TD><A
								href="http://localhost:8080/EasyBuy/Product?action=queryProductDeatil&amp;id=736"
								target=_blank><IMG
									src="product_files/4D9499BAD92A42D291094E797BA2EA3F.jpg"
									width=50 height=50> </A>
							</TD>
							<TD>1000</TD>
							<TD>152.0</TD>
							<TD><A
								href="http://localhost:8080/EasyBuy/admin/product?action=toUpdateProduct&amp;id=736">修改</A>
							</TD>
							<TD><A onclick="deleteById('736');"
								href="javascript:void(0);">删除</A>
							</TD>
						</TR>
					</TBODY>
				</TABLE>
				<DIV class=pages>
					<A class=p_pre
						href="http://localhost:8080/EasyBuy//admin/product?action=index&amp;currentPage=1">首页</A>
					<A class=cur
						href="http://localhost:8080/EasyBuy//admin/product?action=index&amp;currentPage=1">1</A>
					<A
						href="http://localhost:8080/EasyBuy//admin/product?action=index&amp;currentPage=2">2</A>
					<A
						href="http://localhost:8080/EasyBuy//admin/product?action=index&amp;currentPage=3">3</A>
					<A
						href="http://localhost:8080/EasyBuy//admin/product?action=index&amp;currentPage=4">4</A>
					<A class=p_pre
						href="http://localhost:8080/EasyBuy//admin/product?action=index&amp;currentPage=2">下一页</A>
					<A class=p_pre
						href="http://localhost:8080/EasyBuy//admin/product?action=index&amp;currentPage=8">尾页</A>
				</DIV>
			</DIV>
		</DIV>
		</DIV>
	</DIV>
	<%@include file="../public/Foot.jsp" %>
</BODY>
</HTML>
