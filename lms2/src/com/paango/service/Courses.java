package com.paango.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.paango.dao.CoursesDAO;

/**
 * Servlet implementation class Courses
 */
@WebServlet("/Courses")
public class Courses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Courses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// get the values entered into local variables
		String course_name = request.getParameter("courseName");
		String course_description = request.getParameter("description");
		String course_students = request.getParameter("whoshould");
		String level = request.getParameter("levelCourse");
		String course_prerequisites = request.getParameter("prereq");
		String course_skills = request.getParameter("course_skills");
		
		// print the values to the console
		System.out.println(course_name);
		System.out.println(course_description);
		System.out.println(level);
		System.out.println(course_students);
		System.out.println(course_prerequisites);
		System.out.println(course_skills);
		
		// create a CoursesDAO object
		CoursesDAO cdao = new CoursesDAO();
		
		// set the member values of cdao object from the form data
		cdao.setCourseDescription(course_description);
		cdao.setCourseName(course_name);
		cdao.setLevel(level);
		cdao.setPrerequisites(course_prerequisites);
		cdao.setSkillsAcquired(course_skills);
		cdao.setWhoShouldDoThisCourse(course_students);
		
		// insert the values of the form data into CouchDB
		cdao.insert("http://localhost:5984/courses");

	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}