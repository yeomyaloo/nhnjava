package com.nhnacademy.edu.springsecurityproject.controller;


import com.nhnacademy.edu.springsecurityproject.domain.Post;
import com.nhnacademy.edu.springsecurityproject.domain.Token;
import com.nhnacademy.edu.springsecurityproject.entity.Resident;
import com.nhnacademy.edu.springsecurityproject.repositoty.ResidentRepository;
import com.nhnacademy.edu.springsecurityproject.service.CustomUserDetailsService;
import com.nhnacademy.edu.springsecurityproject.service.ResidentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.security.authentication.*;

import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Slf4j
@RequestMapping("/login/github")
@Controller
public class OauthRestController {

    private final RestTemplate restTemplate;
    private final ResidentServiceImpl residentService;
    private final CustomUserDetailsService customUserDetailsService;

;
    public OauthRestController(RestTemplate restTemplate, ResidentServiceImpl residentService, CustomUserDetailsService customUserDetailsService) {
        this.restTemplate = restTemplate;
        this.residentService = residentService;
        this.customUserDetailsService = customUserDetailsService;


    }


    @GetMapping
    public String gitLogin(){
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("github.com")
                .path("/login/oauth/authorize")
                .queryParam("client_id","4bb3ffd9680705f0487b")
                .queryParam("scope","user:email")
                .build();

        return "redirect:" + uriComponents.toString();

    }

    @GetMapping("/oauth/token")
    public String getTokenLogin(@RequestParam("code") String code, Model model){
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("github.com")
                .path("/login/oauth/access_token")
                .queryParam("client_id","4bb3ffd9680705f0487b")
                .queryParam("client_secret","577ce9df4f5dfeea70bfab1b6eb829f7ae2f356e")
                .queryParam("code",code)
                .build();

        RestTemplate restTemplate = new RestTemplate();
        Token token = restTemplate.getForObject(uriComponents.toUri(), Token.class);

        String email = getEmail(restTemplate, token);

            Optional<Resident> optionalResident = residentService.getResidentByEmail(email);

            if(optionalResident.isPresent()) {
                Resident resident = optionalResident.get();


                UserDetails userDetails = customUserDetailsService.loadUserByUsername(resident.getUsername());
                Authentication authentication =  new UsernamePasswordAuthenticationToken(userDetails,null,resident.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);


                model.addAttribute("resident", optionalResident.get());

                return "redirect:/";
            }
        return "redirect:/redirect-login";
    }

    public String getEmail(RestTemplate restTemplate, Token token) {
        UriComponents accessToken = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.github.com")
                .path("/user")
                .build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " +  token.getAccessToken());
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<Post> responseEntity =
                restTemplate.exchange(accessToken.toUri(), HttpMethod.GET, httpEntity, Post.class);

        return responseEntity.getBody().getEmail();
    }


}
