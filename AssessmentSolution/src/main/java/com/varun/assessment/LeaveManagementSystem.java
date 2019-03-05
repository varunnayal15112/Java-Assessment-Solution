package com.varun.assessment;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Data
public class LeaveManagementSystem {

    Map<String, ArrayList<String>> holidayChart = new HashMap<String, ArrayList<String>>();

    boolean addPublicHoliday(EmployeeRole employeeRole, String month, String date) throws IllegalStateException {
        if (employeeRole == EmployeeRole.Admin) {
            Object value = holidayChart.get(month);
            if (value != null) {
                ArrayList<String> holidayList = holidayChart.get(month);
                if (holidayList == null) {
                    holidayList = new ArrayList<String>();
                    holidayList.add(date);
                    holidayChart.put(month, holidayList);
                } else {
                    holidayList.add(date);
                    holidayChart.put(month, holidayList);
                }
            } else {
                ArrayList<String> holidayList = new ArrayList<String>();
                holidayList.add(date);
                holidayChart.put(month, holidayList);
            }
            return true;
        } else
            throw new IllegalStateException("Access Denied !");

    }

    void showHolidayChartByMonth(String month) {
        ArrayList<String> holidayList = holidayChart.get(month);
        System.out.println(month + " ---> " + holidayList);

    }

    void showCompleteHolidayChart() {
        for (String nameOfMonth : holidayChart.keySet()) {
            ArrayList<String> holidayList = holidayChart.get(nameOfMonth);
            System.out.println(nameOfMonth + " ---> " + holidayList);
        }
    }
}
