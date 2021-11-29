package practice.hw.l5_ivan;

public class Manufacturer {
    private String name;
    private String country;
    private String founder;
    private String ceo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", founder='" + founder + '\'' +
                ", ceo='" + ceo + '\'' +
                '}';
    }
}
