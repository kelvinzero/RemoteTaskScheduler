
<%@ page import="scheduler.utilities.TimeBox" %>
<%@ page import="scheduler.utilities.HTMLBuilder" %>
<%@ page import="javax.swing.text.html.HTML" %>
<%@ page import="scheduler.taskhandler.*" %><%--
  Created by IntelliJ IDEA.
  User: Josh Cotes
  Date: 10/28/2017
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="timebox" class="scheduler.utilities.TimeBox" scope="application"/>
<jsp:setProperty name="timebox" property="*"/>

<html>
<head>
    <link rel="stylesheet" href="schedulerstyles.css">
    <title>Josh's Scheduler</title>
</head>
<body>
<script src="tablescript.js"></script>
<div class="pageCenter">
    <div style="float:left">
        <h4>Scheduler v1.0 rev2<br/>Joshua Cotes 2017</h4>
    </div>
    <div style="float: right;">
        <%
            timebox = new TimeBox();
            String minute;
            String month;
            String day;
            String PM = "PM";

            if(timebox.getMinute() < 10)
                minute = "0" + timebox.getMinute();
            else
                minute = "" + timebox.getMinute();

            if(timebox.getMonth() < 10)
                month = "0" + timebox.getMonth();
            else
                month = "" + timebox.getMonth();

            if(timebox.getDay() < 10)
                day = "0" + timebox.getDay();
            else
                day = "" + timebox.getDay();

            response.setIntHeader("Refresh", 5);
            out.println("<p align=\"center\">");
            out.println("<span class=\"time_span\">" + timebox.getHour() + ":" + minute + "</span></p><p align=\"center\">");
            out.println(month + "/" + day + "/" + timebox.getYear());
            out.println("</p>");
        %>
    </div>
</div>
<div class="pageCenter" id="table_div">

<%
    Taskmanager tm = new Taskmanager();
    out.println(HTMLBuilder.buildTaskTable(tm.getAssignees()));
%>

    <script>
        var date = new Date();
        var hour = date.getHours();
        var line = hour*2;
        var tbody = document.getElementById("scroll_body");
        var row = $('table').find('tr').eq(10);

        if(date.getMinutes() >= 30)
            line+= 1;


        tbody.scrollTop += 30;
        document.write(row);
    </script>

</div>

</body>
</html>
