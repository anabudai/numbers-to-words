package com.worldpay.numbers_to_words.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {

    private StringUtils() {
    }

    public static List<String> splitIntoChunksOfSizeStartingRight(String value, int size) {

        List<String> result = new ArrayList<String>();

        if(shouldContinueWithSplitting(value, size)) {
            int firstChunkSize = (value.length() % size != 0) ? (value.length()) % size : size;
            result.add(value.substring(0, firstChunkSize));
            if(existsMoreChunks(value, firstChunkSize)) {
                int position = firstChunkSize;
                while(position + size <= value.length()) {
                    result.add(value.substring(position, position + size));
                    position += size;
                }
            }
        }

        return result;
    }

    private static boolean shouldContinueWithSplitting(String value, int size) {
        return size > 0 && value != null && !value.trim().isEmpty();
    }

    private static boolean existsMoreChunks(String value, int firstChunkSize) {
        return value.length() > firstChunkSize;
    }
}
