package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Meal extends MenuItem {
    protected final ArrayList<Appetizer> appetizers = new ArrayList<>();
    protected final ArrayList<MainCourse> mainCourses = new ArrayList<>();
    protected final ArrayList<Dessert> desserts = new ArrayList<>();

    protected Meal(int price) {
        super(price);
    }

    public ArrayList<Appetizer> getAppetizers() {
        return appetizers;
    }

//    public Appetizer getAppetizer() {
//        Appetizer appetizer = appetizers.get(0);
//        assert (appetizer != null) : "call isValid() first!";
//        return appetizer;
//    }

    public ArrayList<MainCourse> getMainCourses() {
        return mainCourses;
    }

//    public MainCourse getMainCourse() {
//        MainCourse mainCourse = mainCourses.get(0);
//        assert (mainCourse != null) : "call isValid() first!";
//        return mainCourse;
//    }

    public ArrayList<Dessert> getDesserts() {
        return desserts;
    }

//    public Dessert getDessert() {
//        Dessert dessert = desserts.get(0);
//        assert (dessert != null) : "call isValid() first!";
//        return dessert;
//    }
}
