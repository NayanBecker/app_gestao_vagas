package br.com.nayanbecker.app_gestao_vagas.modules.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.nayanbecker.app_gestao_vagas.modules.candidate.dto.JobDTO;

@Service
public class ListAllJobsCompanyService {
    @Value("${host.api.gestao.vagas}")
    private String hostAPIGestaoVagas;
    public List<JobDTO> execute(String token){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        var httpEntity = new HttpEntity<>(headers);

        ParameterizedTypeReference<List<JobDTO>> responseType = new ParameterizedTypeReference<List<JobDTO>>() {
        };

        var url = hostAPIGestaoVagas.concat("/company/jobs/");

        var result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, responseType);

        return result.getBody();
    }
}
