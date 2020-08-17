package com.shilovich.day2_1.service;


import com.shilovich.day2_1.entity.Appliance;
import com.shilovich.day2_1.entity.criteria.Criteria;

public interface ApplianceService {
	
	Appliance find(Criteria criteria);
	
}
