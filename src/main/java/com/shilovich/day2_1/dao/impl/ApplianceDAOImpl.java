package com.shilovich.day2_1.dao.impl;


import com.shilovich.day2_1.dao.ApplianceDAO;
import com.shilovich.day2_1.dao.FileReaderDAO;
import com.shilovich.day2_1.dao.exception.DaoException;
import com.shilovich.day2_1.dao.factory.FileReaderFactory;
import com.shilovich.day2_1.entity.Appliance;
import com.shilovich.day2_1.entity.criteria.Criteria;

import java.util.List;

public class ApplianceDAOImpl implements ApplianceDAO {

	@Override
	public Appliance find(Criteria criteria) throws DaoException {
		FileReaderFactory readerFactory=FileReaderFactory.getInstance();
		FileReaderDAO readerDAO=readerFactory.getFileReaderDAO();
		List<String> applianceList = readerDAO.receive(criteria.getGroupSearchName());



		return null;
	}
	
	// you may add your own code here

}


//you may add your own new classes