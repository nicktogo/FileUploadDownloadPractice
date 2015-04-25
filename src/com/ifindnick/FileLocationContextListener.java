package com.ifindnick;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class FileLocationContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		// TODO Auto-generated method stub
		String rootPath = System.getProperty("catalina.home");
		ServletContext ctx = servletContextEvent.getServletContext();
		String relativePath = ctx.getInitParameter("tempfile.dir");
		File file = new File(rootPath + File.separator +  relativePath);
		
		if(!file.exists())
			file.mkdir();
		System.out.println("File Directory created to be used for storing files");
		
		ctx.setAttribute("FILES_DIR_FILE", file);
		ctx.setAttribute("FILE_DIR", rootPath + File.separator +  relativePath);
		
	}

}
