package com.shilovich.day2_1.entity;

public class Speakers extends Appliance {
    private int powerConsumption;
    private int numberOfSpeakers;
    private String frequencyRange;
    private int cordLength;

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