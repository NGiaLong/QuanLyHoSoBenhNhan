<%@page import="org.springframework.ui.ModelMap"%>
<%@page import="org.springframework.ui.Model"%>
<%@page import="java.util.List"%>
<%@page import="com.model.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="layouts/top.jsp"></jsp:include>
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
	<div class="row">
		<ol class="breadcrumb">
			<li><a href="#"><svg class="glyph stroked home">
						<use xlink:href="#stroked-home"></use></svg></a></li>
		</ol>
	</div>
	<!--/.row-->
	<div class="header">
		<br>
		<c:if test="${success != null }">
			<div class="alert alert-success">${success }</div>
		</c:if>
		<c:if test="${error != null }">
			<div class="alert alert-danger">${error }</div>
		</c:if>
		<h1>NGƯNG HOẠT ĐỘNG</h1>
	</div>
	<hr>
	<div class="content">
		<div>
			</br>
		</div>
		<div>
			<table id="example" class="display">
				<thead>
					<th>STT</th>
					<th>Mã nhân viên</th>
					<th>Tên nhân viên</th>
					<th></th>
				</thead>
				<tbody>
					<%
						int i = 1;
					%>
					<c:forEach var="listValue" items="${nVList}">
						<tr>
							<td><%=i%></td>
							<td>${listValue.getMaNhanVien()}</td>
							<td>${listValue.getTenNhanVien()}</td>
							<td><a
								href="/QuanLyHoSoBenhNhan/nhan-vien/tai-hoat-dong/${listValue.getMaNhanVien()}"
								class="btn btn-info btn-block">Tái hoạt động hoạt động</a></td>
						</tr>
						<%
							i++;
						%>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<jsp:include page="layouts/bot.jsp"></jsp:include>