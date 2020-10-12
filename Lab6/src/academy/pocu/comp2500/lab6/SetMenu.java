package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class SetMenu extends Menu {
    protected ArrayList<Appetizer> appetizers;
    protected ArrayList<MainCourse> mainCourses;
    protected ArrayList<Dessert> desserts;

    private int appetizersCapacity;
    private int mainCoursesCapacity;
    private int dessertsCapacity;

    protected SetMenu(int price, int appetizersCapacity, int mainCoursesCapacity, int dessertsCapacity) {
        super(price);
        this.appetizers = new ArrayList<>(appetizersCapacity);
        this.mainCourses = new ArrayList<>(mainCoursesCapacity);
        this.desserts = new ArrayList<>(dessertsCapacity);
        this.appetizersCapacity = appetizersCapacity;
        this.mainCoursesCapacity = mainCoursesCapacity;
        this.dessertsCapacity = dessertsCapacity;
    }

    public Appetizer getAppetizer() {
        assert (this.appetizersCapacity == 1) : "This SetMenu contains appetizers more than 1.";
        assert (this.appetizers.isEmpty() == false) : "This SetMenu has not set appertizer.";
        return this.appetizers.get(0);
    }

    public MainCourse getMainCourse() {
        assert (this.mainCoursesCapacity == 1) : "This SetMenu contains mainCourses more than 1.";
        assert (this.mainCourses.isEmpty() == false) : "This SetMenu has not set mainCourse.";
        return this.mainCourses.get(0);
    }

    public Dessert getDessert() {
        assert (this.dessertsCapacity == 1) : "This SetMenu contains desserts more than 1.";
        assert (this.desserts.isEmpty() == false) : "This SetMenu has not set dessert.";
        return this.desserts.get(0);
    }

    public ArrayList<Appetizer> getAppetizers() {
        return this.appetizers;
    }

    public ArrayList<MainCourse> getMainCourses() {
        return this.mainCourses;
    }

    public ArrayList<Dessert> getDesserts() {
        return this.desserts;
    }

    protected void checkValid() {
        if (this.appetizers.size() == this.appetizersCapacity && this.mainCourses.size() == this.mainCoursesCapacity && this.desserts.size() == this.dessertsCapacity) {
            super.valid = true;
        } else {
            super.valid = false;
        }
    }
}
