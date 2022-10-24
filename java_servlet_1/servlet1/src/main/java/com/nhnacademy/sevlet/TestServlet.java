package com.nhnacademy.sevlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//서블릿 사용을 위해서 HttpServlet을 상속받아 사용
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String title = req.getParameter("title");
        String name = req.getParameter("name");

        resp.getWriter().println("hello servlet");

        resp.getWriter().println(title + name + "hello");

        /**
         * 동시성 이슈는 생길 수 있지만 Servlet context에서 get , set을 사용해서 공유 자원을 사용할 수 있게 한다 ~
         * Utillity로 만들어서 사용할 수 있게 해준다.
         * */
        Integer counter = Optional.ofNullable((Integer) getServletContext().getAttribute("counter")).orElse(0);

        PrintWriter printWriter = resp.getWriter();

        try {
            printWriter.println(counter);
        } catch (Exception e){

        }

        getServletContext().setAttribute("counter", ++counter);




    }



    @Override
    public void service(ServletRequest req, ServletResponse res)
        throws ServletException, IOException {
        super.service(req, res);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
