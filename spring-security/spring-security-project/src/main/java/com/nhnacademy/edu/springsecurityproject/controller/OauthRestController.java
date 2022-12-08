package com.nhnacademy.edu.springsecurityproject.controller;


import com.nhnacademy.edu.springsecurityproject.domain.Post;
import com.nhnacademy.edu.springsecurityproject.domain.Token;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RequestMapping("/login/github")
@Controller
public class OauthRestController {

    private final RestTemplate restTemplate;

    public OauthRestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
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
    public String getTokenLogin(@RequestParam("code") String code){
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("github.com")
                .path("/login/oauth/access_token")
                .queryParam("client_id","4bb3ffd9680705f0487b")
                .queryParam("client_secret","6c26680510a16072449fe0ce04450d1d1f929935")
                .queryParam("code",code)
                .build();

        RestTemplate restTemplate = new RestTemplate();
        Token token = restTemplate.getForObject(uriComponents.toUri(), Token.class);

        getEmail(restTemplate, token);

        return "redirect:/";
    }


    public String getEmail(RestTemplate restTemplate, Token token) {
        UriComponents accessToken = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.github.com")
                .path("/user")
                .build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("token", token.getAccessToken());
        HttpEntity<Void> httpEntity = new HttpEntity(httpHeaders);


        ResponseEntity<Post> responseEntity =
                restTemplate.exchange(accessToken.toUri(), HttpMethod.GET, httpEntity, Post.class);

        return responseEntity.getBody().getEmail();
    }


}
