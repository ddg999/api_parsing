package ch01;

import com.google.gson.Gson;

public class MainTest1 {
	
	public static void main(String[] args) {
		// Gson <-- 현재 사용 불가
		// lib 폴더에 Gson 라이브러리 추가
		// 우리 소스 코드상에 사용하기 위해 설정이 필요하다.
		
		// 프로젝트 속성에서 Build Path - Classpath 에 add jars 등록
		Gson gson = new Gson();
		gson.fieldNamingStrategy();
		
		Student student1 = new Student();
	}
}
