package cn.yan.weather.configurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	  @Override
	  public void addCorsMappings(CorsRegistry registry) {
	    // 设置允许跨域的路径
	    registry.addMapping("/**") // 
	        .allowedOrigins("*") // 
	        .allowCredentials(true) // 
	        .allowedMethods("*")  // 
	        .maxAge(3600);
	  }
}