package com.usandogemini.usando_gemini.service;

import com.usandogemini.usando_gemini.modelo.requests.ModeloRequest;
import com.usandogemini.usando_gemini.modelo.respostas.ModeloResposta;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ApiService {

    @Autowired
    private final WebClient webClient;

    public Mono<ResponseEntity<ModeloResposta>> fetchData(ModeloRequest request) {
        return webClient.post()
                .bodyValue(request)
                .retrieve()
                .onStatus(HttpStatusCode::isError, response ->
                        response.bodyToMono(String.class)
                                .flatMap(error -> Mono.error(new Throwable("Error en API Externa: " + error))))
                .toEntity(ModeloResposta.class);
    }
}
