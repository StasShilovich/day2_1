package com.shilovich.day2_1.dao;

import com.shilovich.day2_1.dao.exception.DaoException;
import com.shilovich.day2_1.entity.Appliance;
import com.shilovich.day2_1.entity.criteria.Criteria;

public interface ApplianceDAO {
    Appliance find(Criteria criteria) throws DaoException;
}
