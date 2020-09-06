package com.shilovich.day2_1.dao.connection.impl;

import com.shilovich.day2_1.dao.connection.ConnectionManager;
import com.shilovich.day2_1.dao.exception.DaoException;

import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ConnectionManagerImpl implements ConnectionManager {
    private static final String BUNDLE_NAME = "file";
    public static final String FILE_PATH = "file.path";

    @Override
    public String getProperty(String key) throws DaoException {
        try {
            ResourceBundle resourceBundle = PropertyResourceBundle.getBundle(BUNDLE_NAME);
            return resourceBundle.getString(key);
        } catch (MissingResourceException | IllegalArgumentException e) {
            throw new DaoException(e);
        }
    }
}