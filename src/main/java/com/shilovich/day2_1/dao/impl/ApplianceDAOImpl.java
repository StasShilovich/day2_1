package com.shilovich.day2_1.dao.impl;

import com.shilovich.day2_1.dao.ApplianceDAO;
import com.shilovich.day2_1.dao.FileReaderDAO;
import com.shilovich.day2_1.dao.exception.DaoException;
import com.shilovich.day2_1.dao.factory.DAOFactory;
import com.shilovich.day2_1.dao.parser.ParserDAO;
import com.shilovich.day2_1.entity.Appliance;
import com.shilovich.day2_1.entity.criteria.Criteria;

import java.util.ArrayList;
import java.util.List;

public class ApplianceDAOImpl implements ApplianceDAO {

    @Override
    public List<Appliance> find(Criteria criteria) throws DaoException {
        DAOFactory factory = DAOFactory.getInstance();
        FileReaderDAO readerDAO = factory.getReaderDAO();
        List<String> applianceListString = readerDAO.receive(criteria.getGroupSearchName());
        ParserDAO parserDAO = factory.getParserDAO();
        List<Appliance> result = new ArrayList<>();
        for (String string : applianceListString) {
            Appliance appliance = parserDAO.parseString(string);
            result.add(appliance);
        }
        return result;
    }
}