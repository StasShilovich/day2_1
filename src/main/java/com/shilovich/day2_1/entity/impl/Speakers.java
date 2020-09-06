package com.shilovich.day2_1.entity.impl;

import com.shilovich.day2_1.entity.Appliance;

import java.util.Map;

import static com.shilovich.day2_1.entity.criteria.SearchCriteria.Speakers.*;


public class Speakers implements Appliance {
    private int powerConsumption;
    private int numberOfSpeakers;
    private String frequencyRange;
    private int cordLength;

    public Speakers(int powerConsumption, int numberOfSpeakers, String frequencyRange, int cordLength) {
        this.powerConsumption = powerConsumption;
        this.numberOfSpeakers = numberOfSpeakers;
        this.frequencyRange = frequencyRange;
        this.cordLength = cordLength;
    }

    public Speakers() {
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public String getFrequencyRange() {
        return frequencyRange;
    }

    public void setFrequencyRange(String frequencyRange) {
        this.frequencyRange = frequencyRange;
    }

    public int getCordLength() {
        return cordLength;
    }

    public void setCordLength(int cordLength) {
        this.cordLength = cordLength;
    }

    @Override
    public Appliance createFromMap(Map<String, String> data) {
        Speakers speakers = new Speakers();
        speakers.setPowerConsumption(Integer.parseInt(data.get(POWER_CONSUMPTION.toString())));
        speakers.setNumberOfSpeakers(Integer.parseInt(data.get(NUMBER_OF_SPEAKERS.toString())));
        speakers.setFrequencyRange(data.get(FREQUENCY_RANGE.toString()));
        speakers.setCordLength(Integer.parseInt(data.get(CORD_LENGTH.toString())));
        return speakers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Speakers speakers = (Speakers) o;
        if (powerConsumption != speakers.powerConsumption) {
            return false;
        }
        if (numberOfSpeakers != speakers.numberOfSpeakers) {
            return false;
        }
        if (cordLength != speakers.cordLength) {
            return false;
        }
        return frequencyRange != null ? frequencyRange.equals(speakers.frequencyRange) : speakers.frequencyRange == null;
    }

    @Override
    public int hashCode() {
        int result = powerConsumption;
        result = 31 * result + numberOfSpeakers;
        result = 31 * result + (frequencyRange != null ? frequencyRange.hashCode() : 0);
        result = 31 * result + cordLength;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("Speakers{");
        builder.append("powerConsumption=").append(powerConsumption);
        builder.append(", numberOfSpeakers=").append(numberOfSpeakers);
        builder.append(", frequencyRange='").append(frequencyRange).append('\'');
        builder.append(", cordLength=").append(cordLength);
        builder.append('}');
        return builder.toString();
    }


}