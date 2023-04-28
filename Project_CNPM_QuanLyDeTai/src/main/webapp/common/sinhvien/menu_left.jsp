<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/student" var="link"></c:url>

                    <div id="left-content">
                        <div class="col-md-3">
                            <!-- Menu desktop -->
                            <div id="desktop-menu">
                                <div class="panel panel-default">
                                    <div class="panel-heading" style="background-color: bisque;">
                                        <h4 id="mobile_home" style="font-weight: bold;">Danh Mục</h4>
                                    </div>
                                    
                                    <a href="${link}/home" class="list-group-item"><img src="<c:url value="/assets/public/images/house-icon.png"/>" width="24" height="24" /><span class="pull-right"></span> Trang Chủ</a>
                                    <a href="${link}/list-topic" class="list-group-item "><img src="<c:url value="/assets/public/images/Actions-view-calendar-list-icon.png"/>" width="24" height="24" /><span class="pull-right"></span> Danh sách đề tài</a>
                                    <a href="${link }/RegistrationInstructions" class="list-group-item "><img src="<c:url value="/assets/public/images/Actions-help-contents-icon.png"/>" width="24" height="24" /><span class="pull-right"></span> Hướng dẫn đăng ký</a>
                                    <a data-toggle="modal" href="#seach_box" class="list-group-item"><img src="<c:url value="/assets/public/images/Search-icon.png"/>" width="24" height="24" /><span class="pull-right"></span> Tìm kiếm</a>
                                </div><!-- /panel-default -->
                                <div class="panel panel-default">
									<div class="panel-heading" style="background-color: bisque;">
                    					<h4 id="mobile_sinhvien" style="font-weight: bold;">Sinh viên</h4>
                					</div>
					                <a href="${link}/info" class="list-group-item"><img src="<c:url value="/assets/public/images/Student-3-icon.png"/>" width="24" height="24"><span class="pull-right"></span> Quản trị tài khoản</a>
					                <a href="${link}/info-teacher" class="list-group-item "><img src="<c:url value="/assets/public/images/Teacher-icon.png"/>" width="24" height="24" /><span class="pull-right"></span> Thông tin giảng viên</a>
					                <a href="${link}/info-student" class="list-group-item "><img src="<c:url value="/assets/public/images/Student-3-icon.png"/>" width="24" height="24" /><span class="pull-right"></span> Thông tin sinh viên</a>
					                <a href="${link}/list-topic-register" class="list-group-item  "><img src="<c:url value="/assets/public/images/Actions-document-edit-icon.png"/>" width="24" height="24"><span class="pull-right"></span> Đăng ký đề tài</a>
					                <a href="${link}/group" class="list-group-item  "><img src="<c:url value="/assets/public/images/user-group-icon.png"/>" width="24" height="24"><span class="pull-right"></span> Quản lý nhóm</a>
					               	<a href="${link}/doimatkhau" class="list-group-item  "><img src="<c:url value="/assets/public/images/key.png"/>" width="24" height="24"><span class="pull-right"></span> Đổi mật khẩu</a>             
					                <a href="./logout" class="list-group-item"><img src="<c:url value="/assets/public/images/Apps-session-logout-icon.png"/>" width="24" height="24"><span class="pull-right"></span> Đăng xuất</a>
               			 			<div class="modal fade" id="change_info">
                   	 					<div class="modal-dialog">
                        					<div class="modal-content">


				
			</div>
			<!-- /panel-default -->
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 id="mobile_sinhvien">Sinh viên</h4>
				</div>
				
				<div class="modal fade" id="change_info">
					<div class="modal-dialog">
						<div class="modal-content"></div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->
			</div>
</div>
</div>
</div>




			<!--============================Bench==================-->

			<!-- Modal Who online -->
			<div class="modal fade" id="who_online" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">Online Users</h4>
						</div>
						<div class="modal-body">
							<table class="table table-striped">
								<thead>
									<tr>
										<td>STT</td>
										<td>Tên SV</td>
									</tr>
								</thead>
							</table>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>
			
			<!-- ########################### Form ###########################-->
			<!-- =========================Tìm kiếm box================================ -->
			<div class="modal fade" id="seach_box">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title">Tìm kiếm</h4>
						</div>
						<form action="./search" method="get" id="cpa-form">
							<div class="modal-body">
								<div id="err_tk"></div>
								<select class="form-control text-center" name="param_option"
									id="tim_kiem_tong_hop">
									<option value="timkiemgiangvien">Tìm kiếm giảng viên</option>
									<option value="timkiemsinhvien">Tìm kiếm sinh viên</option>
									<option value="timkiemdetai">Tìm kiếm đề tài</option>
								</select> <br /> <label>Nhập từ khoá :</label> <input type="text"
									class="form-control" id="parameter1" name="param_textbox"
									value="" placeholder="Mọi thứ..." />
								<div class="clear"></div>
								<div id="search_advance">
									<br />
									<div id="type_detai" style="display: none;">

										<fieldset>
											<legend>Chọn loại đề tài</legend>
											<c:forEach items="${signs}" var="signs">
												<input type="radio" name="group_loaidt"
													value="${signs.yEnd }" />
												<span>Tiểu luận chuyên ngành | Khóa ${signs.yEnd }<br />
												</span>
											</c:forEach>

										</fieldset>
									</div>
									<!-- End #search_advance -->
								</div>
								<!--End body -->
								<div class="modal-footer">
									<button type="submit" class="btn btn-primary" id="timkiem_btn">Tìm
										kiếm</button>
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</form>

					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->
			</div>
		</div>
		
		<!-- ===================================Ajax========================= -->
		<script>
                            $(document).ready(function () {
                                $("#cpa-form").submit(function (e) {
                                    if ($("#parameter1").val() == '') {
                                        $('#err_tk').html('<div class="alert alert-danger">Vui lòng nhập từ khoá tìm kiếm</div>');
                                        $("#parameter1").focus();
                                        return false;
                                    }
                                    if ($('#tim_kiem_tong_hop').val() == "timkiemdetai")
                                    {
                                        //$('*[name=group_loaidt]').is(":not(:checked)") kiểm tra radio chưa check

                                        if ($("*[name=group_loaidt]").is(":checked")) {
                                            return true;
                                        }
                                        else //radio chưa check
                                        {
                                            $('#err_tk').html('<div class="alert alert-danger">Vui lòng chọn loại đề tài</div>');
                                            return false;
                                        }
                                    }
                                });
                            })
                        </script>

	</div>
</div>
