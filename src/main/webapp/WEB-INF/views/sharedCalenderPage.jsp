<!DOCTYPE html>
<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"></c:set>

<html>
<head>
    <title></title>
    
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
 
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="resources/css/calendar.css">

</head>
<body style="background-color: #f8f8f8;">


<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Brand</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li ><a href="${contextPath}/userCalender">My Calendar</a></li>
        <li><a href="${contextPath}/shareYourCalender">Share Your Calendar</a></li>
        <li class="active"><a href="${contextPath}/sharedCalender/1 ">Shared Calendar <span class="sr-only">(current)</span></a></li>
        </ul>
        
      <ul class="nav navbar-nav navbar-right">
        <li><a href="${contextPath}/logout">Logout</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<br><br>
  <div class="container">
<h3 for="sel2">Shared Calendars List</h3>


      <select multiple class="form-control col col-lg-4" id="userSelect" name="sellist2" onchange="location = this.value;">
	<c:forEach  var="user"  items="${sharedUserList}">
        <option  value="${contextPath}/sharedCalender/${user.phoneNo}">  ${user.name}</option>        
      </c:forEach>
      </select></div>
  <br>
  <br>
  <br>
  <div class="container">
<table class="table table-bordered table-responsive grooveTable" id = userTable >
    <thead>
        <tr>
            <th>Days</th>
            <th>6-7</th>
            <th>7-8</th>
            <th>8-9</th>
            <th>9-10</th>
            <th>10-11</th>
            <th>11-12</th>
            <th>12-13</th>
            <th>13-14</th>
            <th>14-15</th>
            <th>15-16</th>
            <th>16-17</th>
            <th>17-18</th>
            <th>18-19</th>
            <th>19-20</th>
            <th>20-21</th>
        </tr>
    </thead>
   <tbody>
            <tr class='clickable-row' id="${weekDateList.get(0).date}">
            <td>${weekDateList.get(0).day} ${weekDateList.get(0).date}</td>
            <td id = "6-7"></td>
            <td id = "7-8"></td>
            <td id = "8-9"></td>
            <td id = "9-10"></td>
            <td id = "10-11"></td>
            <td id = "11-12"></td>
            <td id = "12-13"></td>
            <td id = "13-14"></td>
            <td id = "14-15"></td>
            <td id = "15-16"></td>
            <td id = "16-17"></td>
            <td id = "17-18"></td>
            <td id = "18-19"></td>
            <td id = "19-20"></td>
            <td id = "20-21"></td>
        </tr>
        <tr id="${weekDateList.get(1).date}">
            <td>${weekDateList.get(1).day} ${weekDateList.get(1).date}</td>
            <td id = "6-7"></td>
            <td id = "7-8"></td>
            <td id = "8-9"></td>
            <td id = "9-10"></td>
            <td id = "10-11"></td>
            <td id = "11-12"></td>
            <td id = "12-13"></td>
            <td id = "13-14"></td>
            <td id = "14-15"></td>
            <td id = "15-16"></td>
            <td id = "16-17"></td>
            <td id = "17-18"></td>
            <td id = "18-19"></td>
            <td id = "19-20"></td>
            <td id = "20-21"></td>
        </tr>
        <tr id="${weekDateList.get(2).date}">
            <td>${weekDateList.get(2).day} ${weekDateList.get(2).date}</td>
                  <td id = "6-7"></td>
            <td id = "7-8"></td>
            <td id = "8-9"></td>
            <td id = "9-10"></td>
            <td id = "10-11"></td>
            <td id = "11-12"></td>
            <td id = "12-13"></td>
            <td id = "13-14"></td>
            <td id = "14-15"></td>
            <td id = "15-16"></td>
            <td id = "16-17"></td>
            <td id = "17-18"></td>
            <td id = "18-19"></td>
            <td id = "19-20"></td>
            <td id = "20-21"></td></tr>
        <tr id="${weekDateList.get(3).date}">
            <td>${weekDateList.get(3).day} ${weekDateList.get(3).date}</td>
                <td id = "6-7"></td>
            <td id = "7-8"></td>
            <td id = "8-9"></td>
            <td id = "9-10"></td>
            <td id = "10-11"></td>
            <td id = "11-12"></td>
            <td id = "12-13"></td>
            <td id = "13-14"></td>
            <td id = "14-15"></td>
            <td id = "15-16"></td>
            <td id = "16-17"></td>
            <td id = "17-18"></td>
            <td id = "18-19"></td>
            <td id = "19-20"></td>
            <td id = "20-21"></td></tr>
        <tr id="${weekDateList.get(4).date}">
            <td>${weekDateList.get(4).day} ${weekDateList.get(4).date}</td>
                 <td id = "6-7"></td>
            <td id = "7-8"></td>
            <td id = "8-9"></td>
            <td id = "9-10"></td>
            <td id = "10-11"></td>
            <td id = "11-12"></td>
            <td id = "12-13"></td>
            <td id = "13-14"></td>
            <td id = "14-15"></td>
            <td id = "15-16"></td>
            <td id = "16-17"></td>
            <td id = "17-18"></td>
            <td id = "18-19"></td>
            <td id = "19-20"></td>
            <td id = "20-21"></td></tr>
        <tr id="${weekDateList.get(5).date}">
            <td>${weekDateList.get(5).day} ${weekDateList.get(5).date}</td>
                <td id = "6-7"></td>
            <td id = "7-8"></td>
            <td id = "8-9"></td>
            <td id = "9-10"></td>
            <td id = "10-11"></td>
            <td id = "11-12"></td>
            <td id = "12-13"></td>
            <td id = "13-14"></td>
            <td id = "14-15"></td>
            <td id = "15-16"></td>
            <td id = "16-17"></td>
            <td id = "17-18"></td>
            <td id = "18-19"></td>
            <td id = "19-20"></td>
            <td id = "20-21"></td> </tr>
        <tr id="${weekDateList.get(6).date}">
            <td>${weekDateList.get(6).day} ${weekDateList.get(6).date}</td>
                 <td id = "6-7"></td>
            <td id = "7-8"></td>
            <td id = "8-9"></td>
            <td id = "9-10"></td>
            <td id = "10-11"></td>
            <td id = "11-12"></td>
            <td id = "12-13"></td>
            <td id = "13-14"></td>
            <td id = "14-15"></td>
            <td id = "15-16"></td>
            <td id = "16-17"></td>
            <td id = "17-18"></td>
            <td id = "18-19"></td>
            <td id = "19-20"></td>
            <td id = "20-21"></td></tr>
    </tbody>
