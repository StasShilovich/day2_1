package com.shilovich.day2_1.dao.factory;

import com.shilovich.day2_1.dao.ApplianceDAO;
import com.shilovich.day2_1.dao.FileReaderDAO;
import com.shilovich.day2_1.dao.connection.ConnectionManager;
import com.shilovich.day2_1.dao.connection.impl.ConnectionManagerImpl;
import com.shilovich.day2_1.dao.impl.ApplianceDAOImpl;
import com.shilovich.day2_1.dao.impl.FileReaderDAOImpl;
import com.shilovich.day2_1.dao.parser.ParserDAO;
import com.shilovich.day2_1.dao.parser.impl.ParserDAOImpl;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final ApplianceDAO applianceDAO = new ApplianceDAOImpl();

    private final ParserDAO parserDAO = new ParserDAOImpl();

    private final FileReaderDAO readerDAO = new FileReaderDAOImpl();

    private final ConnectionManager connectionManager = new ConnectionManagerImpl();

    private DAOFactory() {
    }

    public ApplianceDAO getApplianceDAO() {
        return applianceDAO;
    }

    public ParserDAO getParserDAO() {
        return parserDAO;
    }

    public FileReaderDAO getReaderDAO() {
        return readerDAO;
    }

    public ConnectionManager getConnectionManager() {
        return connectionManager;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}