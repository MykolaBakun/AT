package practice.hw.l5_ivan;
import java.io.Serializable;

public class Computer implements Serializable {
    private String name;
    private Integer price;
    private String color;
    private Manufacturer manufacturer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", manufacturer=" + manufacturer +
                '}';
    }
}
