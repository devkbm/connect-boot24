package com.like.core.util;

import static org.assertj.core.api.BDDAssertions.then;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@ExtendWith(SpringExtension.class)
public class LocalDateUtilTest {

	@Test
	@DisplayName("isBetween 정상 케이스")
	public void isBetween_정상_테스트() {			
		// Given - When
		boolean result = LocalDateUtil.isBetween(LocalDate.of(2021, 3, 1), LocalDate.of(2021, 1, 1), LocalDate.of(2021, 12, 1));
				
		//Then
		then(result).isTrue();				
	}
	
	@Test
	@DisplayName("isBetween 예외케이스1 이전일자 입력")
	public void isBetween_예외_테스트1() {				
		// Given - When
		boolean result = LocalDateUtil.isBetween(LocalDate.of(2020, 1, 1), LocalDate.of(2021, 1, 1), LocalDate.of(2021, 12, 1));
		
		//Then
		then(result).isFalse();				
	}
	
	@Test
	@DisplayName("isBetween 예외케이스2 이후일자 입력")
	public void isBetween_예외_테스트2() {		
		// Given - When
		boolean result = LocalDateUtil.isBetween(LocalDate.of(2022, 1, 1), LocalDate.of(2021, 1, 1), LocalDate.of(2021, 12, 1));
		
		//Then
		then(result).isFalse();				
	}
	
	
}
