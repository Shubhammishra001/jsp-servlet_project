package entity;

public class Employee {
	private int employeeId;
    private String name;
    private String password;
    private double salary;
    public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	private boolean isAdmin;
	public Employee(int employeeId, String name, String password, double salary, boolean isAdmin) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.password = password;
		this.salary = salary;
		this.isAdmin = isAdmin;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", password=" + password + ", salary=" + salary
				+ ", isAdmin=" + isAdmin + "]";
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	}
