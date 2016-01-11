package com.worldpay.numbers_to_words.transformer.impl;

import com.worldpay.numbers_to_words.exception.NumberToWordException;
import com.worldpay.numbers_to_words.transformer.NumberToWordTransformer;
import com.worldpay.numbers_to_words.util.StringUtils;
import com.worldpay.numbers_to_words.validator.NumberRangeValidator;
import com.worldpay.numbers_to_words.validator.impl.NumberRangeValidatorImpl;

import java.util.List;

import static com.worldpay.numbers_to_words.constant.NumberToWordConstants.*;


public class NumberToWordTransformerImpl implements NumberToWordTransformer {

    private NumberRangeValidator numberRangeValidator;

    public NumberToWordTransformerImpl() {
        numberRangeValidator = new NumberRangeValidatorImpl();
    }

    /**
     * Transforms a number into a word;
     * for example if number=1150, the result is one thousand one hundred and five.
     *
     * @param number
     * @return
     */
    public String transform(int number) {
        if(!numberRangeValidator.validate(number)) {
            throw new NumberToWordException(NUMBER_IS_NOT_BETWEEN_LIMITS_EXCEPTION_CODE);
        }
        List<String> numberSplitIntoGroups = StringUtils.splitIntoChunksOfSizeStartingRight(String.valueOf(number), 3);
        return transformNumericGroupsIntoWord(numberSplitIntoGroups);
    }

    /**
     * Transforms the groups of cyphers into their corresponding word.
     *
     * @param numberSplitIntoGroups
     * @return
     */
    private String transformNumericGroupsIntoWord(List<String> numberSplitIntoGroups) {
        StringBuilder numberAsWord = new StringBuilder();
        for(int i = 0; i < numberSplitIntoGroups.size(); ++i) {
            int group = Integer.valueOf(numberSplitIntoGroups.get(i));
            String word = transformNumericGroupIntoWord(group, i > 0);
            numberAsWord.append(word).append(STRING_SPACE)
                    .append(NUMERIC_GROUPS.get(numberSplitIntoGroups.size() - i - 1)).append(STRING_SPACE);
        }
        return numberAsWord.toString().trim();
    }

    /**
     *  Transforms the group of cyphers into its corresponding word.
     *
     * @param number
     * @param hasAGroupInFrontOfIt
     * @return
     */
    private String transformNumericGroupIntoWord(int number, boolean hasAGroupInFrontOfIt) {
        StringBuilder numberAsWord = new StringBuilder();
        int numberOfHundreds = number / 100;
        int twoDigitsPart = number % 100;
        if(numberOfHundreds > 0) {
            String threeDigitsWord
                    = getWordFromThreeDigitsNumberWithAndPrefixIfNecessary(numberOfHundreds, twoDigitsPart);
            numberAsWord.append(threeDigitsWord);
        } else {
            String twoDigitsWord = getWordFromTwoDigitsNumberWithAndPrefixIfNecessary(number, hasAGroupInFrontOfIt);
            numberAsWord.append(twoDigitsWord);
        }
        return numberAsWord.toString().trim();
    }

    /**
     * Transforms a two digits number into its corresponding word, with the AND prefix if necessary.
     *
     * @param number
     * @param hasAGroupInFrontOfIt
     * @return
     */
    private String getWordFromTwoDigitsNumberWithAndPrefixIfNecessary(int number, boolean hasAGroupInFrontOfIt) {
        StringBuilder numberAsWord = new StringBuilder();
        if (hasAGroupInFrontOfIt) {
            numberAsWord.append(STRING_SPACE).append(AND).append(STRING_SPACE);
        }
        numberAsWord.append(transformTwoDigitsNumberIntoWord(number));
        return numberAsWord.toString();
    }

    /**
     * Transforms a three digits number into its corresponding word, with the AND prefix if necessary.
     *
     * @param numberOfHundreds
     * @param twoDigitsPart
     * @return
     */
    private String getWordFromThreeDigitsNumberWithAndPrefixIfNecessary(int numberOfHundreds, int twoDigitsPart) {
        StringBuilder numberAsWord = new StringBuilder();
        numberAsWord.append(NUMBERS_FROM_0_TO_20.get(numberOfHundreds)).append(STRING_SPACE).append(HUNDRED);
        if(twoDigitsPart > 0) {
            numberAsWord.append(STRING_SPACE).append(AND).append(STRING_SPACE)
                    .append(transformTwoDigitsNumberIntoWord(twoDigitsPart));
        }
        return numberAsWord.toString();
    }

    /**
     * Transforms a two digits number into its corresponding word.
     *
     * @param number
     * @return
     */
    private String transformTwoDigitsNumberIntoWord(int number) {
        StringBuilder numberAsWord = new StringBuilder();
        if(number < 20) {
            numberAsWord.append(NUMBERS_FROM_0_TO_20.get(number));
        } else {
            int numberOfDecimals = number / 10;
            int numberOfUnits = number % 10;
            numberAsWord.append(DECIMALS.get(numberOfDecimals - 2)).append( STRING_SPACE)
                    .append(NUMBERS_FROM_0_TO_20.get(numberOfUnits));
        }
        return  numberAsWord.toString().trim();
    }
}
