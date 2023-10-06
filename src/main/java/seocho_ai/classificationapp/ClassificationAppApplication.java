package seocho_ai.classificationapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ClassificationAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClassificationAppApplication.class, args);
	}

//	public static void main(String[] args) {
//		isStartsA("ABC");
//	}

	// 아래 내용 찾아보기
	// final
	// 정적 팩토리 메소드

	// 언제 static을 써야 할까요?
	//  static 변수는 언제 써야 할까요? -> 상수 일 때 final static
	//  static 함수는 언제 써야 할까요?
	//    생성자를 안써야 할 때 = 생성자를 굳이 안만들어야 할 때
	//    유틸성 기능을 많이 넣음. 정적 팩토리 메소드. (꽤 자주) 컨버팅

	// 어떤 문자열이 A로 시작하는가?

}
