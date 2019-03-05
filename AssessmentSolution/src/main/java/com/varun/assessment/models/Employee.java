package com.varun.assessment.models;
import java.lang.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.text.SimpleDateFormat;


enum EmployeeRole {
    Admin,NonAdmin
}

enum EmployeeType {
    Permanent,Probation
}

public class Employee {

    private String employeeName;
    private String emailID;
    private Date dateOfJoining;
    private EmployeeType employeeType;
    private String employeeID;
    private EmployeeRole employeeRole;

    private static int countOfEmployees;

    static {
        countOfEmployees = 0;
    }

    Employee(String employeeName,String emailID,String dateOfJoining,EmployeeType employeeType,String employeeID,EmployeeRole employeeRole) throws Exception{
        this.employeeName=checkValidityOfEmployeeName(employeeName)?employeeName:null;
        this.emailID=checkValidityOfEmployeeEmailID(emailID)?emailID:null;
        this.dateOfJoining=new SimpleDateFormat("dd/MM/yyyy").parse(dateOfJoining);
        this.employeeType=employeeType;
        this.employeeID=generateEmployeeID();
        this.employeeRole=employeeRole;
    }

    boolean checkValidityOfEmployeeName(String employeeName) throws IllegalStateException {
        if(employeeName.length()>50 || employeeName==null) {
            throw new IllegalStateException("Invalid Employee Name");
        }
        else
            return true;
    }

    boolean checkValidityOfEmployeeEmailID(String emailID) throws IllegalStateException {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (pat.matcher(emailID).matches()==false || emailID == null)
            throw new IllegalStateException("Invalid Employee EmailID");
        else
            return true;
    }

    String generateEmployeeID() {
        countOfEmployees += 1;
        return "Emp" + String.valueOf(countOfEmployees);
    }
}
