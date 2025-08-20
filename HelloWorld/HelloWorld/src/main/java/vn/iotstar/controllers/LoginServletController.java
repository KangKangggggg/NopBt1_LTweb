package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.getWriter().append("Fail");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("vinh".equals(username) && "123".equals(password)) {
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(30); 
            cookie.setPath("/");
            resp.addCookie(cookie);
            resp.sendRedirect("/HelloWorld/hello");
        } else {
            resp.sendRedirect("/HelloWorld/login");
        }
    }
}