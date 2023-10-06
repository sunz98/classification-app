package seocho_ai.classificationapp.service.AI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import seocho_ai.classificationapp.domain.survey.Survey;
import seocho_ai.classificationapp.dto.survey.request.Survey2AI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AIService {

    private final RestTemplate restTemplate;

    @Autowired
    public AIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendData2Flask(List<Survey> surveys) {
        List<Survey2AI> survey2AIS = surveys.stream()
                .map(survey -> new Survey2AI(survey.getId(), survey.getName(), survey.getAge(), survey.getGender().toString(), survey.getLanguage()))
                .collect(Collectors.toList());

        // Survey2AI DTO 리스트를 JSON 배열로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        String json;
        try {
            json = objectMapper.writeValueAsString(survey2AIS);
        } catch (JsonProcessingException e){
            e.printStackTrace();
            return;
        }

        // Flask 서버의 엔드포인트 URL
        String url = "";

        // HTTP 요청을 위한 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        // HTTP 요청을 위한 HttpEntity 생성
        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);

        // POST로 보내기
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class); // String.class로 응답을 받음

        // 응답처리
        String responseBody = response.getBody();
        System.out.println("Result: " + responseBody);

    }
}
