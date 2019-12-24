<%--
    Licensed to the Apache Software Foundation (ASF) under one or more
    contributor license agreements.  See the NOTICE file distributed with
    this work for additional information regarding copyright ownership.
    The ASF licenses this file to You under the Apache License, Version 2.0
    (the "License"); you may not use this file except in compliance with
    the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language" value="${pageContext.request.locale}"/>
<fmt:setLocale value="${language}"/>

<!DOCTYPE html>
<html lang="${language}">
<head>
  <meta charset="utf-8">
  <title>Timesheets</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- Le styles -->
  <link href="assets/css/bootstrap.css" rel="stylesheet">
  <link href="assets/css/movie.css" rel="stylesheet">
  <style>
    body {
      padding-top: 60px;
      /* 60px to make the container go all the way to the bottom of the topbar */
    }
  </style>
  <link href="assets/css/bootstrap-responsive.css" rel="stylesheet">

</head>
<script>
function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}
</script>
<body>

<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container">
      <a class="btn btn-navbar" data-toggle="collapse"
         data-target=".nav-collapse"> <span class="icon-bar"></span> <span
          class="icon-bar"></span> <span class="icon-bar"></span>
      </a> <a class="brand" href="#">Perficient Management System</a>


      <!--/.nav-collapse -->
    </div>
  </div>
</div>

<div class="container">

  <h1>Timesheets</h1>

  <form class="movie-input-form form-inline" action="timesheets"
        method="post">
    <p>Add Movie</p>
    <input type="text" name="period" placeholder="Period" size="4"/>
    <input type="text" name="project" placeholder="Project" size="20"/>
    <input type="text" name="m" placeholder="m" size="4"/>
    <input type="text" name="t" placeholder="t" size="4"/>
    <input type="text" name="w" placeholder="w" size="4"/>
    <input type="text" name="th" placeholder="th" size="4"/>
    <input type="text" name="f" placeholder="f" size="4"/>
    <input type="submit" name="action" class="btn btn-primary" value="Add"/>
  </form>
<input id="myInput" type="text" onkeyup="myFunction()" placeholder="Search Project Name..."/>
  <table id="myTable" class="table table-striped table-bordered">
    <thead>
    <tr>
      <th><b>Period</b></th>
      <th><b>Project</b></th>
      <th><b>Monday</b></th>
      <th><b>Tuesday</b></th>
      <th><b>Wednesday</b></th>
      <th><b>Thursday</b></th>
      <th><b>Friday</b></th>
      <th><b>Total</b></th>
      <th><b>Status</b></th>
      <th>&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${timesheets}" var="timesheet">
      <tr>
        <td><c:out value="${timesheet.period}"/></td>
        <td><c:out value="${timesheet.project}"/></td>
        <td><c:out value="${timesheet.monday}"/></td>
        <td><c:out value="${timesheet.tuesday}"/></td>
        <td><c:out value="${timesheet.wednesday}"/></td>
        <td><c:out value="${timesheet.thursday}"/></td>
        <td><c:out value="${timesheet.friday}"/></td>
        <td><c:out value="${timesheet.total}"/></td>
        <td><c:out value="${timesheet.status}"/></td>
        <td><a href="?action=Remove&id=${timesheet.id}"><i
            class="icon-trash"></i></a></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <c:if test="${count > 0}">
    <c:if test="${page > 1}">
      <a href="<c:url value="timesheets"><c:param name="page" value="${page - 1}"/><c:param name="field" value="${field}"/><c:param name="key" value="${key}"/></c:url>">&lt; Prev</a>&nbsp;
    </c:if>
    Showing records ${start} to ${end} of ${count}
    <c:if test="${page < pageCount}">
      &nbsp;<a href="<c:url value="timesheets"><c:param name="page" value="${page + 1}"/><c:param name="field" value="${field}"/><c:param name="key"
                                                                                                                                        value="${key}"/></c:url>">Next &gt;</a>
    </c:if>
  </c:if>
</div>
<!-- /container -->
</body>
</html>
