package practice.oop;

public class YoungHuman extends Human implements Etable{
    private String food;

    public YoungHuman() {

    }

    public YoungHuman(int i, String name) {
        super(i,name);
        ////

    }

    @Override
    public void setFavoriteFood(String food) {
        this.food=food;
    }
}
