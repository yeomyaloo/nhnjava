package com.nhnacademy.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class NowController {


    //view 이름으로 던지는 이때는 모델을 바로 던져주는
    @GetMapping("/now")
    public String now(Model model) {
        model.addAttribute("now", LocalDateTime.now());
        return "now";
    }


    // POJO를 더한 방식으로 모델을 넘겨주는 방식
    @GetMapping("/now2")
    public String now2(Model model) {
        Current current =new Current(LocalDateTime.now());
        model.addAttribute("current", current.getLocalDateTime());
        return "now2";
    }


    //최근 트랜드 modelAndView를 사용해서 해당 객체를 넘겨주는 방식..
    @GetMapping("/now3")
    public ModelAndView now3() {
        ModelAndView modelAndView = new ModelAndView("now2");
        Current current =new Current(LocalDateTime.now());
        modelAndView.addObject("current", current.getLocalDateTime());
        return modelAndView;
    }

    class Current {
        private LocalDateTime localDateTime;

        public Current(LocalDateTime localDateTime) {
            this.localDateTime = localDateTime;
        }

        public LocalDateTime getLocalDateTime() {
            return localDateTime;
        }
    }
}
