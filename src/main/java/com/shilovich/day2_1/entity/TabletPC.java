package com.shilovich.day2_1.entity;

public class TabletPC extends Appliance {
    private double batteryCapacity;
    private int displayInches;
    private long memoryRom;
    private int flashMemoryCapacity;
    private String color;

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(int displayInches) {
        this.displayInches = displayInches;
    }

    public long getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(long memoryRom) {
        this.memoryRom = memoryRom;
    }

    public int getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public void setFlashMemoryCapacity(int flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TabletPC tabletPC = (TabletPC) o;
        if (Double.compare(tabletPC.batteryCapacity, batteryCapacity) != 0) {
            return false;
        }
        if (displayInches != tabletPC.displayInches) {
            return false;
        }
        if (memoryRom != tabletPC.memoryRom) {
            return false;
        }
        if (flashMemoryCapacity != tabletPC.flashMemoryCapacity) {
            return false;
        }
        return color != null ? color.equals(tabletPC.color) : tabletPC.color == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(batteryCapacity);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + displayInches;
        result = 31 * result + (int) (memoryRom ^ (memoryRom >>> 32));
        result = 31 * result + flashMemoryCapacity;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("TabletPC{");
        builder.append("batteryCapacity=").append(batteryCapacity);
        builder.append(", displayInches=").append(displayInches);
        builder.append(", memoryRom=").append(memoryRom);
        builder.append(", flashMemoryCapacity=").append(flashMemoryCapacity);
        builder.append(", color='").append(color).append('\'');
        builder.append('}');
        return builder.toString();
    }
}