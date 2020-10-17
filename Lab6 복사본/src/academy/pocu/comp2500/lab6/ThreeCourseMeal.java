package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends SetMenu {
    public ThreeCourseMeal() {
        super(25, 1, 1, 1);
    }

    public void setAppetizer(Appetizer appetizer) {
        super.appetizers.clear();
        super.appetizers.add(appetizer);
        super.checkValid();
    }

    public void setMainCourse(MainCourse mainCourse) {
        super.mainCourses.clear();
        super.mainCourses.add(mainCourse);
        super.checkValid();
    }

    public void setDessert(Dessert dessert) {
        super.desserts.clear();
        super.desserts.add(dessert);
        super.checkValid();
    }
}
