package com.sap.utils;

import java.util.Base64;

public final class DecodeUtils {

	private DecodeUtils() {	}
	public static String getDecoderString(String encodeString) {
		return new String(Base64.getDecoder().decode(encodeString.getBytes()));
	}
}
