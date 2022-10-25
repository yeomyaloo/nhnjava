package com.nhnacademy.servlet;

import com.nhnacademy.domain.Food;
import com.nhnacademy.repository.FoodRepository;
import com.nhnacademy.repository.FoodRepositoryImp;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="initServlet",urlPatterns = "/init")
public class InitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {


        ServletContext servletContext = getServletConfig().getServletContext();
        FoodRepository foodRepository = new FoodRepositoryImp();



        for (int i = 0; i < 2; i ++){
            foodRepository.add(new Food("양파", Integer.parseInt(servletContext.getInitParameter("onion"))));
        }
        for (int i = 0; i < 2; i ++){
            foodRepository.add(new Food("파", Integer.parseInt(servletContext.getInitParameter("greenOnion"))));
        }
        for (int i = 0; i < 2; i ++){
            foodRepository.add(new Food("계란", Integer.parseInt(servletContext.getInitParameter("egg"))));
        }
        for (int i = 0; i < 2; i ++){
            foodRepository.add(new Food("사과", Integer.parseInt(servletContext.getInitParameter("apple"))));
        }

        servletContext.setAttribute("foodRepository", foodRepository);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        try(PrintWriter out = resp.getWriter()){
            out.println("<html>");
            out.println("<head><title>Init</title></head><body>");
            out.println("<div>식품 매대가 준비되었습니다.");
            out.println("<a href=\"/foods\">Food list!</a>");
            out.println("</body></html>");
        }
    }
}
