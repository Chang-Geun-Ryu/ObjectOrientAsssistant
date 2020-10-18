package academy.pocu.comp2500.lab6.app;

import academy.pocu.comp2500.lab6.Appetizer;
import academy.pocu.comp2500.lab6.DeathByDesserts;
import academy.pocu.comp2500.lab6.Dessert;
import academy.pocu.comp2500.lab6.FreeSoulPizza;
import academy.pocu.comp2500.lab6.HousePizza;
import academy.pocu.comp2500.lab6.MainCourse;
import academy.pocu.comp2500.lab6.MeatLoverPizza;
import academy.pocu.comp2500.lab6.NoHeavyMeal;
import academy.pocu.comp2500.lab6.ThreeCourseMeal;
import academy.pocu.comp2500.lab6.Topping;
import academy.pocu.comp2500.lab6.VeggiePizza;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        // write your code here
        DeathByDesserts dd = new DeathByDesserts();
        dd.
        MeatLoverPizza meatLoverPizza = new MeatLoverPizza();
        boolean isAdded = meatLoverPizza.addGreenPeppers(); // true
        boolean isRemoved = meatLoverPizza.removeGreenPeppers(); // true
        isAdded = meatLoverPizza.addRedOnions(); // true
        boolean isValid = meatLoverPizza.isValid(); // true
        int price = meatLoverPizza.getPrice(); // 21
        ArrayList<Topping> toppings = meatLoverPizza.getToppings();

        System.out.println(isAdded);
        System.out.println(isRemoved);
        System.out.println(isValid);
        System.out.println(price);
        System.out.println(toppings);

        DeathByDesserts a = new DeathByDesserts();
        a.setDesserts(Dessert.GREEN_TEA_ICE_CREAM, Dessert.ITALIAN_DONUTS, Dessert.MANGO_PUDDING, Dessert.CHOCOLATE_MOUSSE);
        a.isValid(); // true
        System.out.println(a.isValid());


        {
            NoHeavyMeal noHeavyMeal = new NoHeavyMeal();

            assert (!noHeavyMeal.isValid());

            noHeavyMeal.setAppetizers(Appetizer.CALAMARI, Appetizer.GYOZA);

            assert (!noHeavyMeal.isValid());

            noHeavyMeal.setDessert(Dessert.APPLE_PIE);

            assert (noHeavyMeal.isValid());
        }

        {
            DeathByDesserts deathByDesserts = new DeathByDesserts();

            assert (!deathByDesserts.isValid());

            deathByDesserts.setDesserts(Dessert.GREEN_TEA_ICE_CREAM, Dessert.ITALIAN_DONUTS, Dessert.MANGO_PUDDING, Dessert.CHOCOLATE_MOUSSE);

            assert (deathByDesserts.isValid());
        }

        {
            ThreeCourseMeal threeCourseMeal = new ThreeCourseMeal();

            assert (!threeCourseMeal.isValid());

            threeCourseMeal.setAppetizer(Appetizer.GYOZA);
            threeCourseMeal.setDessert(Dessert.CHOCOLATE_MOUSSE);

            assert (!threeCourseMeal.isValid());

            threeCourseMeal.setMainCourse(MainCourse.BOMBAY_BUTTER_CHICKEN);

            assert (threeCourseMeal.isValid());

            System.out.print("main");
            System.out.println(threeCourseMeal.getMainCourses());
        }

        {
            HousePizza housePizza = new HousePizza();

            assert (!housePizza.isValid());

            assert (housePizza.addBacon());

            assert (!housePizza.isValid());

            assert (housePizza.addPeperoni());

            assert (housePizza.isValid());

            assert (!housePizza.addSausages());

            assert (housePizza.isValid());

            assert (!housePizza.removeSausages());

            assert (housePizza.removeBacon());

            assert (!housePizza.isValid());

            assert (housePizza.addPeperoni());

            assert (housePizza.isValid());
        }

        {
            MeatLoverPizza meatLoverPizza1 = new MeatLoverPizza();

            assert (!meatLoverPizza1.isValid());

            assert (meatLoverPizza1.addGreenPeppers());
            assert (!meatLoverPizza1.addGreenPeppers());

            assert (meatLoverPizza1.isValid());

            assert (meatLoverPizza1.removeGreenPeppers());

            assert (!meatLoverPizza1.isValid());
        }

        {
            VeggiePizza veggiePizza = new VeggiePizza();

            assert (!veggiePizza.isValid());

            assert (veggiePizza.addCheddarCheese());

            assert (!veggiePizza.isValid());

            assert (veggiePizza.addFetaCheese());

            assert (veggiePizza.isValid());

            assert (veggiePizza.removeCheddarCheese());

            assert (!veggiePizza.isValid());

            assert (veggiePizza.addMozzarellaCheese());

            assert (veggiePizza.isValid());
        }

        {
            FreeSoulPizza freeSoulPizza = new FreeSoulPizza();

            assert (!freeSoulPizza.isValid());

            assert (freeSoulPizza.addTopping(Topping.FETA_CHEESE));
            assert (!freeSoulPizza.addTopping(Topping.CHEDDAR_CHEESE));

            assert (freeSoulPizza.addTopping(Topping.BLACK_OLIVES));
            assert (freeSoulPizza.addTopping(Topping.RED_ONIONS));

            assert (!freeSoulPizza.isValid());

            assert (!freeSoulPizza.addTopping(Topping.GREEN_PEPPERS));
            assert (!freeSoulPizza.removeTopping(Topping.GREEN_PEPPERS));

            assert (!freeSoulPizza.isValid());

            assert (freeSoulPizza.addTopping(Topping.CHICKEN));
            assert (freeSoulPizza.addTopping(Topping.SAUSAGES));

            assert (freeSoulPizza.isValid());

            assert (!freeSoulPizza.addTopping(Topping.PEPERONI));
        }


        {
            NoHeavyMeal meal = new NoHeavyMeal();
            meal.setAppetizers(Appetizer.CALAMARI, Appetizer.GYOZA);
            meal.setDessert(Dessert.MANGO_PUDDING);
            System.out.println(meal.getAppetizers());
            System.out.println(meal.getDesserts());

            meal.setAppetizers(Appetizer.SPINACH_DIP, Appetizer.NACHOS);
            meal.setDessert(Dessert.GREEN_TEA_ICE_CREAM);
            System.out.println(meal.getAppetizers());
            System.out.println(meal.getDesserts());
        }

    }
}

