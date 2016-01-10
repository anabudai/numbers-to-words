package com.worldpay.numbers_to_words.constant;

import java.util.Arrays;
import java.util.List;

public final class NumberToWordConstants {

    private NumberToWordConstants() {}

    /**
     * General constants:
     */
    public static String STRING_EMPTY = "";
    public static String STRING_SPACE = " ";
    public static String AND = "and";

    public static int NUMBER_LOWER_LIMIT = 0;
    public static int NUMBER_UPPER_LIMIT = 999999999;

    /**
     * Exception codes:
     */
    public static String NUMBER_IS_NOT_BETWEEN_LIMITS_EXCEPTION_CODE = "numberIsNotBetweenLimits";

    /**
     * Cyphers:
     */
    public static final String ZERO = "zero";
    public static final String ONE = "one";
    public static final String TWO = "two";
    public static final String THREE = "three";
    public static final String FOUR = "four";
    public static final String FIVE = "five";
    public static final String SIX = "six";
    public static final String SEVEN = "seven";
    public static final String EIGHT = "eight";
    public static final String NINE = "nine";
    public static final String TEN = "ten";
    public static final String ELEVEN = "eleven";
    public static final String TWELVE = "twelve";
    public static final String THIRTEEN = "thirteen";
    public static final String FOURTEEN = "fourteen";
    public static final String FIFTEEN = "fifteen";
    public static final String SIXTEEN = "sixteen";
    public static final String SEVENTEEN = "seventeen";
    public static final String EIGHTEEN = "eighteen";
    public static final String NINETEEN = "nineteen";

    /**
     * Decimals:
     */
    public static final String TWENTY = "twenty";
    public static final String THIRTY = "thirty";
    public static final String FORTY = "forty";
    public static final String FIFTY = "fifty";
    public static final String SIXTY = "sixty";
    public static final String SEVENTY = "seventy";
    public static final String EIGHTY = "eighty";
    public static final String NINETY = "ninety";

    public static final String HUNDRED = "hundred";
    public static final String THOUSAND = "thousand";
    public static final String MILLION = "million";

    public static final List<String> NUMBERS_FROM_0_TO_20 = Arrays.asList(ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX,
            SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, FIFTEEN, SIXTEEN,
            SEVENTEEN, EIGHTEEN, NINETEEN);

    public static final List<String> DECIMALS = Arrays.asList(TWENTY, THIRTY, FORTY, FIFTY, SIXTY, SEVENTY, EIGHTY,
            NINETY);

    public static List<String> NUMERIC_GROUPS = Arrays.asList(STRING_EMPTY, THOUSAND, MILLION);
}
