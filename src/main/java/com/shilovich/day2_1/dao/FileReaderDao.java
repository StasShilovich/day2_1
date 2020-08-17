package com.shilovich.day2_1.dao;

import com.shilovich.day2_1.dao.exception.DaoException;
import java.util.List;

public interface FileReaderDAO {
    List<String> receive(String criteriaName) throws DaoException;
}