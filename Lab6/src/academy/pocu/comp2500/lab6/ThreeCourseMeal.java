package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class ThreeCourseMeal extends Meal {
    private static final int PRICE = 25;

    public ThreeCourseMeal() {
        super(PRICE);
    }

    public void setMainCourse(MainCourse mainCourse) {
        if (this.mainCourses.size() == 0) {
            this.mainCourses.add(mainCourse);
        } else {
            this.mainCourses.set(0, mainCourse);
        }

        this.checkAndUpdateValid();
    }

    public void setAppetizer(Appetizer appetizer) {
        if (this.appetizers.size() == 0) {
            this.appetizers.add(appetizer);
        } else {
            this.appetizers.set(0, appetizer);
        }

        this.checkAndUpdateValid();
    }

    public void setDessert(Dessert dessert) {
        if (this.desserts.size() == 0) {
            this.desserts.add(dessert);
        } else {
            this.desserts.set(0, dessert);
        }

        this.checkAndUpdateValid();
    }

    public void checkAndUpdateValid() {
        if (this.appetizers.size() == 1 && this.mainCourses.size() == 1 && this.desserts.size() == 1) {
            super.isValid = true;
        }
    }
}
