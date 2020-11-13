package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public final class SimulationManager {

    private static SimulationManager instance = null;
    private ArrayList<Unit> units = new ArrayList<>();
    private ArrayList<IThinkable> thinkableUnits = new ArrayList<>();
    private ArrayList<IMoveable> moveableUnits = new ArrayList<>();
    private ArrayList<ICollideable> collideableUnits = new ArrayList<>();

    public static SimulationManager getInstance() {
        if (instance == null) {
            instance = new SimulationManager();
        }
        return instance;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public ArrayList<IThinkable> getThinkableUnits() {
        return thinkableUnits;
    }

    public ArrayList<IMoveable> getMoveableUnits() {
        return moveableUnits;
    }

    public void spawn(Unit unit) {
        unit.onSpawn();
        units.add(unit);
    }

    public void registerThinkable(IThinkable thinkable) {
        thinkableUnits.add(thinkable);
    }

    public void registerMovable(IMoveable movable) {
        moveableUnits.add(movable);
    }

    public void registerCollisionEventListener(ICollideable listener) {
        collideableUnits.add(listener);
    }

    public void update() {
        //각 유닛들이 이번 프레임에서 할 행동(선택지: 공격, 이동, 아무것도 안 함)을 결정
        for (IThinkable unit : thinkableUnits) {
            unit.think();
        }
        //움직일 수 있는 각 유닛에게 이동할 기회를 줌
        for (IMoveable unit : moveableUnits) {
            unit.move();
        }
        //이동 후 충돌 처리
        for (ICollideable unit : collideableUnits) {
            unit.collided();
        }
        //각 유닛에게 공격할 기회를 줌
        //피해를 입어야 하는 각 유닛에게 피해를 입힘
        for (Unit unit : units) {
            AttackIntent ai = unit.attack();
            if (ai == null) {
                continue;
            }
            ai.executeAttack();
        }
        //죽은 유닛들을 모두 게임에서 제거함
        for (int i = 0; i < units.size(); i++) {
            if (units.get(i).getHp() < 0) {
                thinkableUnits.remove(units.get(i));
                moveableUnits.remove(units.get(i));
                collideableUnits.remove(units.get(i));
                if (units.remove(units.get(i))) {
                    i--;
                }
            }
        }
    }
}