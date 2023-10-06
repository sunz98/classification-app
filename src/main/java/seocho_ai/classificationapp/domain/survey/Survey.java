package seocho_ai.classificationapp.domain.survey;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import seocho_ai.classificationapp.enums.Gender;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 20)
    private String name;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender; // enum class 꼭 찾아보세요 ^^
    private String language;

    public Survey(String name, Integer age, Gender gender, String language) {
        // 이 더럽게 귀찮은 검증 어떻게 줄일 수 있을까?
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.", name));
        }
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.language = language;
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

    public Gender getGender() {
        return gender;
    }

    public String getLanguage() {
        return language;
    }


}
