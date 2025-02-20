package br.com.nayanbecker.app_gestao_vagas.modules.company.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.nayanbecker.app_gestao_vagas.modules.company.dto.CreateCompanyDTO;

@Service
public class CreateCompanyService {

    @Value("${host.api.gestao.vagas}")
    private String hostAPIGestaoVagas;

    public String execute(CreateCompanyDTO createCompanyDTO) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CreateCompanyDTO> request = new HttpEntity<>(createCompanyDTO, headers);

        var url = hostAPIGestaoVagas.concat("/company/");
        var result = restTemplate.postForObject(url, request, String.class);
        System.out.println(result);
        return result;
    }
}
