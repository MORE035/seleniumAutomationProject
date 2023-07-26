package org.sap.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.data.Offset;
import org.assertj.core.data.Percentage;
import org.testng.annotations.Test;

public final class AssertJ {
	private AssertJ() {
		
		
	}
	@Test
	public void stringTest() {
		String temp="Hello world";
		Assertions.assertThat(temp)
		.isNotNull()
		.as("String actually empty").isNotEmpty()
		.as("String actually Not Blank").isNotBlank()
		.isEqualTo("Hello world")
		.contains("Hello")
		.doesNotContain("Hi")
		.containsWhitespaces()
		.hasSize(11)
		.containsIgnoringCase("HELLO");///so many validation points is there.....
		
		
	}
	@Test
	public void numberTest() {
		int number=123;
		Assertions.assertThat(number)
		.isEqualTo(123)
		.isCloseTo(130, Offset.offset(10))
		.isInstanceOf(Integer.class)
		.isBetween(100, 150)
		.isCloseTo(130, Percentage.withPercentage(30))
		.isPositive()
		//.isEven()
		.isOdd()
		.isGreaterThan(100)
		.isLessThan(150);///like that so many validations takes at single shot
	}
	
	@Test
	public void listTest() {
		 List<String> list1=Arrays.asList("Hello","Hi","Welcome");
		 List<String> list2=Arrays.asList("Hmm","Oh","Bye");
		 List<String> list3=Arrays.asList("GoodBye","Better");
		 
		 Assertions.assertThat(list1)
		 .hasSize(3)
		 .hasSizeBetween(1, 15)
		 .contains("Welcome")
		 .doesNotContain("Bye")
		 .withFailMessage(()->"String having less than 3").allMatch(s->s.length()>3)
		 .containsAll(list2)
		 .doesNotContainAnyElementsOf(list3);
	}
	@Test
	public void mapTest() {
		Map<String,String> map1=new HashMap<String,String>();
		map1.put("Vasanth", "Btech");
		map1.put("Pavan", "MCA");
		map1.put("Malthi", "Btech");
		Assertions.assertThat(map1)
		.containsEntry("Vasanth", "Btech")
		.hasSize(3)
		.isNotEmpty()
		.doesNotContainEntry("deep", "Btech")
		.doesNotContainKey("Mohan")
		.containsKey("Pavan")
		.containsValue("MCA");
	}

	@Test
	public void assertSoftly() {
		SoftAssertions sa=new SoftAssertions();
		sa.assertThat("Hello world")
		.hasSize(10)
		.containsIgnoringCase("hello");
		System.out.println("End of the Method");
		sa.assertAll();
	}
}
