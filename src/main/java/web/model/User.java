package web.model;

public class User {
    private int id;
    private String name;
    private int age;
    private double skill;

    public User() {
    }

    public User(int id, String name, int age, double skill) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.skill = skill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSkill() {
        return skill;
    }

    public void setSkill(double skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return id + ". " + name + ", " + age + " лет. Мастерство: " + skill;
    }
}
