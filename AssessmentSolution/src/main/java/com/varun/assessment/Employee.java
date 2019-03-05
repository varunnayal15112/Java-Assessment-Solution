package com.varun.assessment;
import lombok.Data;

import java.lang.*;
import java.util.regex.*;

enum EmployeeRole {
    Admin,NonAdmin
}

enum EmployeeType {
    Permanent,Probation
}

@Data
public class Employee {

    private String employeeName;
    private String emailID;
    private String dateOfJoining;
    private EmployeeType employeeType;
    private String employeeID;
    private EmployeeRole employeeRole;
    EmployeeLeavePortal leavePortal;

    private static int countOfEmployees;

    static {
        countOfEmployees = 0;
    }
    public Employee() {}

    Employee(String employeeName,String emailID,String dateOfJoining,EmployeeType employeeType,EmployeeRole employeeRole) throws Exception{
        this.employeeName=checkValidityOfEmployeeName(employeeName)?employeeName:null;
        this.emailID=checkValidityOfEmployeeEmailID(emailID)?emailID:null;
        this.dateOfJoining=dateOfJoining;
        this.employeeType=employeeType;
        this.employeeID=generateEmployeeID();
        this.employeeRole=employeeRole;
        this.leavePortal = new EmployeeLeavePortal(employeeType);
    }

    public boolean checkValidityOfEmployeeName(String employeeName) throws IllegalStateException {
        if(employeeName.length()>50 || employeeName==null) {
            throw new IllegalStateException("Invalid Employee Name");
        }
        else
            return true;
    }

    public boolean checkValidityOfEmployeeEmailID(String emailID) throws IllegalStateException {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (pat.matcher(emailID).matches()==false || emailID == null)
            return false;
        else
            return true;
    }

    String generateEmployeeID() {
        countOfEmployees += 1;
        return "Emp" + String.valueOf(countOfEmployees);
    }

    public boolean applyForLeaves(LeaveType leaveType, int numberOfLeaves) {
        if(this.employeeType==EmployeeType.Probation) {
            System.out.println("No Leaves are credited for Probation Type Employee !");
            return false;
        }
        else {
            if(numberOfLeaves > this.leavePortal.getTotalLeaves()) {
                System.out.println("Not so much leaves are remaining in your account ! Can't Sanction");
                return false;
            }
            else
            {
                if(numberOfLeaves > this.leavePortal.remainingLeavesChart.get(leaveType)) {
                    System.out.println("Not so much leaves are remaining in your account ! Can't Sanction");
                    return false;
                }
                else {
                    //getStatusOfLeaveApplication(); //whether leaves are approved or not

                    this.leavePortal.updateTotalLeaves(numberOfLeaves);
                    this.leavePortal.updateRemainingLeavesChart(leaveType,numberOfLeaves);
                    return true;
                }
            }
        }
    }
}
