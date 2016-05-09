<%@page import="java.io.File"%>
<%@page import="java.io.*"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

 <%!
	public String getFilePath(String... filePath) {
		String file = "";	
	
		for(String s : filePath) {
			File f = new File(s);
			
			if(f.exists()) {
				file = s;
				break;
			}
		}
		
		return file;
	}
%>	
<%
	String fileName = request.getParameter("file_name");
	
	ServletContext context = getServletContext();
	
	String realFolder = context.getRealPath("/upload/online/");
	String realFolder2 = context.getRealPath("/upload/online/att/");
	
	String filePath = realFolder + "/" + fileName;
	String filePath2 = realFolder2 + "/" + fileName;
	//System.out.println(filePath + " 파일을 다운로드");
	
	
	String s = getFilePath(filePath, filePath2);
	
	if(s==null || s.equals("") || s.equals("null")) {
		out.write(fileName + " 파일이 존재하지 않습니다");
		return;
	}

	try{
		File file = new File(s);
		
		byte b[] = new byte[4096];
		
		response.reset();
		response.setContentType("application/octet-stream");
		
		String Encoding = new String(fileName.getBytes("UTF-8"), "8859_1");
		response.setHeader("Content-Disposition", "attatchment; filename = " + Encoding);
		response.setHeader("Content-Length", String.valueOf((int)file.length()));
		
		FileInputStream is = new FileInputStream(filePath);
		ServletOutputStream sos = response.getOutputStream();
		
		int numRead;
		while((numRead = is.read(b,0,b.length)) != -1){
			sos.write(b,0,numRead);
		}
		
		sos.flush();
		sos.close();
		is.close();
	} catch(Exception e){
		e.printStackTrace();
	}
%>	
</body>
</html>
