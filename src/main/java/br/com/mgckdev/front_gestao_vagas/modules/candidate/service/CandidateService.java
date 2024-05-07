package br.com.mgckdev.front_gestao_vagas.modules.candidate.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.mgckdev.front_gestao_vagas.modules.candidate.dto.Token;

@Service
public class CandidateService {

    public Token login(String username, String password) {
        RestTemplate rt = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> dataLogin = new HashMap<>();
        dataLogin.put("username", username);
        dataLogin.put("password", password);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(dataLogin, headers);

        var result = rt.postForObject("https://gestao-vagas-7nhz.onrender.com/candidate/auth", request, Token.class);

        return result;
    }
}
