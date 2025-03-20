package com.daviddiazm.housing.category.domain.utils.validations;

import com.daviddiazm.housing.category.domain.exceptions.PageMinNumbrePage;
import com.daviddiazm.housing.category.domain.exceptions.PageMinNumbreSize;
import com.daviddiazm.housing.category.domain.utils.constants.DomainConstants;

public class PageResultValidator {
    public static void validatePage(int page) throws PageMinNumbrePage {
        if(page < DomainConstants.MIN_VALUE_PAGE) {
            throw new PageMinNumbrePage(DomainConstants.PAGE_MIN_VALUE_PAGE);
        }
    }
    public static void validateSize(int size){
        if(size < DomainConstants.MIN_VALUE_SIZE) {
            throw new PageMinNumbreSize(DomainConstants.PAGE_MIN_VALUE_SIZE);
        }
    }
}
