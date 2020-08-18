package com.shilovich.day2_1.dao.parser.impl;

import com.shilovich.day2_1.dao.exception.DaoException;
import com.shilovich.day2_1.dao.parser.ParserDAO;
import com.shilovich.day2_1.entity.Appliance;
import com.shilovich.day2_1.entity.Oven;
import com.shilovich.day2_1.entity.TabletPC;
import com.shilovich.day2_1.entity.VacuumCleaner;
import com.shilovich.day2_1.entity.criteria.Criteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.shilovich.day2_1.entity.criteria.SearchCriteria.Oven.*;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.TabletPC.*;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.VacuumCleaner.*;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.VacuumCleaner.POWER_CONSUMPTION;

public class ParserDAOImpl implements ParserDAO {
    private static final String COLON = ":";
    private static final String COMMA = ",";
    private static final String EQUAL = "=";
    private static final int FIRST_ELEMENT_INDEX = 0;

    @Override
    public List<Appliance> parse(List<String> list) throws DaoException {
        List<Appliance> applianceList = new ArrayList<>();
        for (String string : list) {
            Appliance appliance = parseString(string);
            applianceList.add(appliance);
        }
        return applianceList;
    }

    private Appliance parseString(String string) throws DaoException {
        // TODO: 18.08.2020 try catch add
        String[] split = string.split(COLON);
        Criteria criteria = new Criteria(split[FIRST_ELEMENT_INDEX].trim());
        String[] data = split[split.length - 1].split(COMMA);
        for (int i = 0; i < data.length; i++) {
            String[] object = data[i].split(EQUAL);
            criteria.add(object[FIRST_ELEMENT_INDEX].trim(), object[object.length - 1]);
        }
        return parseToAppliance(criteria);
    }

    private Appliance parseToAppliance(Criteria criteria) throws DaoException {
        switch (criteria.getGroupSearchName()) {
            case "Laptop":
                return parseToLaptop(criteria.getCriteria());
            case "Oven":
                return parseToOven(criteria.getCriteria());
            case "Refrigerator":
                return parseToRefrigerator(criteria.getCriteria());
            case "Speakers":
                return parseToSpeakers(criteria.getCriteria());
            case "TablePC":
                return parseToTablePC(criteria.getCriteria());
            case "VacuumCleaner":
                return parseToVacuumCleaner(criteria.getCriteria());
            default:
                throw new DaoException("Not find appliance with name:" + criteria.getGroupSearchName());
        }
    }

    private Appliance parseToVacuumCleaner(Map<String, Object> criteria) {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        vacuumCleaner.setPowerConsumption(Integer.parseInt((String) criteria.get(POWER_CONSUMPTION.toString())));
        vacuumCleaner.setFilterType((String) criteria.get(FILTER_TYPE.toString()));
        vacuumCleaner.setBagType((String) criteria.get(BAG_TYPE.toString()));
        vacuumCleaner.setWandType((String) criteria.get(WAND_TYPE.toString()));
        vacuumCleaner.setMotorSpeedRegulation(Integer.parseInt((String) criteria.get(MOTOR_SPEED_REGULATION.toString())));
        vacuumCleaner.setCleaningWidth(Integer.parseInt((String) criteria.get(CLEANING_WIDTH.toString())));
        return vacuumCleaner;
    }

    private Appliance parseToTablePC(Map<String, Object> criteria) {
        TabletPC tabletPC = new TabletPC();
        tabletPC.setBatteryCapacity(Double.parseDouble((String) criteria.get(BATTERY_CAPACITY)));
        tabletPC.setDisplayInches(Integer.parseInt((String) criteria.get(DISPLAY_INCHES)));
        tabletPC.setMemoryRom(Long.parseLong((String) criteria.get(MEMORY_ROM)));
        tabletPC.setFlashMemoryCapacity(Integer.parseInt((String) criteria.get(FLASH_MEMORY_CAPACITY)));
        tabletPC.setColor((String) criteria.get(COLOR));
        return tabletPC;
    }

    private Appliance parseToSpeakers(Map<String, Object> criteria) {
        return null;
    }

    private Appliance parseToRefrigerator(Map<String, Object> criteria) {
        return null;
    }

    private Appliance parseToOven(Map<String, Object> criteria) {
        Oven oven = new Oven();
        oven.setPowerConsumption(Integer.parseInt((String) criteria.get(POWER_CONSUMPTION.toString())));
        oven.setWeight(Integer.parseInt((String) criteria.get(WEIGHT.toString())));
        oven.setCapacity(Integer.parseInt((String) criteria.get(CAPACITY.toString())));
        oven.setDepth(Integer.parseInt((String) criteria.get(DEPTH.toString())));
        oven.setHeight(Double.parseDouble((String) criteria.get(HEIGHT)));
        oven.setWidth(Double.parseDouble((String) criteria.get(WIDTH)));
        return oven;
    }

    private Appliance parseToLaptop(Map<String, Object> criteria) {
        return null;
    }
}