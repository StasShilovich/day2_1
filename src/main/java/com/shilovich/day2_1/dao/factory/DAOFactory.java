package com.shilovich.day2_1.dao.factory;

import com.shilovich.day2_1.dao.ApplianceDAO;
import com.shilovich.day2_1.dao.impl.ApplianceDAOImpl;

public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	private final ApplianceDAO applianceDAO = new ApplianceDAOImpl();
	
	private DAOFactory() {}

	public ApplianceDAO getApplianceDAO() {
		return applianceDAO;
	}

	public static DAOFactory getInstance() {
		return instance;
	}
}