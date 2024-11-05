<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <form action="">
        Tên: <input name="ten"/>
        <button type="submit">Search</button>
    </form>
    <br/>
    <button><a href="">Add Student</a></button>
    <tr>
        <th>STT</th>
        <th>MSSV</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Địa chỉ</th>
        <th>Giới tính</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <%--
    for(Doi tuong sv : list){
    }
    Chi doi voi gia tri ma truyen tu servlet -> jsp : ${}
    items: dai dien cho 1 mang (danh sach)
    var: dai dien cho 1 Object
    varStatus
      --%>
    <c:forEach items="${a1}" var="sv" varStatus="i">
        <tr>
           <td>${i.index}</td>
           <td>${sv.mssv}</td>
           <td>${sv.ten}</td>
           <td>${sv.tuoi}</td>
           <td>${sv.diaChi}</td>
           <td>${sv.gioiTinh}</td>
            <td>Hanh dong</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
