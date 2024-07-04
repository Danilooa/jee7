package br.com.danilooa.ocpjadee7.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(name = "responseWriter", urlPatterns = "/simple")
public class ServletResponse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String responseType = request.getParameter("responseType");
        if ("text".equals(responseType)) {
            //response.setContentType("");
            response.getWriter().println("text");
        }
        if ("png".equals(responseType)) {

            try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("img.png")) {
                
            } catch (IOException e) {

            }
        }

    }
}
