<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>file upload</title>
</head>
<body>
	<div class="container">
	
		<div id="main">
			<h1> 파일 업로드 </h1>
		</div>
		
		<div>
			<form method="post" action="upload" enctype="multipart/form-data">

				<label>파일 : </label> <input type="file" name="file">
				<br>
				<br> <input type="submit" value="upload">

			</form>
		</div>
		
	</div>
</body>
</html>