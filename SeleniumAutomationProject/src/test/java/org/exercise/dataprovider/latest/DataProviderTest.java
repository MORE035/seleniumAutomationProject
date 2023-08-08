package org.exercise.dataprovider.latest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;


public final class DataProviderTest {

	@Test(dataProvider = "data", dataProviderClass = DataProvideClass.class)
	public void test1(Integer number1, Integer number2) {
		System.out.println(number1);
	}

	@Test(dataProvider = "data")
	public void test2(Integer number1) {
		System.out.println(number1);
	}

	@Test(dataProvider = "data")
	public void test3(String number1) {
		System.out.println(number1);
	}

	@Test(dataProvider = "dataProviderWithExcelStandedValues")
	public void dataProviderTestWithExcel(String name, String age, String salary) {
		System.out.println(name + " " + age + " " + salary);
	}

	@Test(dataProvider = "dataProviderWithExcelByHashMap")
	public void dataProviderTestWithExcelHasMap(Map<String, String> map) {
		System.out.println(map.get("company"));
	}
	@Test(dataProvider = "dataProviderWithJsonFiles")
	public void dataProvierTestjsonFile(Map<String,Object>map) {
		//map.forEach((k,v)->System.out.println(k+" "+v));
	}

	@DataProvider // Note mutiple test data single Data test
	public static Object[] data(Method m) {
		if (m.getName().equalsIgnoreCase("test2")) {
			return new Integer[] { 1, 2, 3 };

		} else if (m.getName().equalsIgnoreCase("test3")) {
			return new String[] { "1", "2", "3" };

		}
		return null;
	}

	@DataProvider
	public Object[][] dataProviderWithExcelStandedValues() throws IOException {
		FileInputStream fi = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\ExcelFiles\\ConstantTestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fi);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int numberOfRows = sheet.getLastRowNum();
		short numberOfColumns = sheet.getRow(0).getLastCellNum();
		Object obj[][] = new Object[numberOfRows][numberOfColumns];
		for (int i = 1; i <= numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				obj[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		workbook.close();
		fi.close();
		return obj;
	}

	@DataProvider
	public Object[] dataProviderWithExcelByHashMap() throws IOException {
		FileInputStream fi = new FileInputStream(
		System.getProperty("user.dir") + "\\src\\test\\resources\\ExcelFiles\\ConstantTestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fi);
		XSSFSheet sheet = workbook.getSheet("Sheet2");
		int numberOfRows = sheet.getLastRowNum();
		int numberOfColumns = sheet.getRow(0).getLastCellNum();
		Map<String, String> map ;
		Object obj[] = new Object[numberOfRows];
		for (int i = 1; i <= numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				map = new HashMap<String, String>();
				String key = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);
				obj[i - 1] = map;
			}
			

		}

		workbook.close();
		fi.close();
		return obj;
	}

	@DataProvider
	public Object[] dataProviderWithJsonFiles() throws StreamReadException, DatabindException, IOException {
		//need to import to packs Jackson databind,Jackson core
		
		HashMap<String,Object>map1=new ObjectMapper()
				.readValue(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\jsonFiles\\file1.json"), 
						new TypeReference<HashMap<String,Object>>(){});
		HashMap<String,Object>map2=new ObjectMapper()
				.readValue(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\jsonFiles\\file2.json"), 
						new TypeReference<HashMap<String,Object>>(){});
		return new Object[] {map1,map2};
	}
}
