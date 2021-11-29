package practice.oop;

public abstract class Human implements Etable{
    private int age;
    private String name;

    public abstract void setFavoriteFood(String food) ;

    public Human() {
        System.out.println("init Human");
    }

    public Human(int age, String name) {
        System.out.println("init Human " + age+" "+ name);
        this.age = age;
        this.name = name;
    }

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
        System.out.println("Human " +name+" eat "+food);
    }


}
