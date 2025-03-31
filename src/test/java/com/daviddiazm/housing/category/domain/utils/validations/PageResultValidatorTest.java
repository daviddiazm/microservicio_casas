package com.daviddiazm.housing.category.domain.utils.validations;

import com.daviddiazm.housing.category.domain.exceptions.PageMinNumbrePageException;
import com.daviddiazm.housing.category.domain.exceptions.PageMinNumbreSizeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PageResultValidatorTest {

    @Test
    void When_PageIsLessThatZero_Throw_PageMinNumberPage () {
        int value = -1;

        assertThrows(PageMinNumbrePageException.class, () -> PageResultValidator.validatePage(value));
    }
    @Test
    void When_SizeIsLessThatOne_Throw_SizeMinNumberPage () {
        int value = 0;
        assertThrows(PageMinNumbreSizeException.class, () -> PageResultValidator.validateSize(value));
    }
}