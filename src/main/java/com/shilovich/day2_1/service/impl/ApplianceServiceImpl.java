package com.shilovich.day2_1.service.impl;

import com.shilovich.day2_1.dao.ApplianceDAO;
import com.shilovich.day2_1.dao.exception.DaoException;
import com.shilovich.day2_1.dao.factory.DAOFactory;
import com.shilovich.day2_1.entity.Appliance;
import com.shilovich.day2_1.entity.criteria.Criteria;
import com.shilovich.day2_1.entity.criteria.SearchCriteria;
import com.shilovich.day2_1.entity.impl.*;
import com.shilovich.day2_1.service.ApplianceService;
import com.shilovich.day2_1.service.factory.ServiceFactory;
import com.shilovich.day2_1.service.exception.ServiceException;
import com.shilovich.day2_1.service.validation.Validator;

import java.util.List;
import java.util.Map;

import static com.shilovich.day2_1.entity.criteria.SearchCriteria.Laptop.*;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.Laptop.BATTERY_CAPACITY;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.Laptop.MEMORY_ROM;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.Oven.*;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.Refrigerator.*;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.Refrigerator.HEIGHT;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.Refrigerator.WEIGHT;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.Refrigerator.WIDTH;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.Speakers.*;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.TabletPC.*;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.VacuumCleaner.*;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.VacuumCleaner.POWER_CONSUMPTION;

public class ApplianceServiceImpl implements ApplianceService {

