<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Second java app</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<form name="RegisterForm" method="post" action="Courses">
		<label>Course Name<span>*</span>:</label> <input type="text" name="courseName" ><br/>
		<label>Course Description<span>*</span>:</label><textarea name="description" ></textarea>
		<br/>
		<label>level</label>
			<select name="levelCourse">
				<option>beginner</option>
				<option>intermediate</option>
				<option>advanced</option>
			</select><br/>
		<label>Who should do this course?</label><input type="text" name="whoshould"><br/>
		<label>what are the pre-requisites?</label><input type="text" name="prereq"><br/>
		<label>Skills acquired</label><input type="text" name="course_skills"><br/>
		<input type="submit" value="submit">
	</form>
</body>
</html>