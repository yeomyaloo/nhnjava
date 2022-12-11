package com.nhnacademy.edu.springsecurityproject.controller;


import com.nhnacademy.edu.springsecurityproject.domain.FamilyRelationshipReportInterface;
import com.nhnacademy.edu.springsecurityproject.service.FamilyRelationshipService;
import com.nhnacademy.edu.springsecurityproject.service.ResidentService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FamilyRelationshipController {
    private final RedisTemplate redisTemplate;
    private final FamilyRelationshipService familyRelationshipService;
    private final ResidentService residentService;

    public FamilyRelationshipController(RedisTemplate redisTemplate, FamilyRelationshipService familyRelationshipService, ResidentService residentService) {
        this.redisTemplate = redisTemplate;
        this.familyRelationshipService = familyRelationshipService;
        this.residentService = residentService;
    }

    @GetMapping("/list")
    public String getResidentListPage(Model model) {

        List<FamilyRelationshipReportInterface> familyList = familyRelationshipService.getAllFamilyList();
        model.addAttribute("familyList", familyList);
        return "list";
    }
}
