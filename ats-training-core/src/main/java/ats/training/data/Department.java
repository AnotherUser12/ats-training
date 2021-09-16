package ats.training.data;

public class Department {

    public Department(int ID, String name){
        this.ID = ID;
        this.name = name;
    }
    private int ID;
    private String name;

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Department{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                '}';
    }
}
