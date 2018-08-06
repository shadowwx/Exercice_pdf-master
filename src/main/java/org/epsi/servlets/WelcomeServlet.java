package org.epsi.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.apache.logging.log4j.*;

@SuppressWarnings("serial")
public class WelcomeServlet extends HttpServlet{

	//private static Logger logger = LogManager.getLogger(WelcomeServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//logger.info("Welcome");
		try
		{
			resp.getOutputStream().write("Hello World !".getBytes());
		}
		catch(Exception e)
		{
			resp.sendError(500);
		}
	}
}
