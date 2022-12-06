package com.nhnacademy.edu.jpa.controller;


import com.nhnacademy.edu.jpa.domain.paging.ResidentDTO;
import com.nhnacademy.edu.jpa.service.ResidentService;
import lombok.Getter;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/residents")
public class ResidentController {
    private final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    //redirect에서 주민불러오긔 ~
    @ModelAttribute("residents")
    public List<ResidentDTO> getResident(Pageable pageable){
        return residentService.getResidentWithPageable(pageable);
    }


    //주민 불러오기 ~(페이징 처리 ~ )
    @GetMapping
    public String residentListViewController(Pageable pageable, Model model){
        List<ResidentDTO> residents = residentService.getResidentWithPageable(pageable);
        model.addAttribute("residents", residents);
        return "residentList";
    }


    //가족관계증명서로 ~
    @GetMapping("{residentsId}/familyRelationshipReport")
    public String familyRelationshipReportViewController(){

        return "";
    }


}
