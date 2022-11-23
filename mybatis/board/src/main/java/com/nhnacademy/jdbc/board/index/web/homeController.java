package com.nhnacademy.jdbc.board.index.web;

import com.nhnacademy.jdbc.board.board.domain.Board;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

public class homeController {




    @GetMapping("/home")
    public String homeViewController(){
        return "home";
    }
}
