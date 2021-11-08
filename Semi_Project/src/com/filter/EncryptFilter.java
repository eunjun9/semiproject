package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.wrapper.EncryptWrapper;

/**
 * Servlet Filter implementation class EncryptFilter
 */

// 암호화가 필요한 서블릿 적용 (생성하는 서블릿에 따라 서블릿네임 변경하기!)
@WebFilter(filterName="encrypt", servletNames= {"LoginServlet"
											  , "memberjoinServlet"
											  , "KakaoLoginServlet"
											  , "PwdFindServlet"
											  , "EmailLoginServlet"
											  , "PwdModifyServlet"})
public class EncryptFilter implements Filter {

    /**
     * Default constructor. 
     */ 
    public EncryptFilter() {
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
		EncryptWrapper encWrapper = new EncryptWrapper((HttpServletRequest)request);
		
		chain.doFilter(encWrapper, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
