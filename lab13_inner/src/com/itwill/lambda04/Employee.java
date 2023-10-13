package com.itwill.lambda04;

public class Employee {
    // field
    private int empId; // 사번
    private String empName; // 사원 이름
    private String dept; // 부서(department)
    private String empTitle; // 사원 직급(대리, 과장, 부장, ...)
    private double salary; // 급여

    // constructor
    public Employee(int empId, String empName, String dept, String empTitle, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.dept = dept;
        this.empTitle = empTitle;
        this.salary = salary;
    }

    // getters & setters
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmpTitle() {
        return empTitle;
    }

    public void setEmpTitle(String empTitle) {
        this.empTitle = empTitle;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return String.format("Employee{id=%d, name=%s, dept=%s, title=%s, salary: %.2f}", 
                empId, empName, dept, empTitle, salary);
    }
    
}
