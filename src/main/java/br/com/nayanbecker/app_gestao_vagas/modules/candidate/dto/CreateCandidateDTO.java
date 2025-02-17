package br.com.nayanbecker.app_gestao_vagas.modules.candidate.dto;

import lombok.Data;

@Data
public class CreateCandidateDTO {
    private String email;
    private String password;
    private String name;
    private String username;
    private String description;
}
