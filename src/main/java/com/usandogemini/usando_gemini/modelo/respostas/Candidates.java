package com.usandogemini.usando_gemini.modelo.respostas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Candidates {
    private Content content;
    private String finishReason;
    private Double avgLogprobs;
}
