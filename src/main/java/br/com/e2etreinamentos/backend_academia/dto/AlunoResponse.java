package br.com.e2etreinamentos.backend_academia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlunoResponse {

    private Long id;

    private String nome;

    private String email;

    private Integer idade;

    private String whatsapp;
}