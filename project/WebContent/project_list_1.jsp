<%@ page language="java" contentType="text/html; charset=utf-8"  import= "java.util.*,net.hnjdzy.entity.*"
    pageEncoding="utf-8"%>
<%@  taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<LINK href="css/content.css" type=text/css rel=stylesheet>
<title>Insert title here</title>
<script type="text/javascript">

   function mysq(id){	  
	   if(confirm("是否真的删除？")){
		   location.href = "ProjectServlet?opr=del&id="+id;		
		}else{
			alert("失败");
		}
   }
   
   function mychange(){				
		var mysel = document.getElementById("myselect");
		var index = mysel.selectedIndex;
		var v = mysel.options[index].value;
		location.href = "ProjectServlet?opr=sel&value="+v;
	}
   
   function myclick(){
	   var myinput = document.getElementById("myinput");
	   var id = myinput.value;
	   location.href = "ProjectServlet?opr=query&value="+id;
   }

</script>
</head>
<body>
    <!-- aaa -->
    <%-- bbb --%>
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
    <td width="33%" height="37">
    <select onchange="mychange()" id="myselect">
            <option value="1">--请选择--</option>
			<option value="2003-01">2003-01</option>
			<option value="2003-02">2003-02</option>
		</select> 
    
    &nbsp;</td>
    <td width="34%" height="37">
        <input type="text" id="myinput" placeholder="请输入工程编号"><input type="button" value="查询" onclick="myclick()" >
    &nbsp;</td>
    <td width="33%" height="37" align="right" valign="top"><a href="project_add.html" target="_self"><img src="images/addpro.jpg" border="0" /></a>&nbsp;</td>
  </tr>
  <tr>
    <td height="30" colspan="3" bgcolor="#029AC5" class="titletxt">&#8226;项目信息</td>
  </tr>
  <tr>
    <td height="30" colspan="3"><table width="100%" border="1" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="33%" height="30" align="center" bgcolor="#80C6FF"><span class="txt"><span class="titletxt">工程编号</span></span></td>
        <td width="34%" height="30" align="center" bgcolor="#80C6FF" class="titletxt">工程名称</td>
        <td width="33%" height="30" align="center" bgcolor="#80C6FF" class="titletxt">相关操作</td>
      </tr>    
      
      <c:forEach items="${list }" var="project" >
       <tr>
         <td width="33%" height="30" align="center" bgcolor="#FFF5D7"><span class="txt">${project.projectId }</span></td>
        <td width="34%" height="30" align="center" bgcolor="#FFF5D7"><span class="txt">${project.projectName }</span></td>
        <td width="33%" height="30" align="center" bgcolor="#FFF5D7"><span class="txt"><a href="ProjectServlet?opr=edit&id=${project.projectId }">【修改】</a><a href="javascript:mysq('${project.projectId }')">【删除】</a></span></td>
      </tr>     
      
      </c:forEach>
    
    </table></td>
  </tr>
</table>
<p>&nbsp;</p>
</body>
</html>