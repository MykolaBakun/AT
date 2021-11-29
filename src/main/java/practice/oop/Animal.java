package practice.oop;

public class Animal implements Etable {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "practic.oop.Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void eat(String food) {
        System.out.println("Animal " +name+" eat "+food);
    }
}
