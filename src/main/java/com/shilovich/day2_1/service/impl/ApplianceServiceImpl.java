package com.shilovich.day2_1.service.impl;


import com.shilovich.day2_1.dao.ApplianceDAO;
import com.shilovich.day2_1.dao.exception.DaoException;
import com.shilovich.day2_1.dao.factory.DAOFactory;
import com.shilovich.day2_1.entity.Appliance;
import com.shilovich.day2_1.entity.criteria.Criteria;
import com.shilovich.day2_1.service.ApplianceService;
import com.shilovich.day2_1.service.validation.Validator;

public class ApplianceServiceImpl implements ApplianceService {

	@Override
	public Appliance find(Criteria criteria) {
		if (!Validator.criteriaValidator(criteria)) {
			return null;
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();

		Appliance appliance = null;
		try {
			appliance = applianceDAO.find(criteria);
		} catch (DaoException e) {
			e.printStackTrace();
		}

		// you may add your own code here
		
		return appliance;
	}

}

//you may add your own new classes
