package vn.com.employeemng.employeemanagement;

public class Employee {

    //id nv
    int id;

    //ten nv
    String name;

    //vi tri
    String position;

    //dia chi
    String address;

    //luong
    Float salary;

    public int getId() {
        return id;
    }

    public Employee setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public Employee setPosition(String position) {
        this.position = position;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Employee setAddress(String address) {
        this.address = address;
        return this;
    }

    public Float getSalary() {
        return salary;
    }

    public Employee setSalary(Float salary) {
        this.salary = salary;
        return this;
    }
}
