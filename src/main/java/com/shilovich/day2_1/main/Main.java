package com.shilovich.day2_1.main;

import static com.shilovich.day2_1.entity.criteria.SearchCriteria.*;

import com.shilovich.day2_1.entity.Appliance;
import com.shilovich.day2_1.entity.criteria.Criteria;
import com.shilovich.day2_1.service.ApplianceService;
import com.shilovich.day2_1.service.ServiceFactory;
import com.shilovich.day2_1.service.exception.ServiceException;

public class Main {

    public static void main(String[] args) {
        Appliance appliance = null;

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();

        //////////////////////////////////////////////////////////////////

        Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());//"Oven"
        criteriaOven.add(Oven.CAPACITY.toString(), 32);

        try {
            appliance = service.find(criteriaOven);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }

        PrintApplianceInfo.print(appliance);

        //////////////////////////////////////////////////////////////////

        criteriaOven = new Criteria(Oven.class.getSimpleName());
        criteriaOven.add(Oven.HEIGHT.toString(), 200);
        criteriaOven.add(Oven.DEPTH.toString(), 300);

        try {
            appliance = service.find(criteriaOven);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }

        PrintApplianceInfo.print(appliance);

        //////////////////////////////////////////////////////////////////

        Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
        criteriaTabletPC.add(TabletPC.COLOR.toString(), "BLUE");
        criteriaTabletPC.add(TabletPC.DISPLAY_INCHES.toString(), 14);
        criteriaTabletPC.add(TabletPC.MEMORY_ROM.toString(), 8000L);

        try {
            appliance = service.find(criteriaTabletPC);// find(Object...obj)
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }

        PrintApplianceInfo.print(appliance);
    }
}