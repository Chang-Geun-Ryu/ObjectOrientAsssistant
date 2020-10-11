package academy.pocu.comp2500.lab5;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Gladiator{
    public Knight(String name, int Hp, int attack, int defense) {
        super(name, Hp, attack, defense);
    }
    private List<Pet> list = new ArrayList<>();

    public void setPet(Pet pet) {
        list.add(pet);
    }

    public void attackTogether(Barbarian enemy) {
        double damage = (double)(this.attack + list.get(0).getAttack() - enemy.defense) / 2;
        int real = (int) damage;

        if (list.size() == 0) {
            real = 0;
        }
        enemy.Hp = enemy.Hp - real >= 0 ? enemy.Hp - real : 0;

    }

}
