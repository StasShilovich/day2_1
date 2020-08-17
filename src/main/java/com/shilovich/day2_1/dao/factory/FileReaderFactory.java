package com.shilovich.day2_1.dao.factory;

import com.shilovich.day2_1.dao.FileReaderDAO;
import com.shilovich.day2_1.dao.impl.FileReaderDAOImpl;

public final class FileReaderFactory {
    private static final FileReaderFactory instance = new FileReaderFactory();

    private final FileReaderDAO fileReaderDAO = new FileReaderDAOImpl();

    private FileReaderFactory() {
    }

    public FileReaderDAO getFileReaderDAO() {
        return fileReaderDAO;
    }

    public static FileReaderFactory getInstance() {
        return instance;
    }
}