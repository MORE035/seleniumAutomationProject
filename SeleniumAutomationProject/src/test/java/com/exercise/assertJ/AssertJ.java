package com.exercise.assertJ;

//import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.BDDAssertions;
import org.assertj.core.api.Fail;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.data.Offset;
import org.assertj.core.data.Percentage;
import org.joda.time.LocalDate;
//import org.joda.time.LocalDate;
import org.testng.annotations.Test;

public final class AssertJ {
	private AssertJ() {
		
		
	}
	@Test
	public void stringTest() {
		String temp="Hello World";
		Assertions.assertThat(temp)
	
		.isNotNull()
		.as("String actually empty").isNotEmpty()
		.as("String actually Not Blank").isNotBlank()
		.isEqualTo("Hello World")
		.containsIgnoringCase("hello")
		.contains("Hello")
		.as("String actually empty").doesNotContain("Hi")
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
		 List<String> list4=Arrays.asList("Hi","hello","Welcome");

		 
		 Assertions.assertThat(list1)
		 .hasSize(3)
		 .hasSizeBetween(1, 15)
		 .contains("Welcome")
		 .doesNotContain("Bye")
		 
		//.withFailMessage(()->"String having less than 3")
		//.allMatch(s->s.length()>1)
		// .containsAll(list2)
		 .containsExactlyInAnyOrderElementsOf(list4);
		 
		
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
	public void DateAndTime(){
		LocalDate date=new LocalDate(2023,1,1);
		LocalDate date1=new LocalDate(2023,1,1);

		org.assertj.jodatime.api.Assertions.assertThat(date)
		.hasYear(2023)
		.hasMonthOfYear(1)
		.hasDayOfMonth(1)
		.isBefore("2024-01-01")
		.isBefore(new LocalDate(2024,1,1))
		.isBeforeOrEqualTo("2023-01-01")
		.isAfterOrEqualTo(new LocalDate(2022,1,1))
		.isIn(new LocalDate(2022,1,1),new LocalDate(2024,1,1),date1)
		.isNotIn(new LocalDate(1999,1,1),new LocalDate(1998,1,1));
		
		
		
	}
	@Test
	public void BddStyleAssertions() {
		BDDAssertions.assertThat("Hello world")
		
		.hasSize(11)
		.containsIgnoringCase("hello")
		;
	}
	@Test
	public void customClassTest() {
		Employee emp1=new Employee(25, "vasanth", 2200);
		Employee emp2=new Employee(25, "vasanth", 2200);
		Assertions.assertThat(emp1)
		.isEqualToComparingFieldByField(emp2)
		//.isEqualToComparingFieldByFieldRecursively(emp2)
		.hasFieldOrProperty("name")
		.hasFieldOrPropertyWithValue("name", "vasanth");
		//.extracting(e->e.age).isNotEqualTo(26);
		

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
