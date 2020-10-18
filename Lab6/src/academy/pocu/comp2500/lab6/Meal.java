package academy.pocu.comp2500.lab6;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Meal extends Food {
    protected ArrayList<Appetizer> appetizers;
    protected ArrayList<Dessert> desserts;
    protected ArrayList<MainCourse> mainCourses;

    protected Meal(int price) {
        super(price);

        this.appetizers = new ArrayList<Appetizer>();
        this.desserts = new ArrayList<Dessert>();
        this.mainCourses = new ArrayList<MainCourse>();
    }

    public ArrayList<Appetizer> getAppetizers() {
        return this.appetizers;
    }

    public ArrayList<Dessert> getDesserts() {
        return this.desserts;
    }

    public ArrayList<MainCourse> getMainCourses() {
        return mainCourses;
    }
}
