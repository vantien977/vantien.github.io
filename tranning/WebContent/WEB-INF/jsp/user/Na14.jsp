<%@page import="java.util.ArrayList"%>
<%@page import="bean.BenhNhan"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="WEB-INF/css/na14.css">
<style type="text/css">

.wrap {
  width: 800px;
}
.wrap table {
  table-layout: fixed;
  width: 100%;
}
.wrap table.head {
  width: calc(100% - 15px);
}
.wrap table.head tr td {
  background: #eee;
}

table tr  {
  border: 1px ;
  padding: 5px;
  word-wrap: break-word;
}
tr
{
width:100px;
}
th {
width:100px;
background-color:#8181F7;
color: white;
}
tr:nth-child(even){background-color: #f2f2f2;}
tr:nth-child(odd){background-color: #A9D0F5;}

.scroll-table {
  height: 300px;
  overflow-y: auto;
}

</style>
</head>
<body>
thong tin

<form name="myForm" action="Na14Servlet" onsubmit="return validateForm()" method="post" required>
<input type="submit" value="Submit">
   <input type="text" name="trang">
  
</form>
<script>
function validateForm() {
  var x = document.forms["myForm"]["trang"].value;
  var trang =document.getElementById("tongtrang").innerHTML.trim();
  if (x == "" || x == null) {
    alert("Không để dữ liệu trống!");
    return false;
  }
  
  if (parseInt((x*10)+(x-2)*10+1) >parseInt(trang))
	  
	  {
		    alert("lon!");
		    return false;
		  }
	  
}
</script>

<div class="wrap">
  <table class="head">
    <tbody>
      <tr>
      	<th></th>
        <th>Mã bệnh nhân</th>
        <th>Tên bệnh nhân</th>
        <th>Ngày khám đầu</th>
        <th>Ngày khám lại</th>
      </tr>
    </tbody>
  </table>
  <div class="scroll-table">
    <table>
      <tbody></tbody>
      <% 

ArrayList<BenhNhan> list = new ArrayList<BenhNhan>();
      
list = (ArrayList<BenhNhan>) request.getAttribute("benhnhan");
if(list.size()>0)
{
	for(int i=0;i<1;i++)
	{
	out.print("<tr>");

	out.print("<td>");
	out.print("<input type=");
	out.print("\"radio\" name=\"bn\"checked=\"checked\">");
	out.print("</td>");

	out.print("<td>");
	out.print(list.get(i).getPatid());
	out.print("</td>");
	out.print("<td>");
	out.print(list.get(i).getPatname());
	out.print("</td>");
	out.print("<td>");
	out.print(list.get(i).getPatintday());
	out.print("</td>");
	out.print("<td>");
	out.print(list.get(i).getPatupdday());
	out.print("</td>");

	out.print("</tr>");
	}
	for(int i=1;i<list.size();i++)
	{
		out.print("<tr>");
		   
	    out.print("<td>");
	    out.print("<input type=");
	    out.print("\"radio\" name=\"bn\">");
	    out.print("</td>");
	    
	    out.print("<td>");
	    out.print(list.get(i).getPatid());
	    out.print("</td>");
	    out.print("<td>");
	    out.print(list.get(i).getPatname());
	    out.print("</td>");
	    out.print("<td>");
	    out.print(list.get(i).getPatintday());
	    out.print("</td>");
	    out.print("<td>");
	    out.print(list.get(i).getPatupdday());
	    out.print("</td>");
	   
	    out.print("</tr>");
	    
	}
}



%>
      
      
    </table>
  </div>
</div>
<p>trang<% String trang=(String)request.getAttribute("sotrang"); 
out.print(trang);
%></p>
<% StringBuilder tongcot=(StringBuilder)request.getAttribute("tongtrang"); 
String tongcot1=tongcot.toString();
int tongcotcv=Integer.parseInt(tongcot1);



%>
<p id="tongtrang"> <% out.print(tongcotcv);%></p>

</body>
</html>