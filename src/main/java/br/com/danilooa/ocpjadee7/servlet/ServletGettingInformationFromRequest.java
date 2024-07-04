package br.com.danilooa.ocpjadee7.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

@WebServlet("/sub/pathInfo")
public class ServletGettingInformationFromRequest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getOutputStream().println("    request utl:" + req.getRequestURL());
        resp.getOutputStream().println("   context path:" + req.getContextPath());
        resp.getOutputStream().println("   servlet path:" + req.getServletPath());
        resp.getOutputStream().println("   query string:" + req.getQueryString());
        resp.getOutputStream().println("      path info:" + req.getPathInfo());
        resp.getOutputStream().println("path translated:" + req.getPathTranslated());
    }
}
