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
						<use xlink:href="#stroked-home"></use></svg></a></li>
			<li><a href="/QuanLyHoSoBenhNhan/nhan-vien">Quản lý nhân
					viên</a></li>
			<li><a href="/QuanLyHoSoBenhNhan/nhan-vien/chuc-vu">Quản lý
					chức vụ</a></li>
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
		<h1>QUẢN LÝ CHỨC VỤ</h1>
	</div>
	<hr>
	<div class="content">
		<div class="row">
			<div class="col-sm-6 ">
				<form:form id="form" modelAttribute="themChucVuBean">
					<div class="row">
						<label class="control-label col-sm-4">Chức vụ:</label>
						<div class="input-group col-sm-8">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-briefcase"></i></span>
							<form:input path="tenChucVu" type="text" class="form-control"
								required="required" id="inputPhone" name="inputPhone"
								placeholder="Tên chức vụ" />
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-8"></div>
						<a href="/QuanLyHoSoBenhNhan/nhan-vien" class="btn btn-default">Quay
							lại</a>
						<form:button type="submit" class="btn btn-primary">Thêm</form:button>
					</div>
				</form:form>
			</div>
			<div class="col-sm-6">
				<table id="example" class="display">
					<thead>
						<th>STT</th>
						<th>Mã chức vụ</th>
						<th>Tên chức vụ</th>
						<th></th>
						<th></th>
					</thead>
					<tbody>
						<%
							int i = 1;
						%>
						<c:forEach var="listValue" items="${listCV}">
							<tr>
								<td><%=i%></td>
								<td>${listValue.getMaChucVu()}</td>
								<td>${listValue.getTenChucVu()}</td>
								<td align="center"><a href=""
									class="btn btn-info btn-block">Sửa</a></td>
								<td align="center"><a href=""
									class="btn btn-warning btn-block">Xóa</a></td>
							</tr>
							<%
								i++;
							%>
						</c:forEach>
					</tbody>
			</div>
		</div>
	</div>
</div>
<jsp:include page="layouts/bot.jsp"></jsp:include>