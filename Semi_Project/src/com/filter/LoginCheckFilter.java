/*
 * package com.filter;
 * 
 * import java.io.IOException; import java.util.ArrayList; import
 * java.util.List;
 * 
 * import javax.servlet.Filter; import javax.servlet.FilterChain; import
 * javax.servlet.FilterConfig; import javax.servlet.ServletException; import
 * javax.servlet.ServletRequest; import javax.servlet.ServletResponse; import
 * javax.servlet.annotation.WebFilter; import
 * javax.servlet.http.HttpServletRequest;
 * 
 * import com.soda.member.model.vo.Member;
 * 
 * @WebFilter("/*") public class LoginCheckFilter implements Filter { private
 * List<String> permitList; private List<String> resourceList;
 * 
 *//**
	 * Default constructor.
	 */
/*
 * public LoginCheckFilter() { // TODO Auto-generated constructor stub }
 * 
 *//**
	 * @see Filter#destroy()
	 */
/*
 * public void destroy() { // TODO Auto-generated method stub }
 * 
 *//**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
/*
 * public void doFilter(ServletRequest request, ServletResponse response,
 * FilterChain chain) throws IOException, ServletException { HttpServletRequest
 * req = (HttpServletRequest)request; String uri = req.getRequestURI(); //
 * System.out.println(uri);
 * 
 * (로그인 없이) 요청이 허가 된 리스트에 현재 요청이 포함되지 않았을 때 if(!permitList.contains(uri)) {
 * boolean isResourceFile = false; 요청 안에 "/resources/" 라는 문자열을 포함하고 있는지 확인
 * for(String str : resourceList ) { if(uri.contains(str)) { isResourceFile =
 * true; break; } }
 * 
 * 허가 리스트에도 없는 요청이면서 리소스 파일도 아닌 경우 if(!isResourceFile) { 로그인 상태 확인 Member
 * loginUser = (Member)req.getSession().getAttribute("loginUser"); if(loginUser
 * == null) { req.setAttribute("message", "로그인을 다시 시도해주세요.");
 * req.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(
 * request, response); return; // doFilter 실행되지 않도록 리턴처리 } } }
 * 
 * chain.doFilter(request, response); }
 * 
 *//**
	 * @see Filter#init(FilterConfig)
	 *//*
		 * public void init(FilterConfig fConfig) throws ServletException { permitList =
		 * new ArrayList<String>(); permitList.add("/semi/index.jsp");
		 * permitList.add("/semi/"); permitList.add("/semi/login");
		 * permitList.add("/semi/mainpage"); permitList.add("/semi/memberjoin");
		 * permitList.add("/semi/idCheck"); permitList.add("/semi/email/find");
		 * permitList.add("/semi/email/login"); permitList.add("/semi/joincheck");
		 * permitList.add("/semi/kakao/login"); permitList.add("/semi/pwd/find");
		 * permitList.add("/semi/magazine/main");
		 * permitList.add("/semi/socialing/main"); permitList.add("/semi/lesson/main");
		 * 
		 * resourceList = new ArrayList<String>(); resourceList.add("/resources/");
		 * 
		 * }
		 * 
		 * }
		 * 
		 * 
		 */