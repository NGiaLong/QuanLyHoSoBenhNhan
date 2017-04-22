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
			<li><a href=""><svg class="glyph stroked home">
						<use xlink:href="#stroked-home"></use></svg></a>
			</li>
			<li><a href="/QuanLyHoSoBenhNhan/nhan-vien">Quản lý nhân viên</a></li>
			<li><a href="/QuanLyHoSoBenhNhan/nhan-vien/sua-nhan-vien">Sửa nhân viên</a></li>
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
		<h1>SỬA NHÂN VIÊN</h1>
	</div>
	<hr>
	<div class="content">
	
	</div>
</div>
<jsp:include page="layouts/bot.jsp"></jsp:include>