package com.shilovich.day2_1.entity;

public class Laptop extends Appliance {
    private double batteryCapacity;
    private String os;
    private long memoryRom;
    private int systemMemory;
    private double cpu;
    private int displayInches;

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public long getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(long memoryRom) {
        this.memoryRom = memoryRom;
    }

    public int getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(int systemMemory) {
        this.systemMemory = systemMemory;
    }

    public double getCpu() {
        return cpu;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    public int getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(int displayInches) {
        this.displayInches = displayInches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Laptop laptop = (Laptop) o;
        if (Double.compare(laptop.batteryCapacity, batteryCapacity) != 0) {
            return false;
        }
        if (memoryRom != laptop.memoryRom) {
            return false;
        }
        if (systemMemory != laptop.systemMemory) {
            return false;
        }
        if (Double.compare(laptop.cpu, cpu) != 0) {
            return false;
        }
        if (displayInches != laptop.displayInches) {
            return false;
        }
        return os != null ? os.equals(laptop.os) : laptop.os == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(batteryCapacity);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (os != null ? os.hashCode() : 0);
        result = 31 * result + (int) (memoryRom ^ (memoryRom >>> 32));
        result = 31 * result + systemMemory;
        temp = Double.doubleToLongBits(cpu);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + displayInches;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("Laptop{");
        builder.append("batteryCapacity=").append(batteryCapacity);
        builder.append(", os='").append(os).append('\'');
        builder.append(", memoryRom=").append(memoryRom);
        builder.append(", systemMemory=").append(systemMemory);
        builder.append(", cpu=").append(cpu);
        builder.append(", displayInches=").append(displayInches);
        builder.append('}');
        return builder.toString();
    }
}