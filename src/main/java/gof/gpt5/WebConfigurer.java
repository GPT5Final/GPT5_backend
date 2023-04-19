package gof.gpt5;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration		// 설정
public class WebConfigurer implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		// 접속 클라이언트 허가
//		registry.addMapping("/**").allowedOrigins("http://localhost:8090");		// 특정 클라이언트
		registry.addMapping("/**").allowedOrigins("*");							// 모든 클라이언트
		
	}
	
}
