package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Combo extends Menu {
    protected ArrayList<Appetizer> appetizers;
    protected ArrayList<Dessert> desserts;
    protected ArrayList<MainCourse> mainCourses;

    protected Combo(int price) {
        super(price);
        appetizers = new ArrayList<>();
        desserts = new ArrayList<>();
        mainCourses = new ArrayList<>();
    }


    public ArrayList<Appetizer> getAppetizers() {
        return appetizers;
    }

    public ArrayList<Dessert> getDesserts() {
        return desserts;
    }

    public ArrayList<MainCourse> getMainCourse() {
        return mainCourses;
    }
}
