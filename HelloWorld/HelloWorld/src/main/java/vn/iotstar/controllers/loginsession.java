package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class loginsession
 */
@WebServlet({"/well-come"})
public class loginsession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public loginsession() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Sửa resp thành response
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if ("vinh".equals(username) && "123".equals(password)) {
			out.print("Chào mừng bạn đã tới trang web, " + username);
			HttpSession session = request.getSession();
			session.setAttribute("name", username);
		} else {
			out.print("Tài khoản hoặc mật khẩu không chính xác");
			// forward về trang login.html
			request.getRequestDispatcher("login.html").include(request, response);
		}
	}
}
