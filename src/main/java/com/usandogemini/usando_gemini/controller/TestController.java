package com.usandogemini.usando_gemini.controller;

import com.usandogemini.usando_gemini.modelo.requests.ModeloRequest;
import com.usandogemini.usando_gemini.modelo.respostas.ModeloResposta;
import com.usandogemini.usando_gemini.service.ApiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class TestController {

    @Autowired
    private final ApiService apiService;

    @PostMapping("/consume-external")
    public Mono<ResponseEntity<ModeloResposta>> consumeExternalApi(@RequestBody ModeloRequest request) {
        return apiService.fetchData(request)
                .map(response -> ResponseEntity.ok().body(response.getBody()))
                .onErrorResume( e ->
                        Mono.just(ResponseEntity.status(HttpStatus.BAD_GATEWAY).build())
                );
    }
}