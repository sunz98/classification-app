package seocho_ai.classificationapp.service.survey;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seocho_ai.classificationapp.domain.survey.Survey;
import seocho_ai.classificationapp.domain.survey.SurveyList;
import seocho_ai.classificationapp.domain.survey.SurveyRepository;
import seocho_ai.classificationapp.dto.survey.request.SurveyCreateRequest;

@Service
public class SurveyService {

    private final SurveyRepository surveyRepository;
    private final SurveyList surveyList;

    public SurveyService(SurveyRepository surveyRepository, SurveyList surveyList) {
        this.surveyRepository = surveyRepository;
        this.surveyList = surveyList;
    }

    @Transactional
    public void saveSurvey(SurveyCreateRequest request) {
        // 이 긴 코드를 어떻게 줄일 것인가.
        Survey s = surveyRepository.save(new Survey(request.getName(), request.getAge(), request.getGender(), request.getLanguage()));

        surveyList.addSurvey(s);
    }


}
