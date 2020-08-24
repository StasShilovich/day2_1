package com.shilovich.day2_1.entity.impl;

import com.shilovich.day2_1.entity.Appliance;

import java.util.Map;

import static com.shilovich.day2_1.entity.criteria.SearchCriteria.Oven.*;

public class Oven implements Appliance {
    private int powerConsumption;
    private int weight;
    private int capacity;
    private int depth;
    private double height;
    private double width;

    public Oven(int powerConsumption, int weight, int capacity, int depth, double height, double width) {
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.capacity = capacity;
        this.depth = depth;
        this.height = height;
        this.width = width;
    }

    public Oven() {
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public boolean accordToAppliance(Map<String, Object> data) {
        int count = 0;
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (POWER_CONSUMPTION.toString().equals(key) && value.equals(powerConsumption)) {
                count++;
            } else if (WEIGHT.toString().equals(key) && value.equals(weight)) {
                count++;
            } else if (CAPACITY.toString().equals(key) && value.equals(capacity)) {
                count++;
            } else if (DEPTH.toString().equals(key) && value.equals(depth)) {
                count++;
            } else if (HEIGHT.toString().equals(key) && value.equals(height)) {
                count++;
            } else if (WIDTH.toString().equals(key) && value.equals(width)) {
                count++;
            }
        }
        return count == data.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Oven oven = (Oven) o;
        if (powerConsumption != oven.powerConsumption) {
            return false;
        }
        if (weight != oven.weight) {
            return false;
        }
        if (capacity != oven.capacity) {
            return false;
        }
        if (depth != oven.depth) {
            return false;
        }
        if (Double.compare(oven.height, height) != 0) {
            return false;
        }
        return Double.compare(oven.width, width) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = powerConsumption;
        result = 31 * result + weight;
        result = 31 * result + capacity;
        result = 31 * result + depth;
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("Oven{");
        builder.append("powerConsumption=").append(powerConsumption);
        builder.append(", weight=").append(weight);
        builder.append(", capacity=").append(capacity);
        builder.append(", depth=").append(depth);
        builder.append(", height=").append(height);
        builder.append(", width=").append(width);
        builder.append('}');
        return builder.toString();
    }
}