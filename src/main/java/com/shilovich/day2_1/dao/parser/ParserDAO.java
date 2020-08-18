package com.shilovich.day2_1.dao.parser;

import com.shilovich.day2_1.dao.exception.DaoException;
import com.shilovich.day2_1.entity.Appliance;
import com.shilovich.day2_1.entity.criteria.Criteria;

import java.util.List;
import java.util.Map;

public interface ParserDAO {
    Map<String, String> parseString(String string) throws DaoException;

    Appliance parseList(Map<String, String> stringMap) throws DaoException;
}