package com.shilovich.day2_1.dao.factory;

import com.shilovich.day2_1.dao.parser.ParserDAO;
import com.shilovich.day2_1.dao.parser.impl.ParserDAOImpl;

public final class ParserDAOFactory {
    private static final ParserDAOFactory instance = new ParserDAOFactory();

    private final ParserDAO parserDAO = new ParserDAOImpl();

    private ParserDAOFactory() {
    }

    public ParserDAO getParserDAO() {
        return parserDAO;
    }

    public static ParserDAOFactory getInstance() {
        return instance;
    }
}