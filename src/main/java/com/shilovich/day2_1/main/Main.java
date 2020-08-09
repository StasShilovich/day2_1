package com.shilovich.day2_1.main;

import com.shilovich.day2_1.dao.FileReaderDao;
import com.shilovich.day2_1.dao.impl.FileReaderDaoImpl;

public class Main {
    public static void main(String[] args) {
        FileReaderDao dao=new FileReaderDaoImpl();
        String file = dao.findAppliance("Oven");
        System.out.println(file);
    }
}
