<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="upload" method="Post" enctype="multipart/form-data">
		<table>
			<tr>
				<td><input type="text" name="Name"></td>
			</tr>
			<tr>
				<td><input type="text" name="Gender"></td>
			</tr>
			<tr>
				<td><input type="file" name="Image"></td>
			</tr>
			<tr>
				<td><input type="submit" value="上传"></td>
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>
