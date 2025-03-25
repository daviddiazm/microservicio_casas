package com.daviddiazm.housing.category.domain.utils.validations;

import com.daviddiazm.housing.category.domain.exceptions.PageMinNumbrePage;
import com.daviddiazm.housing.category.domain.exceptions.PageMinNumbreSize;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PageResultValidatorTest {

    @Test
    void When_PageIsLessThatZero_Throw_PageMinNumberPage () {
        int value = -1;

        assertThrows(PageMinNumbrePage.class, () -> PageResultValidator.validatePage(value));
    }
    @Test
    void When_SizeIsLessThatOne_Throw_SizeMinNumberPage () {
        int value = 0;
        assertThrows(PageMinNumbreSize.class, () -> PageResultValidator.validateSize(value));
    }
}