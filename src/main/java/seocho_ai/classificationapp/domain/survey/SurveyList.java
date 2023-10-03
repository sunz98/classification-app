package seocho_ai.classificationapp.domain.survey;

import java.util.ArrayList;
import java.util.List;

public class SurveyList {
    private List<Survey> surveys = new ArrayList<>();

    public List<Survey> getSurveys() {
        return surveys;
    }

    public void setSurveys(List<Survey> surveys) {
        this.surveys = surveys;
    }

    public void addSurvey(Survey survey) {
        surveys.add(survey);
    }
}
