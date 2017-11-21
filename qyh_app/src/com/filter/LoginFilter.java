package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
//@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
	
	String passUrl = "";
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
	
		HttpServletRequest httpRequest=(HttpServletRequest)request;
        HttpServletResponse httpResponse=(HttpServletResponse)response;
        HttpSession session=httpRequest.getSession();
 
		
      
        //单独放性某文件的配套语句 
        String[] strArray = passUrl.split(";");
        for (String str : strArray) {
            if (str.equals(""))
                continue;
            if (httpRequest.getRequestURL().indexOf(str) >= 0) {
                chain.doFilter(request, response);
                return;
            }
        }
        
        
        
        if(session.getAttribute("name")!=null){
            chain.doFilter(request, response);
        }
        else{
            httpResponse.sendRedirect(httpRequest.getContextPath()+"/blank.jsp");
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		 passUrl = fConfig.getInitParameter("passUrl");
	}

}
