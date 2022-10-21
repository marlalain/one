package dev.alexaa;

import static java.util.Objects.isNull;

public class StringUtils {
    public static void validate(String string) {
        if (isNull(string))
            throw new IllegalArgumentException("Please provide a 'String' value");

        
        boolean empty = string.trim().strip().equals("");
        if (empty)
            throw new IllegalArgumentException("Please provide a non-empty 'String' value");
    }
}
