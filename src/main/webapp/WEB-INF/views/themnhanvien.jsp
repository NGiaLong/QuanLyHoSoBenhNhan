<%@page import="org.springframework.ui.ModelMap"%>
<%@page import="org.springframework.ui.Model"%>
<%@page import="java.util.List"%>
<%@page import="com.model.NhanVien"%>
<%@page import="com.model.ChucVu"%>
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
			<li><a href="/QuanLyHoSoBenhNhan/nhan-vien/them-nhan-vien">Thêm
					nhân viên</a></li>
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
		<h1>THÊM NHÂN VIÊN</h1>
	</div>
	<hr>
	<div class="content">
		<form:form id="form" modelAttribute="themNhanVienBean">
			<div class="row">
				<div class="form-group col-sm-6 ">
					<label class="control-label col-sm-4">Tên nhân viên:</label>
					<div class="input-group col-sm-8">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span>
						<form:input path="tenNhanVien" type="text" class="form-control"
							required="required" id="inputPhone" name="inputPhone"
							placeholder="Tên nhân viên" />
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 ">Giới tính:</label>
					<div class="radio-inline col-sm-8">
						<label class="col-sm-4"><form:radiobutton path="gioiTinh"
								value="true" class="radio" />Nam</label> <label class="col-sm-4"><form:radiobutton
								path="gioiTinh" value="false" class="radio" />Nữ</label>
					</div>
				</div>
				
			</div>
			<div class="row">
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 ">Ngày sinh:</label>
					<div class="input-group date col-sm-8">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-calendar"></i></span>
						<form:input path="ngaySinh" type="date" class="form-control"
							required="required" id="inputDate" name="inputDate"
							placeholder="Ngày sinh" />
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 ">Số điện thoại:</label>
					<div class="input-group col-sm-8">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-phone"></i></span>
						<form:input path="soDienThoai" type="number" class="form-control"
							required="required" id="inputPhoneNumber" name="inputPhoneNumber"
							placeholder="Số điện thoại" />
					</div>
				</div>
			</div>
			<div class="row">

				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 ">Địa Chỉ:</label>
					<div class="input-group col-sm-8">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-home"></i></span>
						<form:input path="diaChi" type="text" class="form-control"
							required="required" id="inputPhoneNumber" name="inputPhoneNumber"
							placeholder="Địa chỉ" />
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 ">Chức vụ:</label>
					<div class="input-group col-sm-8">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-briefcase"></i></span>
						<form:select path="maChucVu" class="form-control">
						<c:forEach var="cV" items="${listCV}">
							<form:option value="${cV.getMaChucVu()}">${cV.getTenChucVu()}</form:option>
						</c:forEach>
						</form:select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-8"></div>
				<a href="/QuanLyHoSoBenhNhan/nhan-vien"
					class="btn btn-default">Quay lại</a>
				<form:button type="submit" class="btn btn-primary">Thêm</form:button>
			</div>

		</form:form>
	</div>
</div>
<jsp:include page="layouts/bot.jsp"></jsp:include>