<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品页面</title>
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
						<LI><A
							href="http://localhost:8080/EasyBuy/admin/product?action=index">商品管理</A>
						</LI>
						<LI><A class=now
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
				<DIV class=mem_tit>添加商品</DIV>
				<BR>
				<FORM id=productAdd encType=multipart/form-data
					onsubmit="return checkProduct();" method=post
					action=/EasyBuy/admin/product?action=addProduct>
					<TABLE style="WIDTH: 930px" class=add_tab border=0 cellSpacing=0
						cellPadding=0>
						<TBODY>
							<TR>
								<TD width=135 align=right>一级分类</TD>
								<TD style="FONT-FAMILY: '宋体'" colSpan=3><SELECT
									style="BACKGROUND-COLOR: #f6f6f6" id=productCategoryLevel1
									onchange="queryProductCategoryList(this,'productCategoryLevel2');"
									name=categoryLevel1Id>
										<OPTION selected value="">请选择...</OPTION>
										<OPTION value=548>化妆品</OPTION>
										<OPTION value=628>家用商品</OPTION>
										<OPTION value=660>进口食品,生鲜</OPTION>
										<OPTION value=670>电子商品</OPTION>
										<OPTION value=676>保健食品</OPTION>
										<OPTION value=681>箱包</OPTION>
								</SELECT></TD>
							</TR>
							<TR>
								<TD width=135 align=right>二级分类</TD>
								<TD><SELECT style="BACKGROUND-COLOR: #f6f6f6"
									id=productCategoryLevel2
									onchange="queryProductCategoryList(this,'productCategoryLevel3');"
									name=categoryLevel2Id>
										<OPTION selected value=0>请选择...</OPTION>
								</SELECT></TD>
							</TR>
							<TR>
								<TD width=135 align=right>三级分类</TD>
								<TD><SELECT style="BACKGROUND-COLOR: #f6f6f6"
									id=productCategoryLevel3 name=categoryLevel3Id>
										<OPTION selected value=0>请选择...</OPTION>
								</SELECT></TD>
							</TR>
							<TR>
								<TD width=135 align=right>商品名称</TD>
								<TD><INPUT id=name class=add_ipt name=name>（必填） <INPUT
									id=id type=hidden name=id></TD>
							</TR>
							<TR>
								<TD width=135 align=right>商品图片</TD>
								<TD><INPUT class=text type=file name=photo><SPAN></SPAN>
								</TD>
							</TR>
							<TR>
								<TD width=135 align=right>单价</TD>
								<TD><INPUT id=price class=add_ipt name=price></TD>
							</TR>
							<TR>
								<TD width=135 align=right>库存</TD>
								<TD><INPUT id=stock class=add_ipt name=stock></TD>
							</TR>
							<TR>
								<TD width=135 align=right>描述</TD>
								<TD><TEXTAREA name=description></TEXTAREA></TD>
							</TR>
							<TR>
								<TD></TD>
								<TD><INPUT class=s_btn value=商品上架 type=submit></TD>
							</TR>
						</TBODY>
					</TABLE>
				</FORM>
			</DIV>
		</DIV>
			<%@include file="../public/Foot.jsp" %>
		</DIV>
</BODY>
</HTML>
