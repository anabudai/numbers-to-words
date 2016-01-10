package com.worldpay.numbers_to_words.impl;

import com.worldpay.numbers_to_words.NumberToWordTransformer;
import com.worldpay.numbers_to_words.exception.NumberToWordException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.worldpay.numbers_to_words.constant.NumberToWordConstants.*;


public class NumberToWordTransformerImpl implements NumberToWordTransformer {

    @Override
    public String transform(int number) {
        StringBuilder numberAsWord = new StringBuilder();
        List<String> groupsOfThreeCypherAsStrings = parseNumberIntoThreeCypherGroupsFromTheEnd(number);
        List<Integer> groupsOfThreeCypher = transformStringsIntoNumbers(groupsOfThreeCypherAsStrings);
        for(int i = groupsOfThreeCypherAsStrings.size() - 1; i >= 0; --i) {
            int groupOfThreeCypher = Integer.valueOf(reverse(groupsOfThreeCypherAsStrings.get(i)));
            String parse = transformNumberGroupToWord(groupOfThreeCypher, i < groupsOfThreeCypherAsStrings.size()-1);
            numberAsWord.append(parse).append(STRING_SPACE);
            if(i - 1 >= 0) {
                numberAsWord.append(NUMERIC_GROUPS.get(i - 1)).append(STRING_SPACE);
            }
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

    private List<String> parseNumberIntoThreeCypherGroupsFromTheEnd(int number) {
        String numberAsString = String.valueOf(number);
        String reversedNumber = reverse(numberAsString);

        String[] groupsOfThree = reversedNumber.toString().split("(?<=\\G...)");
        return Arrays.asList(groupsOfThree);
    }

    private List<Integer> transformStringsIntoNumbers(List<String> numbersAsString) {
        List<Integer> numbers = new ArrayList<Integer>();
        for(String numberAsString : numbersAsString) {
            numbers.add(Integer.valueOf(numberAsString));
        }
        return numbers;
    }

    private int countZeroValueGroups(List<Integer> numbers) {
        int contor = 0;
        for(int number : numbers) {
            if(number == 0) {
                ++contor;
            }
        }
        return contor;
    }

    private String reverse(String value) {
        StringBuilder reversedNumber = new StringBuilder();
        for(int i = value.length() - 1; i >= 0; --i) {
            reversedNumber.append(value.charAt(i));
        }
        return reversedNumber.toString();
    }

}
