package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entity.Employee;

public class EmployeeService {
    private static EmployeeService instance;
    private List<Employee> employees;
    private int nextEmployeeId = 1;

    private EmployeeService() {
        // Private constructor to prevent direct instantiation
        this.employees = createDummyData(); // Initialize as an empty list
    }

    public static EmployeeService getInstance() {
        if (instance == null) {
            synchronized (EmployeeService.class) {
                if (instance == null) {
                    instance = new EmployeeService();
                }
            }
        }
        return instance;
    }

    public boolean checkPassword(Employee employee, String password) {
        return employee != null && employee.getPassword().equals(password);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public boolean isValidUser1(String inputName, String inputPassword) {
        if (this.employees != null) {
            Iterator<Employee> employeeIterator = this.employees.iterator();

            while (employeeIterator.hasNext()) {
                Employee employee = employeeIterator.next();

                if (employee.getName().trim().equals(inputName.trim()) && employee.getPassword().trim().equals(inputPassword.trim())) {
                    return true; // Match found, return true
                }
            }

            // No match found, return false after checking all employees
            return false;
        } else {
            System.out.println("Employees list is null"); // Handle the case where employees is null
            return false; // No employees to validate against, return false
        }
    }
    public boolean isAdmin(String inputName) {
        Employee user = getUserByName(inputName);
        return user != null && user.isAdmin();
    }

    public Employee getUserByName(String name) {
        for (Employee user : employees) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null; // User not found
    }

    public void addEmployee(Employee employee) {
        employee.setEmployeeId(nextEmployeeId++);
        employees.add(employee);
    }

    public void deleteEmployee(int employeeId) {
        Employee employeeToRemove = null;
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employees.remove(employeeToRemove);
        }
    }

    public boolean updateEmployee(Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getEmployeeId() == updatedEmployee.getEmployeeId()) {
                employees.set(i, updatedEmployee);
                return true; // Employee updated successfully
            }
        }
        return false; // Employee not found
    }
   
    private List<Employee> createDummyData() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "abc", "111", 50000, true));
        employees.add(new Employee(2, "xyz", "222 ", 60000, false));
        employees.add(new Employee(3, "Bob Johnson", "123", 55000, false));
        employees.add(new Employee(4, "Alice Brown", "1234", 52000, true));

        return employees;
    }
    public Employee getEmployeeById(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                return employee; // Return the employee with the specified ID
            }
        }
        return null; // No employee found with the specified ID
    }
    public List<Employee> getEmployeeList() {
        return employees;
    }

	public int getNextEmployeeId() {
		return nextEmployeeId;
	}
	public boolean updateEmployee(int employeeId, String name, String password, double salary, boolean isAdmin) {
	    for (Employee employee : employees) {
	        if (employee.getEmployeeId() == employeeId) {
	            employee.setAdmin(isAdmin);
	            
	                employee.setName(name);
	                employee.setPassword(password);
	                employee.setSalary(salary);
	                return true; // Employee updated successfully
	            
	        }
	    }
	    return false; // Employee not found
	}
	}
