package com.shilovich.day2_1.dao.connection.impl;

import com.shilovich.day2_1.dao.connection.ConnectionManager;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ConnectionManagerImpl implements ConnectionManager {
    private static final String BUNDLE_NAME = "file";
    public static final String FILE_PATH = "file.path";

    @Override
    public String getProperty(String key) {
        ResourceBundle resourceBundle = PropertyResourceBundle.getBundle(BUNDLE_NAME);
        return resourceBundle.getString(key);
    }
}