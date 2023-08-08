package com.sap.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import org.sap.constants.FrameworkConstants;
import org.sap.enums.ConfigProperties;

public class ReadPropertyFileUtils {

	private ReadPropertyFileUtils() {

	}

	private static Properties property = new Properties();
	private static final Map<String,String> CONFIGMAP=new HashMap<String,String>();
	static {

		FileInputStream fil;
		try {
			fil = new FileInputStream(FrameworkConstants.getCONFIGFILEPATH());
			property.load(fil);
		/*	for(Object key :property.entrySet()) {
				CONFIGMAP.put(String.valueOf(key), String.valueOf(property.get(key)));
			}//one way assign values to Hash map
			
		*/
			
			for(Map.Entry<Object, Object> entry :property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}//one way assign values to Hash map code review point of view

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	
	//Hash table -little slow but thread safe
	public static String get(ConfigProperties key)  {
		if(Objects.isNull(key)||Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			try {
			throw new Exception("property key :" + key + " value is null");
			}
			catch (Exception e) {
			}

		}
		return CONFIGMAP.get(key.toString().toLowerCase());
	}

	@Deprecated //replaced with get()
	public static String getValue(String key) throws Exception {
 		if (Objects.isNull(property.getProperty(key))||Objects.isNull(key)) {
			throw new Exception("property key :" + key + " value is null");
		}
		return property.getProperty(key);

	}
}
