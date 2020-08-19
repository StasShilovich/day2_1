package com.shilovich.day2_1.dao.parser.impl;

import com.shilovich.day2_1.dao.exception.DaoException;
import com.shilovich.day2_1.dao.parser.ParserDAO;
import com.shilovich.day2_1.entity.*;
import com.shilovich.day2_1.entity.criteria.Criteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: 18.08.2020 refactor static import
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.Laptop.*;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.Laptop.BATTERY_CAPACITY;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.Laptop.MEMORY_ROM;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.Oven.*;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.Oven.HEIGHT;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.Oven.WIDTH;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.Refrigerator.*;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.Refrigerator.WEIGHT;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.Speakers.*;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.TabletPC.*;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.VacuumCleaner.*;
import static com.shilovich.day2_1.entity.criteria.SearchCriteria.VacuumCleaner.POWER_CONSUMPTION;

public class ParserDAOImpl implements ParserDAO {
    private static final String COLON = ":";
    private static final String COMMA = ",";
    private static final String EQUAL = "=";
    private static final String APPLIANCE_NAME = "APPLIANCE_NAME";
    private static final int FIRST_ELEMENT_INDEX = 0;


    @Override
    public Appliance parseString(String string) throws DaoException {
        try {
            String[] split = string.split(COLON);
            Map<String, String> stringMap = new HashMap<>();
            stringMap.put(APPLIANCE_NAME, split[FIRST_ELEMENT_INDEX].trim());
            String[] data = split[split.length - 1].split(COMMA);
            for (int i = 0; i < data.length; i++) {
                String[] object = data[i].split(EQUAL);
                stringMap.put(object[FIRST_ELEMENT_INDEX].trim(), object[object.length - 1].trim());
            }
            return parseList(stringMap);
        } catch (NumberFormatException | NullPointerException | IndexOutOfBoundsException e) {
            throw new DaoException(e.getMessage());
        }
    }


    private Appliance parseList(Map<String, String> stringMap) {
        switch (stringMap.get(APPLIANCE_NAME)) {
            case "Laptop":
                return parseToLaptop(stringMap);
            case "Oven":
                return parseToOven(stringMap);
            case "Refrigerator":
                return parseToRefrigerator(stringMap);
            case "Speakers":
                return parseToSpeakers(stringMap);
            case "TabletPC":
                return parseToTablePC(stringMap);
            case "VacuumCleaner":
                return parseToVacuumCleaner(stringMap);
            default:
                throw new NumberFormatException("Not find appliance with name:" + stringMap.get(APPLIANCE_NAME));
        }
    }

    private Appliance parseToVacuumCleaner(Map<String, String> stringMap) {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        vacuumCleaner.setPowerConsumption(Integer.parseInt(stringMap.get(POWER_CONSUMPTION.toString())));
        vacuumCleaner.setFilterType(stringMap.get(FILTER_TYPE.toString()));
        vacuumCleaner.setBagType(stringMap.get(BAG_TYPE.toString()));
        vacuumCleaner.setWandType(stringMap.get(WAND_TYPE.toString()));
        vacuumCleaner.setMotorSpeedRegulation(Integer.parseInt(stringMap.get(MOTOR_SPEED_REGULATION.toString())));
        vacuumCleaner.setCleaningWidth(Integer.parseInt(stringMap.get(CLEANING_WIDTH.toString())));
        return vacuumCleaner;
    }

    private Appliance parseToTablePC(Map<String, String> stringMap) {
        TabletPC tabletPC = new TabletPC();
        tabletPC.setBatteryCapacity(Double.parseDouble(stringMap.get(BATTERY_CAPACITY.toString())));
        tabletPC.setDisplayInches(Integer.parseInt(stringMap.get(DISPLAY_INCHES.toString())));
        tabletPC.setMemoryRom(Long.parseLong(stringMap.get(MEMORY_ROM.toString())));
        tabletPC.setFlashMemoryCapacity(Integer.parseInt(stringMap.get(FLASH_MEMORY_CAPACITY.toString())));
        tabletPC.setColor(stringMap.get(COLOR.toString()));
        return tabletPC;
    }

    private Appliance parseToSpeakers(Map<String, String> stringMap) {
        Speakers speakers = new Speakers();
        speakers.setPowerConsumption(Integer.parseInt(stringMap.get(POWER_CONSUMPTION.toString())));
        speakers.setNumberOfSpeakers(Integer.parseInt(stringMap.get(NUMBER_OF_SPEAKERS.toString())));
        speakers.setFrequencyRange(stringMap.get(FREQUENCY_RANGE.toString()));
        speakers.setCordLength(Integer.parseInt(stringMap.get(CORD_LENGTH.toString())));
        return speakers;
    }

    private Appliance parseToRefrigerator(Map<String, String> stringMap) {
        Refrigerator refrigerator = new Refrigerator();
        refrigerator.setPowerConsumption(Integer.parseInt(stringMap.get(POWER_CONSUMPTION.toString())));
        refrigerator.setWeight(Integer.parseInt(stringMap.get(WEIGHT.toString())));
        refrigerator.setFreezerCapacity(Integer.parseInt(stringMap.get(FREQUENCY_RANGE.toString())));
        refrigerator.setOverallCapacity(Double.parseDouble(stringMap.get(OVERALL_CAPACITY.toString())));
        refrigerator.setHeight(Double.parseDouble(stringMap.get(HEIGHT.toString())));
        refrigerator.setWeight(Integer.parseInt(stringMap.get(WIDTH.toString())));
        return refrigerator;
    }

    private Appliance parseToOven(Map<String, String> stringMap) {
        Oven oven = new Oven();
        oven.setPowerConsumption(Integer.parseInt(stringMap.get(POWER_CONSUMPTION.toString())));
        oven.setWeight(Integer.parseInt(stringMap.get(WEIGHT.toString())));
        oven.setCapacity(Integer.parseInt(stringMap.get(CAPACITY.toString())));
        oven.setDepth(Integer.parseInt(stringMap.get(DEPTH.toString())));
        oven.setHeight(Double.parseDouble(stringMap.get(HEIGHT.toString())));
        oven.setWidth(Double.parseDouble(stringMap.get(WIDTH.toString())));
        return oven;
    }

    private Appliance parseToLaptop(Map<String, String> stringMap) {
        Laptop laptop = new Laptop();
        laptop.setBatteryCapacity(Double.parseDouble(stringMap.get(BATTERY_CAPACITY.toString())));
        laptop.setOs(stringMap.get(OS.toString()));
        laptop.setMemoryRom(Long.parseLong(stringMap.get(MEMORY_ROM.toString())));
        laptop.setSystemMemory(Integer.parseInt(stringMap.get(SYSTEM_MEMORY.toString())));
        laptop.setCpu(Double.parseDouble(stringMap.get(CPU.toString())));
        laptop.setDisplayInches(Integer.parseInt(stringMap.get(DISPLAY_INCHS.toString())));
        return laptop;
    }
}