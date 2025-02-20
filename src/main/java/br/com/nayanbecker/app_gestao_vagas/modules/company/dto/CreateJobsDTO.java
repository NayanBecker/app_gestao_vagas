package br.com.nayanbecker.app_gestao_vagas.modules.company.dto;

import lombok.Data;

@Data
public class CreateJobsDTO {

    private String title;
    private String description;
    private String level;
    private String benefits;
}
