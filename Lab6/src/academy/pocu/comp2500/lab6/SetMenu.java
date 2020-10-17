package academy.pocu.comp2500.lab6;

import com.sun.tools.javac.Main;

import java.util.ArrayList;

public class SetMenu extends Menu {

    private ArrayList<Appetizer> appetizers = new ArrayList<>();
    private ArrayList<Dessert> desserts = new ArrayList<>();
    private ArrayList<MainCourse> mainCourses = new ArrayList<>();

    private final int MAX_APPETIZER_COUNT;
    private final int MAX_DESSERT_COUNT;
    private final int MAX_MAIN_COURSE_COUNT;


    public SetMenu(int price, int MAX_APPETIZERS_COUNT, int MAX_Desserts_COUNT, int MAX_MAIN_COURSES_COUNT) {
        super(price);
        this.MAX_APPETIZER_COUNT = MAX_APPETIZERS_COUNT;
        this.MAX_DESSERT_COUNT = MAX_Desserts_COUNT;
        this.MAX_MAIN_COURSE_COUNT = MAX_MAIN_COURSES_COUNT;
    }

    public ArrayList<Appetizer> getAppetizers() {
        return appetizers;
    }

    protected boolean addAppetizer(Appetizer appetizer) {
        if (this.appetizers.size() < this.MAX_APPETIZER_COUNT) {
            this.appetizers.add(appetizer);
            return true;
        }
        return false;
    }

    protected boolean addDessert(Dessert dessert) {
        if (this.desserts.size() < this.MAX_DESSERT_COUNT) {
            this.desserts.add(dessert);
            return true;
        }
        return false;
    }

    protected boolean addMainCourse(MainCourse mainCourse) {
        if (this.mainCourses.size() < this.MAX_MAIN_COURSE_COUNT) {
            this.mainCourses.add(mainCourse);
            return true;
        }
        return false;
    }



    public boolean setAppetizers(Appetizer appetizer1, Appetizer appetizer2) {
        if (this.MAX_APPETIZER_COUNT < 2) {
            return false;
        }
        this.appetizers.clear();
        return this.addAppetizer(appetizer1) && this.addAppetizer(appetizer2);
    }

    public ArrayList<Dessert> getDesserts() {
        return desserts;
    }

    public boolean setDesserts(Dessert dessert1, Dessert dessert2, Dessert dessert3, Dessert dessert4) {
        if (this.MAX_DESSERT_COUNT < 4) {
            return false;
        }
        this.desserts.clear();

        return this.addDessert(dessert1) && this.addDessert(dessert2) && this.addDessert(dessert3) && this.addDessert(dessert4);
    }

    public MainCourse getMainCourse() {
        assert (this.mainCourses != null) : "call isValid() first!";
        return this.mainCourses.get(0);
    }

    public Appetizer getAppetizer() {
        assert (this.appetizers != null) : "call isValid() first!";
        return this.appetizers.get(0);
    }

    public Dessert getDessert() {
        assert (this.desserts != null) : "call isValid() first!";
        return this.desserts.get(0);
    }

    public ArrayList<MainCourse> getMainCourses() {
        return mainCourses;
    }

    public void setMainCourse(MainCourse mainCourse) {
        if (this.MAX_MAIN_COURSE_COUNT == 0) {
            return;
        }
        this.addMainCourse(mainCourse);
    }

    public void setAppetizer(Appetizer appetizer) {
        if (this.MAX_APPETIZER_COUNT == 0) {
            return;
        }
        this.addAppetizer(appetizer);
    }

    public void setDessert(Dessert dessert) {
        if (this.MAX_DESSERT_COUNT == 0) {
            return;
        }
        this.addDessert(dessert);
    }

    public boolean isValid() {
        return this.appetizers.size() == this.MAX_APPETIZER_COUNT && this.desserts.size() == this.MAX_DESSERT_COUNT && this.mainCourses.size() == this.MAX_MAIN_COURSE_COUNT;
    }
}
