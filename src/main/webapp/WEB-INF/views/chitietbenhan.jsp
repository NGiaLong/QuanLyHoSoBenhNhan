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
		<h1>CHI TIẾT BỆNH ÁN</h1>
	</div>
	<hr>
	<div class="content">
		<div class="row">
			<h2 class="text-center"><span class="label label-info">Thông tin bệnh nhân</span></h2>
			<div class="col-md-6">
				<div class="col-md-4">
					<div class="form-group">
						<h3>
							<b>Mã bệnh nhân:</b>
						</h3>
					</div>
					<div class="form-group">
						<h3>
							<b>Tên bệnh nhân:</b>
						</h3>
					</div>
					<div class="form-group">
						<h3>
							<b>Ngày tạo:</b>
						</h3>
					</div>
					<div class="form-group">
						<h3>
							<b>Ngày sinh:</b>
						</h3>
					</div>

				</div>
				<div class="col-md-8">
					<div class="form-group">
						<h3>${benhNhan.getMaBenhNhan() }</h3>
					</div>
					<div class="form-group">
						<h3>${benhNhan.getTenBenhNhan() }</h3>
					</div>
					<div class="form-group">
						<h3>${benhNhan.getNgayTao() }</b>
						</h3>
					</div>
					<div class="form-group">
						<h3>${benhNhan.getNgaySinh() }</h3>
					</div>

				</div>
			</div>
			<div class="col-md-6">
				<div class="col-md-4">
					<div class="form-group">
						<h3>
							<b>Giới tính:</b>
						</h3>
					</div>
					<div class="form-group">
						<h3>
							<b>Địa chỉ:</b>
						</h3>
					</div>
					<div class="form-group">
						<h3>
							<b>Số điện thoại:</b>
						</h3>
					</div>
				</div>
				<div class="col-md-8">
					<div class="form-group">
						<h3>
							<c:choose>
								<c:when test="${benhNhan.isGioiTinh() }">
									<c:out value="Nam"></c:out>
								</c:when>
								<c:otherwise>
									<c:out value="Nữ"></c:out>
								</c:otherwise>
							</c:choose>
						</h3>
					</div>
					<div class="form-group">
						<h3>${benhNhan.getDiaChi() }</h3>
					</div>
					<div class="form-group">
						<h3>${benhNhan.getSoDienThoai() }</h3>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<div class="row">
			<h2 class="text-center"><span class="label label-success">Thông tin bệnh án</span></h2>
			<div class="col-md-6">
				<div class="col-md-4">
					<div class="form-group">
						<h3>
							<b>Mã bệnh án:</b>
						</h3>
					</div>
					<div class="form-group">
						<h3>
							<b>Ngày khám:</b>
						</h3>
					</div>
					<div class="form-group">
						<h3>
							<b>Giờ khám:</b>
						</h3>
					</div>

				</div>
				<div class="col-md-8">
					<div class="form-group">
						<h3>${benhAn.getMaBenhAn() }</h3>
					</div>
					<div class="form-group">
						<h3>${benhAn.getNgayKham() }</h3>
					</div>
					<div class="form-group">
						<h3>${benhAn.getGioKham() }</b>
						</h3>
					</div>

				</div>
			</div>
			<div class="col-md-6">
				<div class="col-md-4">

					<div class="form-group">
						<h3>
							<b>Nhân viên khám:</b>
						</h3>
					</div>
					<div class="form-group">
						<h3>
							<b>Triệu chứng:</b>
						</h3>
					</div>
					<div class="form-group">
						<h3>
							<b>Chẩn đoán:</b>
						</h3>
					</div>
				</div>
				<div class="col-md-8">

					<div class="form-group">
						<h3>${nhanVien.getTenNhanVien() }</h3>
					</div>
					<div class="form-group">
						<h3>${benhAn.getTrieuChung() }</h3>
					</div>
					<div class="form-group">
						<h3>${benhAn.getChanDoan() }</h3>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="layouts/bot.jsp"></jsp:include>