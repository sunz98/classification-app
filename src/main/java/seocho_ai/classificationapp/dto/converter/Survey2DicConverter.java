package seocho_ai.classificationapp.dto.converter;

import seocho_ai.classificationapp.domain.survey.Survey;
import seocho_ai.classificationapp.domain.dictionary.DictionaryEntry;

public class Survey2DicConverter {

    public DictionaryEntry convert(Survey survey) {

        String name = survey.getName();
        String age = survey.getAge().toString();
        String gender = survey.getGender().toString();
        String language = survey.getLanguage();

        DictionaryEntry entry = new DictionaryEntry("name", name);

        entry.setKey("age");
        entry.setValue(age);

        entry.setKey("gender");
        entry.setValue(age);

        entry.setKey("age");
        entry.setValue(age);

        return entry;
    }
}
