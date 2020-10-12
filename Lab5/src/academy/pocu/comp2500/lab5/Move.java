package academy.pocu.comp2500.lab5;

import academy.pocu.comp2500.lab5.Barbarian;
import academy.pocu.comp2500.lab5.Gladiator;

import java.util.ArrayList;
import java.util.List;

public class Move {
    private String name;
    private int power;
    private int count;
    private int max;


    public Move(String name, int power, int count) {
        this.name = name;
        this.power = power;
        this.count = count;
        this.max = count;
    }

    public String getName() {
        return this.name;
    }

    public int getPower() {
        return this.power;
    }

    public int getCount() {
        if (this.count < 0) {
            return 0;
        }
        return this.count;
    }

    public void downCount() {
        this.count -= 1;
    }

    public void upCount() {
        if (max > count) {
            this.count += 1;
        }
    }

}
