package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class Unit {
    private int no;
    protected char symbol;
    protected UnitType unitType;
    protected int vision;
    protected int aoe;
    protected int ap;
    protected int hp;
    protected HashSet<UnitType> attackableTypes;
    protected IntVector2D position;
    protected ArrayList<UnitComponent> unitComponents;
    protected boolean nowUsed;
    protected double multipliedDamage;

    protected Unit(char symbol, UnitType unitType, int vision, int aoe, int ap, int hp, IntVector2D position) {
        this.symbol = symbol;
        this.unitType = unitType;
        this.vision = vision;
        this.aoe = aoe;
        this.ap = ap;
        this.hp = hp;
        this.position = new IntVector2D(position);
        this.attackableTypes = new HashSet<>();
        this.unitComponents = new ArrayList<>();
        this.nowUsed = false;
        this.multipliedDamage = 1.0;
    }

    public IntVector2D getPosition() {
        return this.position;
    }

    public int getHp() {
        return this.hp;
    }

    public abstract AttackIntent attack();

    public void onAttacked(int damage) {
        if (damage >= this.hp) {
            this.hp = 0;
            SimulationManager simulationManager = SimulationManager.getInstance();
            simulationManager.getUnits().remove(this);
        } else {
            this.hp -= damage;
        }
    }

    public void onSpawn() {
    }

    public char getSymbol() {
        return this.symbol;
    }

    public int getNo() {
        return this.no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public UnitType getUnitType() {
        return this.unitType;
    }

    public ArrayList<UnitComponent> getUnitComponents() {
        return this.unitComponents;
    }

    public HashSet<UnitType> getAttackableTypes() {
        return this.attackableTypes;
    }

    public double getMultipliedDamage() {
        return this.multipliedDamage;
    }

    public boolean isNowUsed() {
        return this.nowUsed;
    }

    public void setNowUsed(boolean nowUsed) {
        this.nowUsed = nowUsed;
    }

    public void setPosition(IntVector2D position) {
        this.position = position;
    }
}