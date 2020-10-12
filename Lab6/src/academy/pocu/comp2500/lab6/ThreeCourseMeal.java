package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends SetMenu {
    public ThreeCourseMeal() {
        super(MenuPrice.THREE_COURSE_MEAL);
    }

    public void setMainCourse(MainCourse mainCourse) {
        this.mainCourse = mainCourse;
    }

    public void setAppetizer(Appetizer appetizer) {
        this.appetizer = appetizer;
    }

    public void setDessert(Dessert desert) {
        this.dessert = desert;
    }
}