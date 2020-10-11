package academy.pocu.comp2500.lab5;

import academy.pocu.comp2500.lab5.Barbarian;

import java.util.ArrayList;
import java.util.List;

public class Gladiator extends Barbarian {
    public Gladiator(String name, int Hp, int attack, int defense) {
        super(name, Hp, attack, defense);
    }

    private List<Move> list = new ArrayList<>();
    private int maxSkillCount = 4;

    public boolean addMove(Move skill) {
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i) == skill) {
                return false;
            }
        }
            if (this.list.size() < maxSkillCount) {
                this.list.add(skill);
                return true;
            }
        return false;
    }

    public boolean removeMove(String name) {
        for (int i = 0; i < list.size(); i++) {
            if (this.list.get(i).getName() == name) {
                this.list.remove(this.list.get(i));
                return true;
            }
        }
        return false;
    }

    public void attack(String skill, Barbarian enemy) {
        for (int i = 0; i < list.size(); i++) {
            if (this.list.get(i).getCount() == 0 || this.Hp == 0 || this == enemy || this.list.get(i).getName() != skill) {
                int real = 0;
                enemy.Hp = enemy.Hp - real;
            } else if (this.list.get(i).getName() == skill) {
                this.list.get(i).downCount();
                double damage = ((double) this.attack / (double) enemy.defense * (double) this.list.get(i).getPower()) / 2;
                int real = (int) damage;
                if (real < 1) {
                    real = 1;
                }
                enemy.Hp = enemy.Hp - real >= 0 ? enemy.Hp - real : 0;
            }
        }
    }


    public void rest() {
        if (!(this.Hp == Integer.MAX_VALUE)) {
            this.Hp += 10;
        }

        for (int i = 0; i < list.size(); i++) {
            if (!(this.list.get(i).getCount() == Integer.MAX_VALUE)) {
                this.list.get(i).upCount();
            }
        }

    }
}
