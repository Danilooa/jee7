package br.com.danilooa.ocpjadee7.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//User value when there is only one url patterns, otherwise use urlPatterns
//@WebServlet(value = "/createAndInit")
//or
@WebServlet(
        name = "CreatingAndInitializingServlet",
        urlPatterns = {
                "createAndInit1",
                "createAndInit2"
        },
        initParams = {
                @WebInitParam(name = "parameterOne", value = "1"),
                @WebInitParam(name = "parameterTwo", value = "2"),
        }
)
public class CreatingAndInitializingServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Initializing the servlet: 'CreatingAndInitializingServlet'");
        config.getInitParameterNames()
                .asIterator()
                .forEachRemaining(
                        (a) -> System.out.println(a + "=" + config.getInitParameter(a))
                );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getOutputStream().println("Servlet created and initialized.");
    }
}
