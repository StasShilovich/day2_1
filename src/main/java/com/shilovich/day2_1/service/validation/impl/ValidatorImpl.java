package com.shilovich.day2_1.service.validation.impl;

import com.shilovich.day2_1.entity.criteria.Criteria;
import com.shilovich.day2_1.service.validation.Validator;

import java.util.Map;

import static com.shilovich.day2_1.entity.criteria.SearchCriteria.Oven.*;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.TabletPC.DISPLAY_INCHES;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.TabletPC.MEMORY_ROM;

public class ValidatorImpl implements Validator {

    public static final int POWER_CONSUMPTION_MIN = 10;
    public static final int POWER_CONSUMPTION_MAX = 3000;
    public static final int WEIGHT_MIN = 5;
    public static final int WEIGHT_MAX = 50;
    public static final int CAPACITY_MIN = 10;
    public static final int CAPACITY_MAX = 50;
    public static final int DEPTH_MIN = 20;
    public static final int DEPTH_MAX = 100;
    public static final long MEMORY_ROM_MIN = 2000L;
    public static final long MEMORY_ROM_MAX = 128000L;
    public static final int DISPLAY_INCHES_MIN = 5;
    public static final int DISPLAY_INCHES_MAX = 80;
    public static final double HEIGHT_MIN = 10;
    public static final double HEIGHT_MAX = 500;
    public static final double WIDTH_MIN = 10;
    public static final double WIDTH_MAX = 500;


    @Override
    public boolean criteriaValidator(Criteria criteria) {
        boolean result = true;
        for (Map.Entry<String, Object> entry : criteria.getCriteria().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key.equals(POWER_CONSUMPTION.toString()) && ((int) value < POWER_CONSUMPTION_MIN || (int) value > POWER_CONSUMPTION_MAX)) {
                result = false;
            } else if (key.equals(WEIGHT.toString()) && ((int) value < WEIGHT_MIN || (int) value > WEIGHT_MAX)) {
                result = false;
            } else if (key.equals(CAPACITY.toString()) && ((int) value < CAPACITY_MIN || (int) value > CAPACITY_MAX)) {
                result = false;
            } else if (key.equals(DEPTH.toString()) && ((int) value < DEPTH_MIN || (int) value > DEPTH_MAX)) {
                result = false;
            } else if (key.equals(MEMORY_ROM.toString()) && ((long) value < MEMORY_ROM_MIN || (long) value > MEMORY_ROM_MAX)) {
                result = false;
            } else if (key.equals(DISPLAY_INCHES.toString()) && ((int) value < DISPLAY_INCHES_MIN || (int) value > DISPLAY_INCHES_MAX)) {
                result = false;
            } else if (key.equals(HEIGHT.toString()) && ((int) value < HEIGHT_MIN || (int) value > HEIGHT_MAX)) {
                result = false;
            } else if (key.equals(WIDTH.toString()) && ((int) value < WIDTH_MIN || (int) value > WIDTH_MAX)) {
                result = false;
            }
        }
        return result;
    }
}