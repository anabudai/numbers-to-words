package com.worldpay.numbers_to_words.impl;

import com.worldpay.numbers_to_words.NumberToWordTransformer;
import com.worldpay.numbers_to_words.util.StringUtils;

import java.util.List;

import static com.worldpay.numbers_to_words.constant.NumberToWordConstants.*;


public class NumberToWordTransformerImpl implements NumberToWordTransformer {

    @Override
    public String transform(int number) {
        StringBuilder numberAsWord = new StringBuilder();
        List<String> numberSplitIntoGroups = StringUtils.splitIntoChunksOfSizeStartingRight(String.valueOf(number), 3);
        for(int i = 0; i < numberSplitIntoGroups.size(); ++i) {
            int group = Integer.valueOf(numberSplitIntoGroups.get(i));
            String word = transformNumberGroupToWord(group, i > 0);
            numberAsWord.append(word).append(STRING_SPACE);
            numberAsWord.append(NUMERIC_GROUPS.get(numberSplitIntoGroups.size() - i - 1)).append(STRING_SPACE);
        }
        return numberAsWord.toString().trim();
    }

    private String transformNumberGroupToWord(int number, boolean hasFurtherGroups) {
        StringBuilder numberAsWord = new StringBuilder();
        int numberOfHundredsFromNumber = number / 100;
        int intermediaryNumber = number % 100;
        if(numberOfHundredsFromNumber > 0) {
            numberAsWord.append(NUMBERS_FROM_0_TO_20.get(numberOfHundredsFromNumber));
            numberAsWord.append(STRING_SPACE).append(HUNDRED);
            if(intermediaryNumber > 0) {
                numberAsWord.append(STRING_SPACE).append(AND).append(STRING_SPACE);
                numberAsWord.append(transformTwoDigitNumberToWord(intermediaryNumber));
            }
        } else {
            if(hasFurtherGroups) {
                numberAsWord.append(STRING_SPACE).append(AND).append(STRING_SPACE);
            }
            numberAsWord.append(transformTwoDigitNumberToWord(number));
        }

        return numberAsWord.toString().trim();
    }

    private String transformTwoDigitNumberToWord(int number) {
        StringBuilder numberAsWord = new StringBuilder();
        if(number < 20) {
            numberAsWord.append(NUMBERS_FROM_0_TO_20.get(number));
        } else {
            int numberOfDecimals = number / 10;
            int numberOfUnits  = number % 10;
            numberAsWord.append(DECIMALS.get(numberOfDecimals - 2)).append( STRING_SPACE)
                    .append(NUMBERS_FROM_0_TO_20.get(numberOfUnits));
        }
        return  numberAsWord.toString().trim();
    }
}
