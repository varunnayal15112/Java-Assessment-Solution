package com.varun.assessment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestLMS {
    Employee employee1,employee2;

    @Before
    public void init() throws Exception{
        employee1 = new Employee("Varun Nayal","varun.nayal@hashmapinc.com","15/01/1997",EmployeeType.Probation,EmployeeRole.Admin.NonAdmin);
        employee2 = new Employee("Shubham Pal","shubham.pal@hashmapinc.com","15/01/1997",EmployeeType.Permanent,EmployeeRole.NonAdmin);
    }

    @Test
    public void testValidityOfEmployeeName() {
        Employee employee = new Employee();
        String employeeName = "Varun Nayal";
        boolean status = employee.checkValidityOfEmployeeName(employeeName);
        Assert.assertEquals(true,status);
    }

    @Test
    public void testValidityOfEmployeeEmailID() {
        Employee employee = new Employee();
        String employeeEmailID = "varun.nayal@hashmapinc";
        boolean status = employee.checkValidityOfEmployeeEmailID(employeeEmailID);
        Assert.assertEquals(false,status);
    }

    @Test
    public void testApplyForLeaves() {
        boolean status = employee2.applyForLeaves(LeaveType.CL,3);
        Assert.assertEquals(true,status);
    }

    @Test
    public void testAddPublicHoliday() {
        LeaveManagementSystem object = new LeaveManagementSystem();
        boolean status = object.addPublicHoliday(EmployeeRole.Admin,"MAR","15/03/1997");
        Assert.assertEquals(true,status);

    }

}
