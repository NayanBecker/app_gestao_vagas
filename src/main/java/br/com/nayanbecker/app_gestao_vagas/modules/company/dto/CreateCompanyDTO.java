package br.com.nayanbecker.app_gestao_vagas.modules.company.dto;

import lombok.Data;

@Data
public class CreateCompanyDTO {
    private String name;
    private String username;
    private String password;
    private String email;
    private String description;
    private String website;

}
