package org.exercise.encode.decode;

import java.util.Base64;

public class Runner {

	public static void main(String[] args) {
		String encodeString = Base64.getEncoder().encodeToString("vasanth123".getBytes());
		System.out.println(encodeString);
		String decodedString = new String(Base64.getDecoder().decode(encodeString.getBytes()));
		System.out.println(decodedString);
	}
}
