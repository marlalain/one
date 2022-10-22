package dev.alexaa;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class StringValidator {
	public static void validate(String string) {
		if (isBlank(string))
			throw new IllegalArgumentException("Please provide a valid, non-empty 'String' value");
	}
}
