package seocho_ai.classificationapp.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import seocho_ai.classificationapp.dto.survey.request.SurveyCreateRequest;
import seocho_ai.classificationapp.service.survey.SurveyService;

@RestController
public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @PostMapping("/survey")
    public void saveSurvey(@RequestBody SurveyCreateRequest request) {
        surveyService.saveSurvey(request);
    }

}
