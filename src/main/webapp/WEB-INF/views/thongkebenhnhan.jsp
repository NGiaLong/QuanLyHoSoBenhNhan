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
		<h1>THỐNG KÊ BỆNH NHÂN</h1>
	</div>
	<hr>
	<div class="content">
		<div class="row">
			<form action="benh-an" method="post">
				<div class="col-lg-12 form-inline">
					Chọn ngày: <input type="text" id="dateFrom" name="dateFrom"
						class="date-picker searchField form-control"> <input
						type="text" id="dateTo" name="dateTo"
						class="date-picker searchField form-control">
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
					<th>Mã bệnh nhân</th>
					<th>Tên bệnh nhân</th>
					<th>Ngày sinh</th>
					<th>Số lần khám</th>					
					<th></th>
				</thead>
				<tbody>
					<%
						int i = 1;
					%>
					<c:forEach var="listValue" items="${benhNhanList}">
						<tr>
							<td><%=i%></td>
							<td>${listValue.getMaBenhNhan()}</td>
							<td>${listValue.getTenBenhNhan()}</td>
							<td>${listValue.getNgaySinh() }</td>
							<td>${listValue.getSoLanKham() }</td>							
							<td><a
								href="/QuanLyHoSoBenhNhan/thong-ke/benh-an/${listValue.getMaBenhNhan()}"
								class="btn btn-primary btn-block">Chi tiết </a></td>
						</tr>
						<%
							i++;
						%>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<h3><span class="label label-info">Tổng số bệnh nhân: ${tongSo}</span></h3>
	</div>
</div>
<jsp:include page="layouts/bot.jsp"></jsp:include>