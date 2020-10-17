package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends Combo {
    private static final int PRICE = 25;

    public ThreeCourseMeal() {
        super(PRICE);
    }

    private boolean isMax() {
        return super.appetizers.size() != 0 && super.mainCourses.size() != 0 && super.desserts.size() != 0;
    }


    public void setMainCourse(MainCourse mainCourse) {
        if (super.mainCourses.size() == 0) {
            super.mainCourses.add(mainCourse);
        } else {
            super.mainCourses.set(0, mainCourse);
        }
        super.isAdded = isMax();
    }

    public void setAppetizer(Appetizer appetizer) {
        if (super.appetizers.size() == 0) {
            super.appetizers.add(appetizer);
        } else {
            super.appetizers.set(0, appetizer);
        }
        super.isAdded = isMax();
    }

    public void setDessert(Dessert dessert) {
        if (super.desserts.size() == 0) {
            super.desserts.add(dessert);
        } else {
            super.desserts.set(0, dessert);
        }
        super.isAdded = isMax();
    }
}
