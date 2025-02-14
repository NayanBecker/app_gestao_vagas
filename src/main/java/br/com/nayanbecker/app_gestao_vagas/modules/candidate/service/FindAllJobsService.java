package br.com.nayanbecker.app_gestao_vagas.modules.candidate.service;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class FindAllJobsService {

    public String execute(String token, String filter) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(headers);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/candidate/job")
                .queryParam("filter", filter);

        try {
            var result = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, request, String.class);
            System.out.println(result);
            return result.getBody();
        } catch (Exception e) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }
    }

}
