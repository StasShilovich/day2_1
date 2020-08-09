package com.shilovich.day2_1.dao.impl;

import com.shilovich.day2_1.dao.FileReaderDao;
import com.shilovich.day2_1.dao.exception.DaoException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class FileReaderDaoImpl implements FileReaderDao {
    private static final String PATH = "src\\main\\resources\\appliances_db.txt";

    @Override
    public String findAppliance(String parameter) throws DaoException{
        String result = "";
        try {
            Path path = Paths.get(PATH);
            List<String> list = Files.lines(path).
                    filter().
                    collect(Collectors.toList());
            result = list.toString();
        } catch (IOException e) {
            throw new DaoException("File read fail");
        }
        return result;
    }
}
