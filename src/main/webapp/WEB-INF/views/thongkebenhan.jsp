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
		<h1>THỐNG KÊ BỆNH ÁN</h1>
	</div>
	<hr>
	<div class="content">
		<div class="row">
			<form action="benh-an" method="post">
				<div class="col-lg-12 form-inline">
					Chọn ngày: <input type="text" id="dateThongKeBenhAn"
						name="dateThongKeBenhAn"
						class="date-picker searchField form-control"> <select
						class="form-control" name="dateType" id="date-option">
						<option value="0">Theo ngày</option>
						<option value="1">Theo tháng</option>
						<option value="2">Theo năm</option>
					</select>
					<button type="submit" class="btn btn-primary">Tìm kiếm</button>
					<button type="button" class="btn btn-default resetField">Đặt
						lại</button>
				</div>

			</form>
		</div>
		<div>
			</br>
		</div>
		<div>
			<table id="example" class="display">
				<thead>
					<th>STT</th>
					<th>Mã bệnh án</th>
					<th>Nhân viên khám</th>
					<th>Ngày khám</th>
					<th>Tên bệnh nhân</th>
					<th>Giờ khám</th>
					<th></th>
				</thead>
				<tbody>
					<%
						int i = 1;
					%>
					<c:forEach var="listValue" items="${benhAnList}">
						<tr>
							<td><%=i%></td>
							<td>${listValue.getMaBenhAn()}</td>
							<td>${listValue.getTenNhanVien()}</td>
							<td>${listValue.getNgayKham() }</td>
							<td>${listValue.getTenBenhNhan() }</td>
							<td>${listValue.getGioKham() }</td>
							<td><a
								href="/QuanLyHoSoBenhNhan/thong-ke/benh-an/${listValue.getMaBenhAn()}"
								class="btn btn-primary btn-block">Chi tiết </a></td>
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