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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="language" value="${pageContext.request.locale}"/>
<fmt:setLocale value="${language}"/>

<!DOCTYPE html>
<html lang="${language}">
<head>
  <meta charset="utf-8">
  <title>Setup</title>
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

<body>

<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container">
      <a class="btn btn-navbar" data-toggle="collapse"
         data-target=".nav-collapse"> <span class="icon-bar"></span> <span
          class="icon-bar"></span> <span class="icon-bar"></span>
      </a> <a class="brand" href="#">Mediabase</a>
      <!--/.nav-collapse -->
    </div>
  </div>
</div>

<div class="container">

  <h1>Perficient Management System</h1>

  <h2>Seeded database with the following Timesheets</h2>
  <table width="1000">
    <tr>
      <td><b>Period</b></td>
      <td><b>Project</b></td>
      <td><b>Monday</b></td>
      <td><b>Tuesday</b></td>
      <td><b>Wednesday</b></td>
      <td><b>Thursday</b></td>
      <td><b>Friday</b></td>
      <td><b>Total</b></td>
      <td><b>Status</b></td>
    </tr>

    <c:forEach items="${requestScope.timesheets}" var="timesheet">
      <tr>
        <td>${ timesheet.period }</td>
        <td>${ timesheet.project }</td>
        <td>${ timesheet.monday }</td>
        <td>${ timesheet.tuesday }</td>
        <td>${ timesheet.wednesday }</td>
        <td>${ timesheet.thursday }</td>
        <td>${ timesheet.friday }</td>
        <td>${ timesheet.total }</td>
        <td>${ timesheet.status }</td>
      </tr>
    </c:forEach>

  </table>


  <h2>Seeded database with the following Tickets</h2>
  <table width="1000">
    <tr>
      <td><b>Name</b></td>
      <td><b>Description</b></td>
      <td><b>Team Lead</b></td>
      <td><b>Status</b></td>
      <td><b>Start Date</b></td>
      <td><b>End Date</b></td>
    </tr>

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

  </table>

  <h2>Continue</h2>
  <a href="timesheets">Go to main app</a>

</div>
<!-- /container -->
</body>
</html>
