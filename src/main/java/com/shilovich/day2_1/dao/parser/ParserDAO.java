package com.shilovich.day2_1.dao.parser;

import com.shilovich.day2_1.dao.exception.DaoException;
import com.shilovich.day2_1.entity.Appliance;

import java.util.List;

public interface ParserDAO {
    List<Appliance> parse(List<String> list) throws DaoException;
}