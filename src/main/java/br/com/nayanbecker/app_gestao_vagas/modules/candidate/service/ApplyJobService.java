package br.com.nayanbecker.app_gestao_vagas.modules.candidate.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApplyJobService {

    @Value("${host.api.gestao.vagas}")
    private String hostAPIGestaoVagas;
    
    public String execute(String token, UUID idJob){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<UUID> request = new HttpEntity<>(idJob, headers);

        var url = hostAPIGestaoVagas.concat("/candidate/job/apply");
        var result = restTemplate.postForObject(url, request, String.class);

        System.out.println(result);
        return result;
    }
}
