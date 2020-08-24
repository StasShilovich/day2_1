package com.shilovich.day2_1.service;


import com.shilovich.day2_1.service.impl.ApplianceServiceImpl;
import com.shilovich.day2_1.service.validation.Validator;
import com.shilovich.day2_1.service.validation.impl.ValidatorImpl;

public final class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private final ApplianceService applianceService = new ApplianceServiceImpl();

	private final Validator validator=new ValidatorImpl();
	
	private ServiceFactory() {}

	public ApplianceService getApplianceService() {
		return applianceService;
	}

	public Validator getValidator() {
		return validator;
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

}
