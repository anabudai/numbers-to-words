package com.worldpay.numbers_to_words.validator.impl;

import com.worldpay.numbers_to_words.validator.NumberRangeValidator;
import static com.worldpay.numbers_to_words.constant.NumberToWordConstants.NUMBER_LOWER_LIMIT;
import static com.worldpay.numbers_to_words.constant.NumberToWordConstants.NUMBER_UPPER_LIMIT;

public class NumberRangeValidatorImpl implements NumberRangeValidator {

    @Override
    public boolean validate(int number) {
        return number >= NUMBER_LOWER_LIMIT && number <= NUMBER_UPPER_LIMIT;
    }
}
