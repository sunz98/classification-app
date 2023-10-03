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
import seocho_ai.classificationapp.domain.survey.SurveyList;
import seocho_ai.classificationapp.dto.converter.Survey2DicConverter;
import seocho_ai.classificationapp.domain.dictionary.DictionaryEntry;

import java.util.ArrayList;
import java.util.List;

@Service
public class AIService {

    private final RestTemplate restTemplate;
    private final Survey2DicConverter survey2DicConverter;
    private final SurveyList surveyList;

    @Autowired
    public AIService(RestTemplate restTemplate, Survey2DicConverter survey2DicConverter, SurveyList surveyList) {
        this.restTemplate = restTemplate;
        this.survey2DicConverter = survey2DicConverter;
        this.surveyList = surveyList;
    }


    public void sendData2Flask() {
        // SurveyList에서 Survey 객체 리스트 가져오기
        List<Survey> surveys = surveyList.getSurveys();

        // Survey 객체를 Dictionary로 변환
        List<DictionaryEntry> entryList = new ArrayList<>();
        for (Survey survey : surveys) {
            DictionaryEntry entry = survey2DicConverter.convert(survey);
            entryList.add(entry);
        }

        // Flask 서버의 엔드포인트 URL
        String url = "";

        // HTTP 요청을 위한 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // DictionaryEntry 객체를 JSON 형식으로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        String entryJson;
        try {
            entryJson = objectMapper.writeValueAsString(entryList);
        } catch (JsonProcessingException e) {
            return;
        }

        // HTTP 요청을 위한 HttpENtity 생성
        HttpEntity<String> requestEntity = new HttpEntity<>(entryJson, headers);

        // POST로 보내기
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);

        // 응답처리
        String resposeBody = response.getBody();
        System.out.println("Result: " + resposeBody);

    }
}
