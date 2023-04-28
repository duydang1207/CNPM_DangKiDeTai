<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<div class="panel panel-default">
    <div style="color: rgb(7, 132, 163);" class="panel-heading">
        <h4 style="font-family: verdana;color:rgb(87,87,87);">Danh sách giảng viên</h4>
    </div>
    <a class="btn btn-success" type="button" style="    font-size: 20px;
    height: 45px;
    width: 30%;
    font-weight: bold;
    margin: 15px;"
	href="<c:url value='./add?role=2'/>">Thêm giảng viên</a>
    <div class="panel-body">
        <table class="table demo footable-loaded footable" data-page-size="5">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Tên giảng viên</th>
                    <th>Giới tính</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Chuyên ngành</th>
                    <th>Chức năng</th>
                </tr>
            </thead>
            <tbody>
				<c:forEach items="${lstTeacher }" var="teacher">
                     <tr>                  	
                        <td>${teacher.teacherId }</td>
                        <td>${teacher.teacherName }</td>
                        <td>
                        	<c:if test="${teacher.gender==true }">
                        		Nam
                        	</c:if>
                        	<c:if test="${teacher.gender==false }">
                        		Nữ
                        	</c:if>
                        </td>
                        <td>${teacher.email }</td>
                        <td>${teacher.phone }</td>
                        <td>${teacher.majorName }</td>
                        <td style="width: 55px;">
	                        <a class="btn btn-success" type="button"
								href="<c:url value='manage-teacher/edit?id=${teacher.teacherId }'/>">TT</a> 
						</td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="5"></td>
                </tr>
            </tfoot>
        </table>
    </div>
</div>