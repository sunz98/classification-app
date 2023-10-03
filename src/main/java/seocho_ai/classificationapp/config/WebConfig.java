package seocho_ai.classificationapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 이게 무슨 뜻인가?
    // 이걸 적용하면 구체적으로 무엇이 달라질까요? (HTTP Header)
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")    // 허용할 출처
                .allowedMethods("GET", "POST")      // 허용할 HTTP Method
                .maxAge(3000);      // 원하는 시간만큼 pre-flight 리퀘스트를 캐싱
    }
}
