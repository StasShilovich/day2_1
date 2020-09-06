package com.shilovich.day2_1.entity;

import java.util.Map;

public interface Appliance {
    Appliance createFromMap(Map<String, String> data);
}