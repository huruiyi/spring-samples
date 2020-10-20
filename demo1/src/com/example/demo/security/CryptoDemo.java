package com.example.demo.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CryptoDemo {

	public static void main(String[] args) {
		$2yMatches();
		$2aMatches();
		$2bMatches();
	}

	public static void $2yMatches() {
		System.out.println(".............................$2yMatches.............................");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String result = encoder.encode("password");
		System.out.println(result);
		System.out.println(encoder.matches("password", result));
	}

	public static void $2aMatches() {
		System.out.println(".............................$2aMatches.............................");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2A);
		String result = encoder.encode("password");
		System.out.println(result);
		System.out.println(encoder.matches("password", result));
	}

	public static void $2bMatches() {
		System.out.println(".............................$2bMatches.............................");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2B);
		String result = encoder.encode("password");
		System.out.println(result);
		System.out.println(encoder.matches("password", result));
	}

}
