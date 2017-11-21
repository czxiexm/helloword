package com.listener;

import java.util.GregorianCalendar;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.qyh.Tast_ts;

/**
 * Application Lifecycle Listener implementation class Time_listener
 *
 */
@WebListener
public class Time_listener implements ServletContextListener {
	
	private Timer timer = null; 

    /**
     * Default constructor. 
     */
    public Time_listener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    	GregorianCalendar c1 = new GregorianCalendar();
	    c1.set(GregorianCalendar.HOUR_OF_DAY, 9);
	    c1.set(GregorianCalendar.MINUTE,30);
	    c1.set(GregorianCalendar.SECOND, 0);
	    System.out.println("任务开始执行："+c1.getTime());	
	    
    	timer = new Timer(true);   
        timer.scheduleAtFixedRate(new Tast_ts(),c1.getTime(), 24*60*60*1000);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    	if (timer != null) {  
            timer.cancel();  
           
        }  
    }
	
}
