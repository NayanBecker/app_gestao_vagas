package br.com.nayanbecker.app_gestao_vagas.modules.candidate.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.nayanbecker.app_gestao_vagas.modules.candidate.dto.Token;

@Service
public class CandidateService {

    public Token login(String email, String password) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> data = new HashMap<>();
        data.put("email", email);
        data.put("password", password);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(data, headers);

        var result = restTemplate.postForObject("http://localhost:8080/candidate/auth", request, Token.class);
        
        System.out.println("retorno: " + result);
        return result;
    }
}
