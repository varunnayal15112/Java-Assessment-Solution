package com.varun.assessment.models;

public class EmployeeLeavePortal {
    private int totalLeaves;
    private int numberOfSL;
    private int numberofCL;
    private int numberOfPL;
    LeaveManagementSystem leaveDashboard;

    EmployeeLeavePortal(EmployeeType employeeType) {
        if (employeeType == EmployeeType.Probation) {
            this.totalLeaves = 0;
            this.numberofCL = 0;
            this.numberOfPL = 0;
            this.numberOfSL = 0;
        }
        if (employeeType == EmployeeType.Permanent) {
            this.totalLeaves = 25;
            this.numberofCL = 5;
            this.numberOfPL = 15;
            this.numberOfSL = 5;
        }
    }
}
