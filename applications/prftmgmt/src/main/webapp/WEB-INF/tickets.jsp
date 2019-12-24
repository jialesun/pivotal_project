<<%--
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="language" value="${pageContext.request.locale}"/>
<fmt:setLocale value="${language}"/>

<!DOCTYPE html>
<html lang="${language}">
<head>
    <meta charset="utf-8">
    <title>Podcasts</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="../assets/css/bootstrap.css" rel="stylesheet">
    <link href="../assets/css/movie.css" rel="stylesheet">
    <style>
        body {
            padding-top: 60px;
            /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>
    <link href="../assets/css/bootstrap-responsive.css" rel="stylesheet">

</head>

<script>
function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
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
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">Perficient Management System</a>
        </div>
    </div>
</div>

<div class="container">

    <h1>Tickets</h1>
     <form class="movie-input-form form-inline" modelAttribute="addTicket" action="#" th:action="@{/tickets}" th:object="${TicketUI}"
                    method="post">
                <p>Add Tickets</p>
                <input path="name" type="text" th:field="*{name}" name="name" placeholder="Name" size="14"/>
                <input path="description" type="text" th:field="*{description}" name="description" placeholder="description" size="14"/>
                <input path="teamLead" type="text" th:field="*{teamLead}" name="teamLead" placeholder="teamLead" size="14"/>
                <input type="submit" name="action" class="btn btn-primary" value="Add"/>
        </form>
    <input id="myInput" type="text" onkeyup="myFunction()" placeholder="Search..."/>

    <table id="myTable" class="table table-striped table-bordered">

        <thead>
            <tr>
                <td><b>Name</b></td>
                <td><b>Description</b></td>
                <td><b>Team Lead</b></td>
                <td><b>Status</b></td>
                <td><b>Start Date</b></td>
                <td><b>End Date</b></td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.tickets}" var="ticket">
                <tr>
                    <td> ${ticket.name} </td>
                    <td> ${ticket.description} </td>
                    <td> ${ticket.teamLead} </td>
                    <td> ${ticket.status} </td>
                    <td> ${ticket.stDate} </td>
                    <td> ${ticket.endDate} </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


</div>
<!-- /container -->
</body>
</html>
