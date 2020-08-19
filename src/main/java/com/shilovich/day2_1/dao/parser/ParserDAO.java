package com.shilovich.day2_1.dao.parser;

import com.shilovich.day2_1.dao.exception.DaoException;
import com.shilovich.day2_1.entity.Appliance;

public interface ParserDAO {
    Appliance parseString(String string) throws DaoException;
}