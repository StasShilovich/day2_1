package com.shilovich.day2_1.dao.impl;

import com.shilovich.day2_1.dao.connection.ConnectionManager;
import com.shilovich.day2_1.dao.FileReaderDAO;
import com.shilovich.day2_1.dao.exception.DaoException;
import com.shilovich.day2_1.dao.factory.ConnectionManagerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.shilovich.day2_1.dao.connection.impl.ConnectionManagerImpl.FILE_PATH;

public class FileReaderDAOImpl implements FileReaderDAO {

    @Override
    public List<String> receive(String criteriaName) throws DaoException {
        ConnectionManagerFactory factory = ConnectionManagerFactory.getInstance();
        ConnectionManager manager = factory.getConnectionManager();
        String filePath = manager.getProperty(FILE_PATH);

        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            result = lines
                    .filter(line -> line.contains(criteriaName))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new DaoException("File read fail");
        }
        return result;
    }
}