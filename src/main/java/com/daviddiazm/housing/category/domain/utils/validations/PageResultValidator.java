package com.daviddiazm.housing.category.domain.utils.validations;

import com.daviddiazm.housing.category.domain.exceptions.PageMinNumbrePageException;
import com.daviddiazm.housing.category.domain.exceptions.PageMinNumbreSizeException;
import com.daviddiazm.housing.category.domain.utils.constants.DomainConstants;

public class PageResultValidator {
    public static void validatePage(int page) throws PageMinNumbrePageException {
        if(page < DomainConstants.MIN_VALUE_PAGE) {
            throw new PageMinNumbrePageException(DomainConstants.PAGE_MIN_VALUE_PAGE);
        }
    }
    public static void validateSize(int size){
        if(size < DomainConstants.MIN_VALUE_SIZE) {
            throw new PageMinNumbreSizeException(DomainConstants.PAGE_MIN_VALUE_SIZE);
        }
    }
}
