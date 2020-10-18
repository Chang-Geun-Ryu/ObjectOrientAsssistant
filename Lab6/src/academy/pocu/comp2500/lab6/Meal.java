package academy.pocu.comp2500.lab6;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Meal extends Food {
    protected enum MealType {
        THREE_COURSE_MEAL,
        DEATH_BY_DESSERTS,
        NO_HEAVY_MEAL
    }

    protected MealType mealType;
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

    public Appetizer getAppetizer() {
        assert (this.appetizers.size() == 1) : "call isValid() first!";
        return this.appetizers.get(0);
    }

    public ArrayList<Dessert> getDesserts() {
        return this.desserts;
    }

    public Dessert getDessert() {
        assert (this.desserts.size() == 1) : "call isValid() first!";
        return this.desserts.get(0);
    }

    public ArrayList<MainCourse> getMainCourses() {
        return mainCourses;
    }

    public MainCourse getMainCourse() {
        assert (this.mainCourses.size() == 1) : "call isValid() first!";
        return this.mainCourses.get(0);
    }

    public void setMainCourse(MainCourse mainCourse) {
        if (this.mealType == MealType.NO_HEAVY_MEAL) {
            return;
        }

        if (this.mealType == MealType.DEATH_BY_DESSERTS) {
            return;
        }

        if (this.mainCourses.size() == 0) {
            this.mainCourses.add(mainCourse);
        } else {
            this.mainCourses.set(0, mainCourse);
        }

        this.checkAndUpdateValid();
    }

    public void setAppetizer(Appetizer appetizer) {
        if (this.mealType == MealType.DEATH_BY_DESSERTS) {
            return;
        }

        if (this.mealType == MealType.NO_HEAVY_MEAL) {
            return;
        }

        if (this.appetizers.size() == 0) {
            this.appetizers.add(appetizer);
        } else {
            this.appetizers.set(0, appetizer);
        }

        this.checkAndUpdateValid();
    }

    public void setDessert(Dessert dessert) {
        if (this.mealType == MealType.DEATH_BY_DESSERTS) {
            return;
        }

        if (this.desserts.size() == 0) {
            this.desserts.add(dessert);
        } else {
            this.desserts.set(0, dessert);
        }

        this.checkAndUpdateValid();
    }

    public void checkAndUpdateValid() {
        if (this.mealType == MealType.NO_HEAVY_MEAL) {
            if (this.appetizers.size() == 2 && this.desserts.size() == 1) {
                super.isValid = true;
            }
        } else if (this.mealType == MealType.THREE_COURSE_MEAL) {
            if (this.appetizers.size() == 1 && this.mainCourses.size() == 1 && this.desserts.size() == 1) {
                super.isValid = true;
            }
        } else if (this.mealType == MealType.DEATH_BY_DESSERTS) {
            if (this.desserts.size() == 3) {
                super.isValid = true;
            }
        }
    }
}
