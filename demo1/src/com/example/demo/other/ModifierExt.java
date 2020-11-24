package com.example.demo.other;

@SuppressWarnings("unused")
public class ModifierExt {

	/**
	 * java.util.Base64
	 * This array is a lookup table that translates 6-bit positive integer
	 * index values into their "Base64 Alphabet" equivalents as specified
	 * in "Table 1: The Base64 Alphabet" of RFC 2045 (and RFC 4648).
	 */
	private static final char[] toBase64 = {
	    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
	    'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
	    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
	    'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
	    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
	};

	/**
	 * java.util.Base64
	 * It's the lookup table for "URL and Filename safe Base64" as specified
	 * in Table 2 of the RFC 4648, with the '+' and '/' changed to '-' and
	 * '_'. This table is used when BASE64_URL is specified.
	 */
	private static final char[] toBase64URL = {
	    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
	    'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
	    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
	    'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
	    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'
	};

	
	public static void main(String[] args) {
		
 	}
}
