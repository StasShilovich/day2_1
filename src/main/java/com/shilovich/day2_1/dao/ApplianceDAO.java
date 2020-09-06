package com.shilovich.day2_1.dao;

import com.shilovich.day2_1.dao.exception.DaoException;
import com.shilovich.day2_1.entity.Appliance;
import com.shilovich.day2_1.entity.criteria.Criteria;

import java.util.List;

public interface ApplianceDAO {
    List<Appliance> find(Criteria criteria) throws DaoException;
}