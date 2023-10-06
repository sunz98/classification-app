package seocho_ai.classificationapp.controller;

import org.springframework.web.bind.annotation.*;
import seocho_ai.classificationapp.dto.survey.request.SurveyCreateRequest;
import seocho_ai.classificationapp.service.survey.PersonalSurveyService;

import java.util.List;

@RestController
public class SurveyController {

    private final PersonalSurveyService personalSurveyService;

    public SurveyController(PersonalSurveyService personalSurveyService) {
        this.personalSurveyService = personalSurveyService;
    }

    @PostMapping("/survey")
    public void saveSurveys(@RequestBody List<SurveyCreateRequest> requests) {
        for (SurveyCreateRequest request : requests) {
            personalSurveyService.saveSurvey(request);
        }
    }
}
