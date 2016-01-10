package com.worldpay.numbers_to_worlds;

import com.worldpay.numbers_to_words.NumberToWordTransformer;
import com.worldpay.numbers_to_words.impl.NumberToWordTransformerImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberToWordTransformerImplTest {

    private static final String NUMBER_0 = "zero";
    private static final String NUMBER_1 = "one";
    private static final String NUMBER_21 = "twenty one";
    private static final String NUMBER_105 = "one hundred and five";
    private static final String NUMBER_123 = "one hundred and twenty three";
    private static final String NUMBER_1005 = "one thousand and five";
    private static final String NUMBER_1042 = "one thousand and forty two";
    private static final String NUMBER_1105 = "one thousand one hundred and five";
    private  static  final String NUMBER_56945781
            = "fifty six million nine hundred and forty five thousand seven hundred and eighty one";
    private  static  final String NUMBER_999999999
            = "nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine";

    private NumberToWordTransformer numberToWordTransformer;

    @Before
    public void setUp() {
        numberToWordTransformer = new NumberToWordTransformerImpl();
    }

    @Test
    public void shouldReturnZero_whenNumberIsZero() {

        String actualWord = numberToWordTransformer.transform(0);

        assertEquals(actualWord, NUMBER_0);
    }

    @Test
    public void shouldReturnOne_whenNumberIsOne() {

        String actualWord = numberToWordTransformer.transform(1);

        assertEquals(actualWord, NUMBER_1);
    }

    @Test
    public void shouldReturnTwentyOne_whenNumberIsTwentyOne() {

        String actualWord = numberToWordTransformer.transform(21);

        assertEquals(NUMBER_21, actualWord);
    }

    @Test
    public void shouldReturnOneHundredAndFive_whenNumberIsOneHundredAndFive() {

        String actualWord = numberToWordTransformer.transform(105);

        assertEquals(NUMBER_105, actualWord);
    }

    @Test
    public void shouldReturnOneHundredTwentyThree_whenNumberIsOneHundredTwentyThree() {

        String actualWord = numberToWordTransformer.transform(123);

        assertEquals(NUMBER_123, actualWord);
    }

    @Test
    public void shouldReturnOneThousandAndFive_whenNumberIsOneThousandAndFive() {

        String actualWord = numberToWordTransformer.transform(1005);

        assertEquals(NUMBER_1005, actualWord);
    }

    @Test
    public void shouldReturnOneThousandAndFortyTwo_whenNumberIsOneThousandAndFortyTwo() {

        String actualWord = numberToWordTransformer.transform(1042);

        assertEquals(NUMBER_1042, actualWord);
    }

    @Test
    public void shouldReturnOneThousandOneHundredAndFive_whenNumberIsOneThousandOneHundredAndFive() {

        String actualWord = numberToWordTransformer.transform(1105);

        assertEquals(NUMBER_1105, actualWord);
    }

    @Test
    public void shouldReturn56945781AsWord_whenNumberIs56945781() {

        String actualWord = numberToWordTransformer.transform(56945781);

        assertEquals(NUMBER_56945781, actualWord);
    }

    @Test
    public void shouldReturn999999999AsWord_whenNumberIs999999999() {

        String actualWord = numberToWordTransformer.transform(999999999);

        assertEquals(NUMBER_999999999, actualWord);
    }
}
