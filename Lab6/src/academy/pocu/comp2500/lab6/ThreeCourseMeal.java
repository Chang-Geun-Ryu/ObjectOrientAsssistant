package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class ThreeCourseMeal extends Meal {
    private static final int PRICE = 25;

    public ThreeCourseMeal() {
        super(PRICE);

        super.mealType = MealType.THREE_COURSE_MEAL;
    }
}
