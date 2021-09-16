package ats.training.data;

public class Employee {
    public Employee(int ID, String name, String email, double salary, Department department){
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.department = department;
    }
    private int ID;
    private String name;
    private String email;
    private double salary;
    private Department department;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getID() {
        return ID;
    }

    public Department getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

//    @Override
//    public String toString(){
//        return "Name: " + getName() + ";Email: " + getEmail() + ";ID: " + getID() + ";Salary: " + getSalary() + "; Department: " + getDepartment();
//    }

    @Override
    public String toString() {
        return
                //"Employee{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", department=" + department;
                //'}';
    }
}
