package com.paango.dao;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class CoursesDAO {
	String courseDescription;
	String courseName;
	String level;
	String prerequisites;
	String skillsAcquired;
	String whoShouldDoThisCourse;

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}

	public String getSkillsAcquired() {
		return skillsAcquired;
	}
	
	public void setSkillsAcquired(String skillsAcquired) {
		this.skillsAcquired = skillsAcquired;
	}

	public String getWhoShouldDoThisCourse() {
		return whoShouldDoThisCourse;
	}

	public void setWhoShouldDoThisCourse(String whoShouldDoThisCourse) {
		this.whoShouldDoThisCourse = whoShouldDoThisCourse;
	}

	private String packageAsJSON(String name, String value) {
		// Check if the value field has a double quote in it
		// Replace the double quotes with single quotes to avoid
		// Wrong formatting of the json string
		String value1 = value.replace("\"", "'");
		return "\"" + name + "\":\"" + value1 + "\"";
	}

	public void insert(String url) throws MalformedURLException, IOException, ProtocolException {
		//create JSON
		String json = "{" + packageAsJSON("courseName", courseName) + ", "
		+ packageAsJSON("courseDescription", courseDescription) + ", "
		+ packageAsJSON("level", level) + ", "
		+ packageAsJSON("prerequisites", prerequisites) + ", "
		+ packageAsJSON("skillsAcquired", skillsAcquired) + ", "
		+ packageAsJSON("whoShouldDoThisCourse", whoShouldDoThisCourse)
		+ "}" ;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		//add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(json);
		wr.flush();
		
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
			
		System.out.println("Post parameters : " + json);
		System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
		}
		
		in.close();
	}
	

}