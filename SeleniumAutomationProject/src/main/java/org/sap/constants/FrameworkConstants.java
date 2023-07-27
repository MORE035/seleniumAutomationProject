package org.sap.constants;

public final class FrameworkConstants {
	
	private FrameworkConstants() {
		
	}
	private static final String RESOURCEPATH= System.getProperty("user.dir")+"\\src\\test\\resources";

	private static final String CHROMEDRIVERPATH= RESOURCEPATH+"\\drivers\\chromedriver.exe";
	private static final String CONFIGFILEPATH= RESOURCEPATH+"\\config\\config.property";
	private static final Integer EXPLICITWAIT= 10;


	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}
	public static String getCHROMEDRIVERPATH() {
		return CHROMEDRIVERPATH;
	}
	public static String getCONFIGFILEPATH() {
		return CONFIGFILEPATH;
	}
}
