package com.nhnacademy.controller.post;

import com.nhnacademy.controller.Command;
import com.nhnacademy.domain.Post;
import com.nhnacademy.domain.PostImp;
import com.nhnacademy.domain.User;
import com.nhnacademy.domain.UserImp;
import com.nhnacademy.repository.PostRepository;
import com.nhnacademy.repository.UserRepository;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Objects;

public class PostCreatePostController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String title = req.getParameter("postTitle");
        String content = req.getParameter("postContent");
        String user = req.getParameter("postUserId");

        ServletContext servletContext = req.getSession().getServletContext();
        PostRepository postRepository = (PostRepository) servletContext.getAttribute("postRepository");


        int boradID = (int) servletContext.getAttribute("boardId");

        if (Objects.nonNull(postRepository)) {
            Post post = new PostImp(++boradID, title, content, user, LocalDateTime.now());
            servletContext.setAttribute("boardId", boradID);
            postRepository.register(post);

        }

        return "index_ok.jsp";
    }

}
