package br.com.nayanbecker.app_gestao_vagas.modules.candidate.service;

import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.nayanbecker.app_gestao_vagas.modules.candidate.dto.JobDTO;

@Service
public class FindAllJobsService {

    public List<JobDTO> execute(String token, String filter) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(headers);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/candidate/job")
                .queryParam("filter", filter);

        ParameterizedTypeReference<List<JobDTO>> responseType = new ParameterizedTypeReference<List<JobDTO>>() {
        };

        try {
            var result = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, request, responseType);
            System.out.println(result);
            return result.getBody();
        } catch (HttpClientErrorException.Unauthorized e) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }
    }

}
