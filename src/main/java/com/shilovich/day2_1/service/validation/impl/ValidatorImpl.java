package com.shilovich.day2_1.service.validation.impl;


import com.shilovich.day2_1.entity.criteria.Criteria;
import com.shilovich.day2_1.entity.criteria.SearchCriteria;
import com.shilovich.day2_1.service.validation.Validator;

import java.util.Map;

public class ValidatorImpl implements Validator {

    @Override
    public boolean criteriaValidator(Criteria criteria) {
        return validateGroupName(criteria.getGroupSearchName()) && validateCriteriaMap(criteria.getCriteria());
    }

    private boolean validateCriteriaMap(Map<String, Object> criteria) {
        return true;
    }

    private boolean validateGroupName(String groupSearchName) {
        return true;
    }

}

//you may add your own new classes