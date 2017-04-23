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
			<li><a href="">Sửa nhân viên</a></li>
			<li><a
				href="/QuanLyHoSoBenhNhan/nhan-vien/sua-nhan-vien/${nV.getMaNhanVien() }">${nV.getTenNhanVien() }</a></li>
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
		<form:form id="form" modelAttribute="suaNhanVienBean">
			<div class="row">
				<div class="form-group col-sm-6 ">
					<label class="control-label col-sm-4">Mã nhân viên:</label>
					<div class="input-group col-sm-8">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span>
						<form:input path="maNhanVien" type="text" class="form-control"
							required="required" id="inputPhone" name="inputPhone"
							value="${nV.getMaNhanVien() }" disabled="true" />
					</div>
				</div>
				<div class="form-group col-sm-6 ">
					<label class="control-label col-sm-4">Tên nhân viên:</label>
					<div class="input-group col-sm-8">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span>
						<form:input path="tenNhanVien" type="text" class="form-control"
							required="required" id="inputPhone" name="inputPhone"
							value="${nV.getTenNhanVien() }" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 ">Giới tính:</label>
					<div class="radio-inline col-sm-8">
						<c:choose>
							<c:when test="${nV.isGioiTinh() }">
								<label class="col-sm-4"><form:radiobutton
										path="gioiTinh" value="false" class="radio" />Nữ</label>
								<label class="col-sm-4"><form:radiobutton
										path="gioiTinh" value="true" class="radio" checked="true" />Nam</label>
							</c:when>
							<c:otherwise>
								<label class="col-sm-4"><form:radiobutton
										path="gioiTinh" value="false" class="radio" checked="true" />Nữ</label>
								<label class="col-sm-4"><form:radiobutton
										path="gioiTinh" value="true" class="radio" />Nam</label>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 ">Ngày sinh:</label>
					<div class="input-group date col-sm-8">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-calendar"></i></span>
						<form:input path="ngaySinh" type="date" class="form-control"
							required="required" id="inputDate" name="inputDate"
							value="${nV.getNgaySinh() }" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 ">Số điện thoại:</label>
					<div class="input-group col-sm-8">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-phone"></i></span>
						<form:input path="soDienThoai" type="number" class="form-control"
							required="required" id="inputPhoneNumber" name="inputPhoneNumber"
							value="${nV.getSoDienThoai() }" />
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 ">Địa Chỉ:</label>
					<div class="input-group col-sm-8">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-home"></i></span>
						<form:input path="diaChi" type="text" class="form-control"
							required="required" id="inputPhoneNumber" name="inputPhoneNumber"
							value="${nV.getDiaChi() }" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 ">Chức vụ:</label>
					<div class="input-group col-sm-8">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-briefcase"></i></span>
						<form:select path="maChucVu" class="form-control">
							<c:forEach var="cV" items="${listCV}">
								<c:choose>
									<c:when test="${cV.getMaChucVu()==nV.getMaChucVu()}">
										<form:option value="${cV.getMaChucVu()}" selected="true">${cV.getTenChucVu()}</form:option>
									</c:when>
									<c:otherwise>
										<form:option value="${cV.getMaChucVu()}">${cV.getTenChucVu()}</form:option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</form:select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-8"></div>
				<a href="/QuanLyHoSoBenhNhan/nhan-vien/huy" class="btn btn-danger">Hủy</a>
				<form:button type="submit" class="btn btn-primary">Sửa</form:button>
			</div>
		</form:form>
		<br>
	</div>
</div>
<jsp:include page="layouts/bot.jsp"></jsp:include>