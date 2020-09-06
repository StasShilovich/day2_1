package com.shilovich.day2_1.dao.parser.impl;

import com.shilovich.day2_1.dao.exception.DaoException;
import com.shilovich.day2_1.dao.parser.ParserDAO;
import com.shilovich.day2_1.entity.Appliance;
import com.shilovich.day2_1.entity.criteria.SearchCriteria;
import com.shilovich.day2_1.entity.impl.*;

import java.util.HashMap;
import java.util.Map;

public class ParserDAOImpl implements ParserDAO {
    private static final String COLON = ":";
    private static final String COMMA = ",";
    private static final String EQUAL = "=";
    private static final String APPLIANCE_NAME = "APPLIANCE_NAME";
    private static final int FIRST_ELEMENT_INDEX = 0;


    @Override
    public Appliance parseString(String string) throws DaoException {
        String[] split = string.split(COLON);
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put(APPLIANCE_NAME, split[FIRST_ELEMENT_INDEX].trim());
        String[] data = split[split.length - 1].split(COMMA);
        for (int i = 0; i < data.length; i++) {
            String[] object = data[i].split(EQUAL);
            stringMap.put(object[FIRST_ELEMENT_INDEX].trim(), object[object.length - 1].trim());
        }
        return parseList(stringMap);
    }

    private Appliance parseList(Map<String, String> stringMap) throws DaoException {
        String s = stringMap.get(APPLIANCE_NAME);
        if (SearchCriteria.Laptop.class.getSimpleName().equals(s)) {
            return new Laptop().createFromMap(stringMap);
        } else if (SearchCriteria.Oven.class.getSimpleName().equals(s)) {
            return new Oven().createFromMap(stringMap);
        } else if (SearchCriteria.Refrigerator.class.getSimpleName().equals(s)) {
            return new Refrigerator().createFromMap(stringMap);
        } else if (SearchCriteria.Speakers.class.getSimpleName().equals(s)) {
            return new Speakers().createFromMap(stringMap);
        } else if (SearchCriteria.TabletPC.class.getSimpleName().equals(s)) {
            return new TabletPC().createFromMap(stringMap);
        } else if (SearchCriteria.VacuumCleaner.class.getSimpleName().equals(s)) {
            return new VacuumCleaner().createFromMap(stringMap);
        }
        throw new DaoException("Can not create appliance with name: " + stringMap.get(APPLIANCE_NAME));
    }
}