package com.sap.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.sap.constants.FrameworkConstants;

public class ExcelUtils {

	private ExcelUtils() {
	}

	public static List<Map<String, String>> getTestData(String sheetName) {
		FileInputStream fi = null;
		List<Map<String, String>> list = null;
		try {
			fi = new FileInputStream(FrameworkConstants.getTestexcelfilepath());
			Workbook workbook = new XSSFWorkbook(fi);
			Sheet sheet = workbook.getSheet(sheetName);
			
			Map<String, String> map = null;
			list = new ArrayList<>();
			int lastRow = sheet.getLastRowNum();
			short lastColum = sheet.getRow(0).getLastCellNum();
			for (int i = 1; i <= lastRow; i++) {
				map = new HashMap<String, String>();
				for (int j = 0; j <lastColum; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
//				if(Objects.nonNull(workbook)){
//					workbook.close();
//				}
				if (Objects.nonNull(fi)) {
					fi.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;

	}
}
