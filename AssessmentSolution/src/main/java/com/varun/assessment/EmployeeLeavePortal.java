package com.varun.assessment;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;


enum LeaveType {
    SL,CL,PL
}

@Data
public class EmployeeLeavePortal extends LeaveManagementSystem {
    private int totalLeaves;
    Map<LeaveType,Integer> remainingLeavesChart = new HashMap<LeaveType, Integer>();

    EmployeeLeavePortal(EmployeeType employeeType) {
        if (employeeType == EmployeeType.Probation) {
            this.totalLeaves = 0;
            remainingLeavesChart.put(LeaveType.SL,0);
            remainingLeavesChart.put(LeaveType.CL,0);
            remainingLeavesChart.put(LeaveType.PL,0);
        }
        if (employeeType == EmployeeType.Permanent) {
            this.totalLeaves = 25;
            remainingLeavesChart.put(LeaveType.SL,5);
            remainingLeavesChart.put(LeaveType.CL,5);
            remainingLeavesChart.put(LeaveType.PL,15);
        }
    }

    void updateTotalLeaves(int numberOfleaves) {
        this.totalLeaves -= numberOfleaves;
    }

    void updateRemainingLeavesChart(LeaveType leaveType,int numberOfLeaves) {
        this.remainingLeavesChart.put(leaveType,this.remainingLeavesChart.get(leaveType) - numberOfLeaves);
    }


}
