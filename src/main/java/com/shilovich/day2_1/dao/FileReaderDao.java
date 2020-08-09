package com.shilovich.day2_1.dao;

import com.shilovich.day2_1.dao.exception.DaoException;

public interface FileReaderDao {
    String findAppliance(String parameter) throws DaoException;
}