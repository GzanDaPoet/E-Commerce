package ptithcm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ptithcm.constant.SystemConstant;
import ptithcm.model.user.User;
import ptithcm.util.SessionUtil;

public class AuthorizationFilter implements Filter {

	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String url = request.getRequestURI();
		if (url.startsWith("/e-commerce")) {
			User model = (User) SessionUtil.getInstance().getValue(request, "USER_MODEL");
			System.out.print("in auth" + model.getUsername());
			if (model != null) {
				if (model.getUser_permission().getValue().equals(SystemConstant.ADMIN)
						|| model.getUser_permission().getValue().equals(SystemConstant.SUPER_ADMIN)) {
					filterChain.doFilter(servletRequest, servletResponse);
				} else if (model.getUser_permission().getValue().equals(SystemConstant.USER)) {
					response.sendRedirect(request.getContextPath() + "admin/login.htm");
				}
			} else {
				response.sendRedirect(request.getContextPath() + "admin/login.htm");
			}
		} else {
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}
}
