package br.com.alura.DaysOfCode.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("imdb")
public class ImdbController {

    @Value("${imdb.apiKey}")
    String apiKey;
    @GetMapping
    public void listar(){
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "https://imdb-api.com/en/API/Top250Movies/".concat(apiKey);
        ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
        System.out.println(response);
    }
}
