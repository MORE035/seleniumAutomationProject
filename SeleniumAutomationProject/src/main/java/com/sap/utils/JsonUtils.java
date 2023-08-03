package com.sap.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import org.sap.constants.FrameworkConstants;
import org.sap.enums.ConfigProperties;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {


	private JsonUtils() {

	}

	private static  Map<String,String> CONFIGMAP=new HashMap<String,String>();
	static {

		FileInputStream fil;
		try {
		//	fil = new FileInputStream(FrameworkConstants.getCONFIGFILEPATH());
			CONFIGMAP=new ObjectMapper()
					.readValue(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\jsonFiles\\file1.json"), 
							HashMap.class);
		/*	for(Object key :property.entrySet()) {
				CONFIGMAP.put(String.valueOf(key), String.valueOf(property.get(key)));
			}//one way assign values to Hash map
			
		*/
			
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	
	//Hash table -little slow but thread safe
	public static String get(ConfigProperties key) throws Exception {
		if(Objects.isNull(key)||Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new Exception("property key :" + key + " value is null");

		}
		return CONFIGMAP.get(key.toString().toLowerCase());
	}

	


}
