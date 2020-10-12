package academy.pocu.comp2500.lab5;

public class Barbarian {
    private String name;
    protected int attack;
    protected int defense;
    protected int Hp;

    public Barbarian(String name, int Hp, int attack, int defense) {
        this.name = name;
        this.Hp = Hp;
        this.attack = attack;
        this.defense = defense;
    }

    public int getHp() {
        if (this.Hp < 0) {
            return 0;
        }
        return this.Hp;
    }

    public void attack(Barbarian enemy) {

        double amount = ((double)this.attack - (double)enemy.defense) / 2;
        int real = (int) amount;
        if (real < 1) {
            real = 1;
        } else if (this.Hp == 0) {
            real = 0;
        }
        if (this == enemy) {
            real = 0;
            enemy.Hp = enemy.Hp - real;
        }
        enemy.Hp = enemy.Hp - real >= 0 ? enemy.Hp - real : 0;

    }
    public boolean isAlive() {
        if (this.Hp == 0) {
            return false;
        } else {
            return true;
        }

    }
}
