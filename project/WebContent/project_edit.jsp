<%@ page language="java" contentType="text/html; charset=utf-8"  import="net.hnjdzy.entity.*"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<LINK href="css/content.css" type=text/css rel=stylesheet>
</head>
<body>
<table width="834" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30" background="images/title01.jpg" class="title">&gt;&gt;项目信息录入</td>
    <td width="27" height="30"><img src="images/title02.jpg" width="27" height="30" /></td>
    <td height="30" bgcolor="#029AC5" class="txt">您的位置：招投标流程 &gt; 建设工程报建 &gt; 项目信息录入</td>
  </tr>
</table>
<br />
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="100%" height="30" bgcolor="#80C6FF" class="titletxt">&#8226;建设工程报建—项目信息录入（以下带<span class="txtred">*</span>为必填项）</td>
  </tr>
  <tr>
    <td height="30" align="center">
    <%
        Project p = (Project)request.getAttribute("project");    
    %>
    
    <form id="form1" name="form1" method="post" action="ProjectServlet?opr=update">
      <table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bgcolor="#E7E7E7">
        <tr>
          <td width="24%" height="30" align="right" class="txt"><span class="txt">工程编号：</span></td>
          <td height="30" align="left"><label for="textfield"></label>
            <input  height="20" width="400" type="text" name="textfield" id="textfield" value="<%=p.getProjectId() %>"   hidden="hidden"/>
            <input  height="20" width="400" type="text" name="textfield10" id="textfield10" value="<%=p.getProjectId() %>"   disabled="disabled"/>
            <span class="txtred">*</span></td>
        </tr>
        <tr>
          <td width="24%" height="30" align="right" class="txt"><span class="txt">工程名称：</span></td>
          <td height="30" align="left"><input  height="20" width="400" type="text" name="textfield2" id="textfield2" value="<%=p.getProjectName() %>"/>
            <span class="txtred">*</span></td>
        </tr>
        
        <tr>
          <td height="30" align="right" class="txt">法人代表：</td>
          <td height="30" align="left"><input  height="20" width="150" type="text" name="textfield9" id="textfield9" value="<%=p.getDeputyName() %>"/></td>
        </tr>
        <tr>
          <td height="30" align="right" class="txt">建设单位电话：</td>
          <td height="30" align="left"><input  height="20" width="200" type="text" name="textfield6" id="textfield6" value="<%=p.getTelephone() %>"/></td>
          </tr>
        <tr>
          <td height="30" align="right" class="txt">建设单位地址：</td>
          <td height="30" align="left"><span class="txtred">
            <input  height="20" width="400" type="text" name="textfield7" id="textfield7" value="<%=p.getAddr() %>" />
          </span></td>
        </tr>
       
      </table>
        <p><input type="submit" name="button" id="button" value="  确  定  " /></p>
      </form>
    <p>&nbsp;</p></td>
  </tr>
</table>
<p>&nbsp;</p>
</body>
</html>