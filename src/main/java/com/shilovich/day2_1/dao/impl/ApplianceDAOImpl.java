package com.shilovich.day2_1.dao.impl;


import com.shilovich.day2_1.dao.ApplianceDAO;
import com.shilovich.day2_1.dao.FileReaderDAO;
import com.shilovich.day2_1.dao.exception.DaoException;
import com.shilovich.day2_1.dao.factory.FileReaderFactory;
import com.shilovich.day2_1.dao.factory.ParserDAOFactory;
import com.shilovich.day2_1.dao.parser.ParserDAO;
import com.shilovich.day2_1.entity.Appliance;
import com.shilovich.day2_1.entity.criteria.Criteria;

import java.util.List;

public class ApplianceDAOImpl implements ApplianceDAO {

    @Override
    public Appliance find(Criteria criteria) throws DaoException {
        FileReaderFactory readerFactory = FileReaderFactory.getInstance();
        FileReaderDAO readerDAO = readerFactory.getFileReaderDAO();
        List<String> applianceListString = readerDAO.receive(criteria.getGroupSearchName());

        ParserDAOFactory parserFactory = ParserDAOFactory.getInstance();
        ParserDAO parserDAO = parserFactory.getParserDAO();
        List<Appliance> parse = parserDAO.parse(applianceListString);
        for (Appliance appliance : parse) {
            System.out.println(appliance);
        }

        return null;
    }

    // you may add your own code here

}


//you may add your own new classes