</table>

</div>
	<br>
	<br>
	<br>

</body>
<script type="text/javascript">

$('td').click(function(){
	   var day = $(this).closest('tr').attr('id'); // table row ID 
	   var time = $(this).closest('td').attr('id'); // table col ID 
	   
	  console.log( "color console ");
	  if(this.style.backgroundColor == "lightblue"){
		  $(this).css('background-color',"red").html("Booked");
			 
		  $.get("${contextPath}/send",
				    {
				      user_id: "${user_id}",
				      sh_user_id: "${sh_user_id}",
				      day: day,
				      time: time,
				      status: "free"
				    },
				    function(data,status){
				    //  alert("Data: " + data + "\nStatus: " + status);
				    });
		 
		 
		     
	  }else if (this.style.backgroundColor == "red"){
		     $(this).css('background-color',"lightblue").html("Free");
		     $.get("${contextPath}/send",
					    {
					      user_id: "${user_id}",
					      sh_user_id: "${sh_user_id}",
					      day: day,
					      time: time,
					      status: "busy"
					    },
					    function(data,status){
					    //  alert("Data: " + data + "\nStatus: " + status);
					    });
			 
		     
	  }else{
	    //  $(this).css('background-color',"lightblue").html("Free");
	  }
     
	});


$(document).ready(function(){
	console.log("ready function");
	
   // console.log($('#userTable').find('tr#Monday').find('td#9-10').css('background-color',"green"));
	<c:forEach items="${calenderData}" var="cal">
	
	   $('#userTable').find('tr#${cal.date}').find('td#${cal.time}').css('background-color',"lightblue").html("Free");
		
	</c:forEach>

	<c:forEach items="${ackList}" var="ack">
    
    $('#userTable').find('tr#${ack.date}').find('td#${ack.time}').css('background-color',"red").html("${ack.username}");
		
		</c:forEach>
		
});

	
</script>

</html>