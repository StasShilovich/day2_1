package com.shilovich.day2_1.dao.connection;

import com.shilovich.day2_1.dao.exception.DaoException;

public interface ConnectionManager {
    String getProperty(String key) throws DaoException;
}