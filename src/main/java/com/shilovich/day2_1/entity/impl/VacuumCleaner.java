package com.shilovich.day2_1.entity.impl;

import com.shilovich.day2_1.entity.Appliance;

import java.util.Map;

import static com.shilovich.day2_1.entity.criteria.SearchCriteria.VacuumCleaner.*;

public class VacuumCleaner implements Appliance {
    private int powerConsumption;
    private String filterType;
    private String bagType;
    private String wandType;
    private int motorSpeedRegulation;
    private int cleaningWidth;

    public VacuumCleaner(int powerConsumption, String filterType, String bagType, String wandType, int motorSpeedRegulation, int cleaningWidth) {
        this.powerConsumption = powerConsumption;
        this.filterType = filterType;
        this.bagType = bagType;
        this.wandType = wandType;
        this.motorSpeedRegulation = motorSpeedRegulation;
        this.cleaningWidth = cleaningWidth;
    }

    public VacuumCleaner() {
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getBagType() {
        return bagType;
    }

    public void setBagType(String bagType) {
        this.bagType = bagType;
    }

    public String getWandType() {
        return wandType;
    }

    public void setWandType(String wandType) {
        this.wandType = wandType;
    }

    public int getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public void setMotorSpeedRegulation(int motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public int getCleaningWidth() {
        return cleaningWidth;
    }

    public void setCleaningWidth(int cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }

    @Override
    public boolean accordToAppliance(Map<String, Object> data) {
        boolean result = false;
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (POWER_CONSUMPTION.toString().equals(key) && value.equals(powerConsumption)) {
                result = true;
            } else if (FILTER_TYPE.toString().equals(key) && value.equals(filterType)) {
                result = true;
            } else if (BAG_TYPE.toString().equals(key) && value.equals(bagType)) {
                result = true;
            } else if (WAND_TYPE.toString().equals(key) && value.equals(wandType)) {
                result = true;
            } else if (MOTOR_SPEED_REGULATION.toString().equals(key) && value.equals(motorSpeedRegulation)) {
                result = true;
            } else if (CLEANING_WIDTH.toString().equals(key) && value.equals(cleaningWidth)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VacuumCleaner that = (VacuumCleaner) o;
        if (powerConsumption != that.powerConsumption) {
            return false;
        }
        if (motorSpeedRegulation != that.motorSpeedRegulation) {
            return false;
        }
        if (cleaningWidth != that.cleaningWidth) {
            return false;
        }
        if (filterType != null ? !filterType.equals(that.filterType) : that.filterType != null) {
            return false;
        }
        if (bagType != null ? !bagType.equals(that.bagType) : that.bagType != null) {
            return false;
        }
        return wandType != null ? wandType.equals(that.wandType) : that.wandType == null;
    }

    @Override
    public int hashCode() {
        int result = powerConsumption;
        result = 31 * result + (filterType != null ? filterType.hashCode() : 0);
        result = 31 * result + (bagType != null ? bagType.hashCode() : 0);
        result = 31 * result + (wandType != null ? wandType.hashCode() : 0);
        result = 31 * result + motorSpeedRegulation;
        result = 31 * result + cleaningWidth;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("VacuumCleaner{");
        builder.append("powerConsumption=").append(powerConsumption);
        builder.append(", filterType='").append(filterType).append('\'');
        builder.append(", bagType='").append(bagType).append('\'');
        builder.append(", wandType='").append(wandType).append('\'');
        builder.append(", motorSpeedRegulation=").append(motorSpeedRegulation);
        builder.append(", cleaningWidth=").append(cleaningWidth);
        builder.append('}');
        return builder.toString();
    }
}