package za.ac.tut.model;
public class Child {
    private String name;
    private String gender;
    public Child(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }
    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "Name: " + name + "\n Gender: " + gender;
    }
}
