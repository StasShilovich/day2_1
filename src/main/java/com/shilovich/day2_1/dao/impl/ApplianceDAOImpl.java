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
import java.util.Map;

public class ApplianceDAOImpl implements ApplianceDAO {

    @Override
    public Appliance find(Criteria criteria) throws DaoException {
        FileReaderFactory readerFactory = FileReaderFactory.getInstance();
        FileReaderDAO readerDAO = readerFactory.getFileReaderDAO();
        List<String> applianceListString = readerDAO.receive(criteria.getGroupSearchName());

        ParserDAOFactory parserFactory = ParserDAOFactory.getInstance();
        ParserDAO parserDAO = parserFactory.getParserDAO();
        parserDAO.parseList(criteria.getCriteria())
        Map<String, Object> criteriaMap = criteria.getCriteria();
        for (String string : applianceListString) {

            Appliance appliance1 = parserDAO.parseString(string);
//            int criteriaMapSize = criteriaMap.size();
//            int counter = 0;
//
//            for (Map.Entry<String, String> entry : stringMap.entrySet()) {
//                String key = entry.getKey();
//                String value = entry.getValue();
//                if (criteriaMap.containsKey(key) && criteriaMap.get(key).equals(value)) {
//                    counter++;
//                }
//            }
//
//            if (criteriaMapSize == counter) {
//                Appliance appliance = parserDAO.parseList(stringMap);
//                System.out.println(appliance);
//                return appliance;
//            }

        }
        return new Appliance();
    }

    // you may add your own code here

}


//you may add your own new classes