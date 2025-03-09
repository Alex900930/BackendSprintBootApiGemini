package com.usandogemini.usando_gemini.modelo.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.usandogemini.usando_gemini.modelo.respostas.Content;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModeloRequest {
    private List<Content> contents;
}
