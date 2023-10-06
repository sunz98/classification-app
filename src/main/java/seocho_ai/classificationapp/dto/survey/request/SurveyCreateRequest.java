package seocho_ai.classificationapp.dto.survey.request;

import lombok.Getter;
import seocho_ai.classificationapp.domain.survey.Survey;
import seocho_ai.classificationapp.enums.Gender;

@Getter
public class SurveyCreateRequest {

    private String name;
    private Integer age;
    private Gender gender;
    private String language;

    public SurveyCreateRequest(String name, Integer age, Gender gender, String language) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.language = language;
    }

    public Survey toSurvey() {
        return new Survey(name, age, gender, language);
    }
}
