package seocho_ai.classificationapp.dto.survey.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Survey2AI {

    private Long id;

    private String name;

    private Integer age;

    private String gender;

    private String language;

    public Survey2AI(Long id, String name, Integer age, String gender, String language) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.language = language;
    }

    public Survey2AI() {
        this.id = null;
        this.name = null;
        this.age = null;
        this.gender = null;
        this.language = null;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getLanguage() {
        return language;
    }
}
