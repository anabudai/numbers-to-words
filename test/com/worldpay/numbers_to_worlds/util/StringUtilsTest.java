package com.worldpay.numbers_to_worlds.util;

import com.worldpay.numbers_to_words.util.StringUtils;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;

public class StringUtilsTest {

    private static final String STR_EMPTY = "";
    private static final String STR_SPACE = " ";

    private static final String STR_VALUE_WITH_FIRST_CHUNK_OF_DIFFERENT_SIZE = "1234567";
    private static final String STR_VALUE_WITH_FIRST_CHUNK_OF_DIFFERENT_SIZE_1 = "1";
    private static final String STR_VALUE_WITH_FIRST_CHUNK_OF_DIFFERENT_SIZE_2 = "234";
    private static final String STR_VALUE_WITH_FIRST_CHUNK_OF_DIFFERENT_SIZE_3 = "567";

    private static final String STR_VALUE_WITH_EQUAL_SIZE_CHUNKS = "123456789";
    private static final String STR_VALUE_WITH_EQUAL_SIZE_CHUNKS_1 = "123";
    private static final String STR_VALUE_WITH_EQUAL_SIZE_CHUNKS_2 = "456";
    private static final String STR_VALUE_WITH_EQUAL_SIZE_CHUNKS_3 = "789";

    @Test
    public void splitIntoChunksByNumberFromRight_shouldReturnEmptyList_whenValueIsNull() {

        List<String> actualResult = StringUtils.splitIntoChunksOfSizeStartingRight(null, 3);

        assertNotNull(actualResult);
        assertTrue(actualResult.isEmpty());
    }

    @Test
    public void splitIntoChunksByNumberFromRight_shouldReturnEmptyList_whenValueIsEmpty() {

        List<String> actualResult = StringUtils.splitIntoChunksOfSizeStartingRight(STR_EMPTY, 3);

        assertNotNull(actualResult);
        assertTrue(actualResult.isEmpty());
    }

    @Test
    public void splitIntoChunksByNumberFromRight_shouldReturnEmptyList_whenValueIsSpace() {

        List<String> actualResult = StringUtils.splitIntoChunksOfSizeStartingRight(STR_SPACE, 3);

        assertNotNull(actualResult);
        assertTrue(actualResult.isEmpty());
    }

    @Test
    public void splitIntoChunksByNumberFromRight_shouldReturnEmptyList_whenSizeisNegative() {

        List<String> actualResult = StringUtils.splitIntoChunksOfSizeStartingRight(STR_SPACE, -3);

        assertNotNull(actualResult);
        assertTrue(actualResult.isEmpty());
    }

    @Test
    public void splitIntoChunksByNumberFromRight_shouldReturnChunksList_whenValueIsNotEmptyAndSizePositiveAndFirstChunkHasDifferentSize() {

        List<String> actualResult = StringUtils.splitIntoChunksOfSizeStartingRight(STR_VALUE_WITH_FIRST_CHUNK_OF_DIFFERENT_SIZE, 3);

        assertNotNull(actualResult);
        assertFalse(actualResult.isEmpty());
        assertEquals(3, actualResult.size());
        assertTrue(actualResult.contains(STR_VALUE_WITH_FIRST_CHUNK_OF_DIFFERENT_SIZE_1));
        assertTrue(actualResult.contains(STR_VALUE_WITH_FIRST_CHUNK_OF_DIFFERENT_SIZE_2));
        assertTrue(actualResult.contains(STR_VALUE_WITH_FIRST_CHUNK_OF_DIFFERENT_SIZE_3));
    }

    @Test
    public void splitIntoChunksByNumberFromRight_shouldReturnChunksList_whenValueIsNotEmptyAndSizePositiveAndFirstChunkIsOfSize() {

        List<String> actualResult = StringUtils.splitIntoChunksOfSizeStartingRight(STR_VALUE_WITH_EQUAL_SIZE_CHUNKS, 3);

        assertNotNull(actualResult);
        assertFalse(actualResult.isEmpty());
        assertEquals(3, actualResult.size());
        assertTrue(actualResult.contains(STR_VALUE_WITH_EQUAL_SIZE_CHUNKS_1));
        assertTrue(actualResult.contains(STR_VALUE_WITH_EQUAL_SIZE_CHUNKS_2));
        assertTrue(actualResult.contains(STR_VALUE_WITH_EQUAL_SIZE_CHUNKS_3));
    }
}
