package seocho_ai.classificationapp.service.survey;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seocho_ai.classificationapp.domain.survey.Survey;
import seocho_ai.classificationapp.domain.survey.SurveyRepository;
import seocho_ai.classificationapp.dto.survey.request.SurveyCreateRequest;

@Service
public class PersonalSurveyService {

    private final SurveyRepository surveyRepository;

    public PersonalSurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Transactional
    public void saveSurvey(SurveyCreateRequest request) {
        // 이 긴 코드를 어떻게 줄일 것인가.
        Survey survey = request.toSurvey();
        // 개인용은 db에 저장하지 않을것이므로 주석처리
//        surveyRepository.save(survey);
    }


}
