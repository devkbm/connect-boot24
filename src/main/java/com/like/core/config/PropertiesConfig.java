package com.like.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.like.core.properties.KakaoProperties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;


@Configuration
@EnableConfigurationProperties({
	KakaoProperties.class
})
@PropertySource({
	"classpath:properties/kakao.properties"
})
public class PropertiesConfig {

}
