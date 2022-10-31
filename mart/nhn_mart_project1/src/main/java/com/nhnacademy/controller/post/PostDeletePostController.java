package com.nhnacademy.controller.post;

import com.nhnacademy.controller.Command;
import com.nhnacademy.repository.PostRepository;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class PostDeletePostController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {


        ServletContext servletContext = req.getSession().getServletContext();
        PostRepository postRepository = (PostRepository) servletContext.getAttribute("postRepository");

        long delete_id_param = (long) servletContext.getAttribute("delete_id_param");

        if(Objects.nonNull(postRepository)){
            postRepository.remove(delete_id_param);
            return "index.jsp";
        }


        return "postDelete.jsp";
    }
}
