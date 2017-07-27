<%@page import="util.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="../public/Header.jsp"%>
</HEAD>
<BODY class="bg_color">
 	<div class="top bg_color">
        <div class="logo"><a href="Index.html"><img src="${path }/statics/images/logo.png" /></a></div>
    </div>
	<!--End Header End-->
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
						<LI><A class=now
							href="http://localhost:8080/EasyBuy/admin/productCategory?action=index">分类管理</A>
						</LI>
						<LI><A
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
				<DIV class=mem_tit>分类列表</DIV>
				<P align=right>
					<A class=add_b onclick=toAddProductCategory();
						href="javascript:showUpdate();">修改分类</A> <BR>
				</P>
				<BR>
				<TABLE style="TEXT-ALIGN: center; WIDTH: 930px; MARGIN-BOTTOM: 30px"
					class=order_tab border=0 cellSpacing=0 cellPadding=0>
					<TBODY>
						<TR>
							<TD width="5%">选择</TD>
							<TD width="20%">分类名称</TD>
							<TD width="25%">分类级别</TD>
							<TD width="25%">父级分类</TD>
							<TD width="25%">操作</TD>
						</TR>
						<c:forEach items="${rd.data }" var="c">
						<TR>
							<TD width="5%"><INPUT
								onclick=toUpdateProductCategoryList(this); value=548 type=radio
								name=select></TD>
							<TD>${c.name }</TD>
							<TD>${c.type==1?"一":c.type==2?"二":"三"}级分类</TD>
							
							<TD><c:out value="${c.parentName}" default="无"></c:out></TD>
							<TD><A href="javascript:del();">删除</A></TD>
						</TR>
						</c:forEach>
					</TBODY>
				</TABLE>

				<DIV class=pages>
					<A class=p_pre
						href="${path }/server?method=getCategorys&n=1">首页</A>
					<%
						Page p = (Page)request.getAttribute("p");
						Integer totalPage = p.getTotalPage();//获取总页数
						Integer startNum = (Integer)request.getAttribute("startNum");
						for(int i = startNum;i<(startNum+3<totalPage?startNum+3:totalPage);i++){
							request.setAttribute("i",i+1);
							%>
								<A class="clac" href="${path }/server?method=getCategorys&n=${i}&startNum=${startNum}">${i}</A>
							<%
						}
					%>
						<a href="${path }/server?method=getCategorys&n=${startNum+4<p.totalPage?startNum+4:p.totalPage}&flag=more&startNum=${startNum}">更多...</a>
					<%-- <A class=p_pre
						href="${path }/server?method=getCategorys&n=${p.n>=p.totalPage?p.totalPage:p.n+1}">下一页</A> --%>
					<A class=p_pre
						href="${path }/server?method=getCategorys&n=${p.totalPage}">尾页</A>
				</DIV>
				<SCRIPT type=text/javascript>
					function del(){
						alert(11);
					}
					$(".clac").each(function(i){
						if($(this).html()==<%=request.getParameter("n")%>){
							$(this).attr("class","cur");
						}
					});
					
					function showUpdate(){
						$("#addProductCategory").show();
					}
					
					$(function(){
						$("#productCategoryLevel1").on("change",function(){
							if($("#type").val()==3){
								$("#productCategoryLevel2").parent().parent().show();
								$("#productCategoryLevel2").html('<option value="0" selected="selected">请选择...</option>');
								var parentId = $(this).val();
								$.ajax({
									url:"server",
									type:"post",
									data:{"parentId":parentId,"method":"loadParentType"},
									dataType:"json",
									success:function(data){
										if(data != null){
											var result = data.data;
											for(var i=0;i<result.length;i++){
												$("#productCategoryLevel2").append('<option value="'+result[i].id+'" selected="selected">'+result[i].name+'</option>');
											}
										}
									},
									error:function(){
										console.log("服务器异常");
									}
									
								})
							}
						})
						
						$("#type").on("change",function(){
							if($(this).val()==1){
								$("#productCategoryLevel1").parent().parent().hide();
								$("#productCategoryLevel2").parent().parent().hide();
								return false;
							}
							if($(this).val()!=1){
								$("#productCategoryLevel1").parent().parent().show();
								$("#productCategoryLevel2").parent().parent().hide();
								$("#productCategoryLevel1").html('<option value="0" selected="selected">请选择...</option>');
								 $.ajax({
									url:"server",
									type:"post",
									data:{"type":1,"method":"loadCate"},
									dataType:"json",
									success:function(data){
										if(data != null){
											var result = data.data;
											for(var i=0;i<result.length;i++){
												$("#productCategoryLevel1").append('<option value="'+result[i].id+'" selected="selected">'+result[i].name+'</option>');
											}
										}
									},
									error:function(){
										console.log("服务器异常");
									}
									
								})
								return false;
							}
						})
					})
				</SCRIPT>
				<!-- 添加分类 begin-->
				<DIV id=addProductCategory hidden>
					<table border="0" class="add_tab" style="width:930px;"
						cellspacing="0" cellpadding="0">
						<tr>
							<td width="135" align="right">分类级别</td>
							<td colspan="3" style="font-family:'宋体';">
							<select  name="type" style="background-color:#f6f6f6;" id="type">
									<option value="0" selected="selected">请选择...</option>
									<option value="1">一级分类</option>
									<option value="2">二级分类</option>
									<option value="3">三级分类</option>
							</select></td>
						</tr>
						<tr hidden>
							<td width="135" align="right">一级分类</td>
							<td colspan="3" style="font-family:'宋体';">
							<select  name="productCategoryLevel1" style="background-color:#f6f6f6;"
								id="productCategoryLevel1">
									<option value="0" selected="selected">请选择...</option>
							</select></td>
						</tr>
						<tr hidden>
							<td width="135" align="right">二级分类</td>
							<td><select  name="productCategoryLevel2" style="background-color:#f6f6f6;" id="productCategoryLevel2">
									<option value="0" selected="selected">请选择...</option>
							</select></td>
						</tr>
						<tr>
							<td align="right">分类名称</td>
							<td style="font-family:'宋体';"><input type="text" value=""
								class="add_ipt" id="name" />（必填） <input type="hidden" name="id"
								value="" id="id"></td>
						</tr>
					</table>
					<p align="right">
						<br> <a href="javascript:void(0);" onclick="saveOrUpdate();"
							class="add_b">确认修改</a>
					</p>
				</DIV>
				<!-- 添加分类end -->
			</DIV>
		</DIV>
	</DIV>
	<%@include file="../public/Foot.jsp"%>
</BODY>
</HTML>
