// This is a Java Servlet that handles HTTP requests in a Java web application.

/*
 *  What is a Servlet?
	A Servlet is a Java program that runs on a web server. 
	It processes HTTP requests from the browser and sends back a response.
 *  Example Flow-
	1) User opens http://localhost:8080/login.do in a browser.
	2) The browser sends an HTTP request to the server.
	3) The server runs LoginServlet.java and creates an HTTP response.
	4) The browser displays the response (HTML page).
 */


// Package Declaration
package com.amisha;			// Groups related Java files together in a package called webapp


// Import Statements
import java.io.IOException;		// Handles input/output errors (e.g., issues writing a response).	
import java.io.PrintWriter;		// Used to send text (HTML) back to the browser.
import javax.servlet.annotation.WebServlet;		// Allows us to define a Servlet using annotations.
import javax.servlet.http.HttpServlet;			// The base class for all Servlets.
import javax.servlet.http.HttpServletRequest;	// Represents the HTTP request from the browser.
import javax.servlet.http.HttpServletResponse;	// Represents the HTTP response sent back.

/*
 * Browser sends Http Request to Web Server
 * 
 * Code in Web Server => Input:HttpRequest, Output: HttpResponse
 * JEE with Servlets
 * 
 * Web Server responds with Http Response
 */

//Java Platform, Enterprise Edition (Java EE) JEE6

//Servlet is a Java programming language class 
//used to extend the capabilities of servers 
//that host applications accessed by means of 
//a request-response programming model.

//1. extends javax.servlet.http.HttpServlet
//2. @WebServlet(urlPatterns = "/login.do")
//3. doGet(HttpServletRequest request, HttpServletResponse response)
//4. How is the response created?


// Defining the Servlet
@WebServlet(urlPatterns = "/login.do")			// Maps this "LoginServlet" servlet to login.do URL.
// If a user opens http://localhost:8080/login.do, this Servlet (LoginServlet) will handle it.
public class LoginServlet extends HttpServlet {	// extends HttpServlet → This makes LoginServlet a Servlet.

	// Handling GET Requests
	@Override			// Tells Java we are modifying the doGet() method from HttpServlet.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/*
		 * doGet(HttpServletRequest request, HttpServletResponse response):
			# Runs when a user visits login.do using a browser.
			# request → Holds user request data.
			# response → Used to send a response (HTML page) back to the browser.
		 */
		
		// Sending an HTML Response
		/*
		 * response.getWriter() → Creates a PrintWriter object to send text (HTML) to the browser.
		 * out.println(...) → Writes HTML code into the response.
		 */
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Yahoo!!!!!!!!</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("My First Servlet..");
		out.println("</body>");
		out.println("</html>");

	}
}


/*
 * What Happens When You Visit /login.do?
	1) You open http://localhost:8080/login.do in a browser.
	2) The server runs doGet() inside LoginServlet.
	3) doGet() writes HTML code.
	4) The browser receives the HTML and displays it.
	
 * Final Output in Browser-
	When you visit /login.do, you will see:
	🔹 Page Title (shown in browser tab):
	 	Yahoo!!!!!!!!
	🔹 Page Content (shown on the page):
	 	My First Servlet
 */
