package academy.pocu.comp2500.lab6;

import java.util.ArrayList;
import java.util.Collections;

public class SetMenu extends Manu {
    protected SetMenu(MenuPrice price) {
        super(price);
    }

    public ArrayList<MainCourse> getMainCourses() {
        if (super.price == MenuPrice.DEATH_BY_DESSERTS) {
            return new ArrayList<MainCourse>();

        } else if (super.price == MenuPrice.NO_HEAVY_MEAL) {
            return new ArrayList<MainCourse>();

        } else if (super.price == MenuPrice.THREE_COURSE_MEAL){
            if (this.mainCourse != null) {
                return new ArrayList<MainCourse>(Collections.singleton(this.mainCourse));
            } else {
                return new ArrayList<MainCourse>();
            }
        } else {
            return new ArrayList<MainCourse>();
        }
    }

    public ArrayList<Dessert> getDesserts() {
        if (super.price == MenuPrice.DEATH_BY_DESSERTS) {
            return this.desserts;

        } else {//if (super.price == MenuPrice.NO_HEAVY_MEAL) {
            if (this.dessert != null) {
                return new ArrayList<Dessert>(Collections.singleton(this.dessert));
            } else {
                return new ArrayList<Dessert>();
            }
//        } else if (super.price == MenuPrice.THREE_COURSE_MEAL){
//            return new ArrayList<Dessert>(Collections.singleton(this.dessert));
//        } else {
//            return new ArrayList<Dessert>();
        }
    }

    public ArrayList<Appetizer> getAppetizers() {
        if (super.price == MenuPrice.DEATH_BY_DESSERTS) {
            return new ArrayList<Appetizer>();

        } else if (super.price == MenuPrice.NO_HEAVY_MEAL) {
            return this.appetizers;

        } else if (super.price == MenuPrice.THREE_COURSE_MEAL){
            if (this.appetizer != null) {
                return new ArrayList<Appetizer>(Collections.singleton(this.appetizer));
            } else {
                return new ArrayList<Appetizer>();
            }
        } else {
            return new ArrayList<Appetizer>();
        }
    }
}
