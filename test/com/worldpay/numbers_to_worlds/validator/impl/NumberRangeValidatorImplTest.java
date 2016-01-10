package com.worldpay.numbers_to_worlds.validator.impl;

import com.worldpay.numbers_to_words.validator.impl.NumberRangeValidatorImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NumberRangeValidatorImplTest {

    private NumberRangeValidatorImpl numberRangeValidator;

    @Before
    public void setUp() {
        numberRangeValidator = new NumberRangeValidatorImpl();
    }

    @Test
    public void shouldReturnFalseIfNumberIsLowerThanLimits() {
        boolean actualResult = numberRangeValidator.validate(-6);

        assertFalse(actualResult);
    }

    @Test
    public void shouldReturnFalseIfNumberIsGreaterThanLimits() {
        boolean actualResult = numberRangeValidator.validate(1000000000);

        assertFalse(actualResult);
    }

    @Test
    public void shouldReturnTrueIfNumberIsBetweenLimits() {
        boolean actualResult = numberRangeValidator.validate(200);

        assertTrue(actualResult);
    }
}
