<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/" var="link"></c:url>
    
<div class="panel panel-default">
    <div style="color: rgb(7, 132, 163);" class="panel-heading">
        <h4 style="font-family: verdana;color:rgb(87,87,87);">Danh sách các sinh viên đã được cấp tài khoản</h4>
    </div>
    <div class="panel-body">
        <table class="table demo footable-loaded footable" data-page-size="5">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Tên sinh viên</th>
                    <th>Giới tính</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Chuyên ngành</th>
                </tr>
            </thead>
            <tbody>
				<c:forEach items="${lstStudent }" var="student">
                     <tr>                  	
                        <td>${student.studentId }</td>
                        <td>${student.studentName }</td>
                        <td>
                        	<c:if test="${student.gender==true }">
                        		Nam
                        	</c:if>
                        	<c:if test="${student.gender==false }">
                        		Nữ
                        	</c:if>
                        </td>
                        <td>${student.email }</td>
                        <td>${student.phone }</td>
                        <td>${student.majorName }</td>
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