package br.com.nayanbecker.app_gestao_vagas.modules.candidate.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.nayanbecker.app_gestao_vagas.modules.candidate.dto.ProfileUserDto;

@Service
public class ProfileCandidateService {

    @Value("${host.api.gestao.vagas}")
    private String hostAPIGestaoVagas;

    public ProfileUserDto execute(String token) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(headers);

        try {
            var url = hostAPIGestaoVagas.concat("/candidate/");
            var result = restTemplate.exchange(url, HttpMethod.GET, request, ProfileUserDto.class);
            System.out.println(result);
            return result.getBody();
        } catch (Exception e) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);       
        }
    }
}
