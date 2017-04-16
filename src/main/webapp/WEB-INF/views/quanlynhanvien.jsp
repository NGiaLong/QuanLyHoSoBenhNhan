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
		<h1>QUẢN LÝ NHÂN VIÊN</h1>
	</div>
	<hr>
	<div class="content">
		<div class="row">
			<div class="col-lg-10"></div>
			<div class="col-lg-2">
				<a href="/LibraryManagement/add-staff"><input
					class="btn btn-primary btn-large btn-block" type="submit"
					value="Tạo nhân viên"></a>

			</div>
		</div>
		<div>
			</br>
		</div>
		<div>
			<table id="example" class="display">
				<thead>
					<th>STT</th>
					<th>Mã nhân viên</th>
					<th>Tên nhân viên</th>
					<th>Giới tính</th>
					<th>Ngày sinh</th>
					<th>Địa chỉ</th>
					<th>Số điện thoại</th>
					<th>Mã chức vụ</th>
					<th></th>
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
							<td><c:choose>
									<c:when test="${listValue.isGioiTinh() }">
										<c:out value="Nam"></c:out>
									</c:when>
									<c:otherwise>
										<c:out value="Nữ"></c:out>
									</c:otherwise>
								</c:choose></td>

							<td>${listValue.getNgaySinh() }</td>
							<td>${listValue.getDiaChi() }</td>
							<td>${listValue.getSoDienThoai() }</td>
							<td>${listValue.getMaChucVu() }</td>
							<td><a href="" class="btn btn-primary btn-block">Sửa </a></td>
							<td><a href="" class="btn btn-warning btn-block">Ngưng
									hoạt động</a></td>
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