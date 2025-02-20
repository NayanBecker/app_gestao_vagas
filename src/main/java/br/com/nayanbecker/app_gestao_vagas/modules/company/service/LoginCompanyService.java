package br.com.nayanbecker.app_gestao_vagas.modules.company.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.nayanbecker.app_gestao_vagas.modules.candidate.dto.Token;

@Service
public class LoginCompanyService {

    @Value("${host.api.gestao.vagas}")
    private String hostAPIGestaoVagas;

    public Token login(String email, String password) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> data = new HashMap<>();
        data.put("email", email);
        data.put("password", password);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(data, headers);

        var url = hostAPIGestaoVagas.concat("/company/auth");

        var result = restTemplate.postForObject(url, request, Token.class);

        System.out.println("retorno: " + result);
        return result;
    }

}
