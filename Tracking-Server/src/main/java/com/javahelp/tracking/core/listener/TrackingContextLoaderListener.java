package com.javahelp.tracking.core.listener;

import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

import com.javahelp.tracking.core.ApplicationManager;

public class TrackingContextLoaderListener extends ContextLoaderListener{
	Logger logger = LoggerFactory.getLogger("c.j.t.c.l.TrackingContextLoaderListener");
	private LoggerContext lc ;
	
	public void contextInitialized ( ServletContextEvent sce ){
		lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		StatusPrinter.print(lc);
		if(logger.isDebugEnabled()){
			logger.debug("Initialing Tracking Application");
		}
		ApplicationManager.getInstance().initialize();
		super.contextInitialized(sce);
	}
	
	public void contextDestroyed ( ServletContextEvent sce ){
		ApplicationManager.getInstance().destroy();
		if(lc.isStarted()){
			lc.stop();
		}
		super.contextDestroyed(sce);
	}
}
