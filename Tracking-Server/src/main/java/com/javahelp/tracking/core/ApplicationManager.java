package com.javahelp.tracking.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationManager {
	private Logger logger = LoggerFactory.getLogger("c.j.t.c.ApplicationManager");

	private static volatile ApplicationManager applicationManager;
	
	private ApplicationManager(){}
	
	public static ApplicationManager getInstance() {
		if(applicationManager == null){
			synchronized (ApplicationManager.class) {
				if(applicationManager == null){
					applicationManager = new ApplicationManager();
				}
			}
		}
		return applicationManager;
	}
	
	public void initialize(){
		logger.info("Application successfully up");		
	}
	
	public void destroy(){
		logger.info("Destroying the application");
	}
	
}