    @Override
    public Appliance find(Criteria criteria) throws ServiceException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Validator validator = serviceFactory.getValidator();
        if (!validator.criteriaValidator(criteria)) {
            return null;
        }
        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();
        try {
            List<Appliance> appliances = applianceDAO.find(criteria);
            return chooseEqualsAppliance(appliances, criteria);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    private Appliance chooseEqualsAppliance(List<Appliance> appliances, Criteria criteria) {
        String groupSearchName = criteria.getGroupSearchName();
        Map<String, Object> criteriaMap = criteria.getCriteria();
        if (SearchCriteria.Laptop.class.getSimpleName().equals(groupSearchName)) {
            return accordToLaptop(appliances, criteriaMap);
        } else if (SearchCriteria.Oven.class.getSimpleName().equals(groupSearchName)) {
            return accordToOven(appliances, criteriaMap);
        } else if (SearchCriteria.Refrigerator.class.getSimpleName().equals(groupSearchName)) {
            return accordToRefrigerator(appliances, criteriaMap);
        } else if (SearchCriteria.Speakers.class.getSimpleName().equals(groupSearchName)) {
            return accordToSpeakers(appliances, criteriaMap);
        } else if (SearchCriteria.TabletPC.class.getSimpleName().equals(groupSearchName)) {
            return accordToTabletPC(appliances, criteriaMap);
        } else if (SearchCriteria.VacuumCleaner.class.getSimpleName().equals(groupSearchName)) {
            return accordToVacuumCleaner(appliances, criteriaMap);
        } else {
            return null;
        }
    }

    private Appliance accordToVacuumCleaner(List<Appliance> appliances, Map<String, Object> data) {
        for (Appliance appliance : appliances) {
            VacuumCleaner vacuumCleaner = (VacuumCleaner) appliance;
            int count = 0;
            if (data.containsKey(POWER_CONSUMPTION.toString())
                    && vacuumCleaner.getPowerConsumption() == (int) data.get(POWER_CONSUMPTION.toString())) {
                count++;
            }
            if (data.containsKey(FILTER_TYPE.toString())
                    && vacuumCleaner.getFilterType().equalsIgnoreCase((String) data.get(FILTER_TYPE.toString()))) {
                count++;
            }
            if (data.containsKey(BAG_TYPE.toString())
                    && vacuumCleaner.getBagType().equalsIgnoreCase((String) data.get(BAG_TYPE.toString()))) {
                count++;
            }
            if (data.containsKey(WAND_TYPE.toString())
                    && vacuumCleaner.getWandType().equalsIgnoreCase((String) data.get(WAND_TYPE.toString()))) {
                count++;
            }
            if (data.containsKey(MOTOR_SPEED_REGULATION.toString())
                    && vacuumCleaner.getMotorSpeedRegulation() == (int) data.get(MOTOR_SPEED_REGULATION.toString())) {
                count++;
            }
            if (data.containsKey(CLEANING_WIDTH.toString())
                    && vacuumCleaner.getCleaningWidth() == (int) data.get(CLEANING_WIDTH.toString())) {
                count++;
            }
            if (count == data.size()) {
                return vacuumCleaner;
            }
        }
        return null;
    }

    private Appliance accordToTabletPC(List<Appliance> appliances, Map<String, Object> data) {
        for (Appliance appliance : appliances) {
            TabletPC tabletPC = (TabletPC) appliance;
            int count = 0;
            if (data.containsKey(DISPLAY_INCHES.toString())
                    && tabletPC.getDisplayInches() == (int) data.get(DISPLAY_INCHES.toString())) {
                count++;
            }
            if (data.containsKey(MEMORY_ROM.toString())
                    && tabletPC.getMemoryRom() == (long) data.get(MEMORY_ROM.toString())) {
                count++;
            }
            if (data.containsKey(FLASH_MEMORY_CAPACITY.toString())
                    && tabletPC.getFlashMemoryCapacity() == (int) data.get(FLASH_MEMORY_CAPACITY.toString())) {
                count++;
            }
            if (data.containsKey(BATTERY_CAPACITY.toString())
                    && tabletPC.getBatteryCapacity() == (double) data.get(BATTERY_CAPACITY.toString())) {
                count++;
            }
            if (data.containsKey(COLOR.toString())
                    && tabletPC.getColor().equalsIgnoreCase((String) data.get(COLOR.toString()))) {
                count++;
            }
            if (count == data.size()) {
                return tabletPC;
            }
        }
        return null;
    }

    private Appliance accordToSpeakers(List<Appliance> appliances, Map<String, Object> data) {
        for (Appliance appliance : appliances) {
            Speakers speakers = (Speakers) appliance;
            int count = 0;
            if (data.containsKey(POWER_CONSUMPTION.toString())
                    && speakers.getPowerConsumption() == (int) data.get(POWER_CONSUMPTION.toString())) {
                count++;
            }
            if (data.containsKey(NUMBER_OF_SPEAKERS.toString())
                    && speakers.getNumberOfSpeakers() == (int) data.get(NUMBER_OF_SPEAKERS.toString())) {
                count++;
            }
            if (data.containsKey(FREQUENCY_RANGE.toString())
                    && speakers.getFrequencyRange().equalsIgnoreCase((String) data.get(FREQUENCY_RANGE.toString()))) {
                count++;
            }
            if (data.containsKey(CORD_LENGTH.toString())
                    && speakers.getCordLength() == (int) data.get(CORD_LENGTH.toString())) {
                count++;
            }

            if (count == data.size()) {
                return speakers;
            }
        }
        return null;
    }

    private Appliance accordToRefrigerator(List<Appliance> appliances, Map<String, Object> data) {
        for (Appliance appliance : appliances) {
            Refrigerator refrigerator = (Refrigerator) appliance;
            int count = 0;
            if (data.containsKey(POWER_CONSUMPTION.toString())
                    && refrigerator.getPowerConsumption() == (int) data.get(POWER_CONSUMPTION.toString())) {
                count++;
            }
            if (data.containsKey(WEIGHT.toString())
                    && refrigerator.getWeight() == (int) data.get(WEIGHT.toString())) {
                count++;
            }
            if (data.containsKey(FREEZER_CAPACITY.toString())
                    && refrigerator.getFreezerCapacity() == (int) data.get(FREEZER_CAPACITY.toString())) {
                count++;
            }
            if (data.containsKey(OVERALL_CAPACITY.toString())
                    && refrigerator.getOverallCapacity() == (double) data.get(OVERALL_CAPACITY.toString())) {
                count++;
            }
            if (data.containsKey(HEIGHT.toString())
                    && refrigerator.getHeight() == (double) data.get(HEIGHT.toString())) {
                count++;
            }
            if (data.containsKey(WIDTH.toString())
                    && refrigerator.getWidth() == (double) data.get(WIDTH.toString())) {
                count++;
            }
            if (count == data.size()) {
                return refrigerator;
            }
        }
        return null;
    }

    private Appliance accordToOven(List<Appliance> appliances, Map<String, Object> data) {
        for (Appliance appliance : appliances) {
            Oven oven = (Oven) appliance;
            int count = 0;
            if (data.containsKey(POWER_CONSUMPTION.toString())
                    && oven.getPowerConsumption() == (int) data.get(POWER_CONSUMPTION.toString())) {
                count++;
            }
            if (data.containsKey(WEIGHT.toString())
                    && oven.getWeight() == (int) data.get(WEIGHT.toString())) {
                count++;
            }
            if (data.containsKey(CAPACITY.toString())
                    && oven.getCapacity() == (int) data.get(CAPACITY.toString())) {
                count++;
            }
            if (data.containsKey(DEPTH.toString())
                    && oven.getDepth() == (int) data.get(DEPTH.toString())) {
                count++;
            }
            if (data.containsKey(HEIGHT.toString())
                    && oven.getHeight() == (double) data.get(HEIGHT.toString())) {
                count++;
            }
            if (data.containsKey(WIDTH.toString())
                    && oven.getWidth() == (double) data.get(WIDTH.toString())) {
                count++;
            }
            if (count == data.size()) {
                return oven;
            }
        }
        return null;
    }

    private Appliance accordToLaptop(List<Appliance> appliances, Map<String, Object> data) {
        for (Appliance appliance : appliances) {
            Laptop laptop = (Laptop) appliance;
            int count = 0;
            if (data.containsKey(BATTERY_CAPACITY.toString())
                    && laptop.getBatteryCapacity() == (double) data.get(BATTERY_CAPACITY.toString())) {
                count++;
            }
            if (data.containsKey(OS.toString())
                    && laptop.getOs().equalsIgnoreCase((String) data.get(OS.toString()))) {
                count++;
            }
            if (data.containsKey(MEMORY_ROM.toString())
                    && laptop.getMemoryRom() == (long) data.get(MEMORY_ROM.toString())) {
                count++;
            }
            if (data.containsKey(SYSTEM_MEMORY.toString())
                    && laptop.getSystemMemory() == (int) data.get(SYSTEM_MEMORY.toString())) {
                count++;
            }
            if (data.containsKey(CPU.toString())
                    && laptop.getCpu() == (double) data.get(CPU.toString())) {
                count++;
            }
            if (data.containsKey(DISPLAY_INCHES.toString())
                    && laptop.getDisplayInches() == (int) data.get(DISPLAY_INCHES.toString())) {
                count++;
            }
            if (count == data.size()) {
                return laptop;
            }
        }
        return null;
    }
}