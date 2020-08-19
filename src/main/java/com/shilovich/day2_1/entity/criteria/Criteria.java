package com.shilovich.day2_1.entity.criteria;

import com.shilovich.day2_1.dao.exception.DaoException;
import com.shilovich.day2_1.entity.Appliance;

import java.util.HashMap;
import java.util.Map;

public class Criteria {

    private String groupSearchName;
    private Map<String, Object> criteria = new HashMap<String, Object>();

    public Criteria(String groupSearchName) {
        this.groupSearchName = groupSearchName;
    }

    public String getGroupSearchName() {
        return groupSearchName;
    }

    public void add(String searchCriteria, Object value) {
        criteria.put(searchCriteria, value);
    }

    public Map<String, Object> getCriteria() {
        return criteria;
    }

    public boolean isMatches(Appliance appliance) throws DaoException {
        switch (appliance.getClass().getSimpleName()) {
            case "Laptop":
                return isMatchesLaptop(appliance);
            case "Oven":
                return isMatchesOven(appliance);
            case "Refrigerator":
                return isMatchesRefrigerator(appliance);
            case "Speakers":
                return isMatchesSpeakers(appliance);
            case "TabletPC":
                return isMatchesTablePC(appliance);
            case "VacuumCleaner":
                return isMatchesVacuumCleaner(appliance);
            default:
                throw new DaoException("Criteria do not match!");
        }
    }

    private boolean isMatchesLaptop(Appliance appliance) {
        boolean result=false;
        for (Map.Entry<String, Object> entry : criteria.entrySet()) {
            
        }
        return false;
    }

    private boolean isMatchesOven(Appliance appliance) {
        return false;
    }

    private boolean isMatchesRefrigerator(Appliance appliance) {
        return false;
    }

    private boolean isMatchesSpeakers(Appliance appliance) {
        return false;
    }

    private boolean isMatchesVacuumCleaner(Appliance appliance) {
        return false;
    }

    private boolean isMatchesTablePC(Appliance appliance) {
        return false;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Criteria{");
        sb.append("groupSearchName='").append(groupSearchName).append('\'');
        sb.append(", criteria=").append(criteria);
        sb.append('}');
        return sb.toString();
    }
}