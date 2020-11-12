package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public final class SimulationManager {
    private static SimulationManager SIMULATION_MANAGER = new SimulationManager();
    private int noSequence;
    private ArrayList<Unit> units;
    private ArrayList<Mine> mines;

    private SimulationManager() {
        this.noSequence = 0;
        this.units = new ArrayList<>();
        this.mines = new ArrayList<>();
    }

    public static SimulationManager getInstance() {
        return SIMULATION_MANAGER;
    }

    public ArrayList<Unit> getUnits() {
        return this.units;
    }

    public ArrayList<Mine> getMines() {
        return this.mines;
    }

    public void spawn(Unit unit) {
        unit.setNo(noSequence++);
        this.units.add(unit);
        if (unit.getSymbol() == 'N' || unit.getSymbol() == 'A') {
            this.mines.add((Mine) unit);
        }
        unit.onSpawn();
    }

    public void registerThinkable(IThinkable thinkable) {

    }

    public void registerMovable(IMovable movable) {

    }

    public void registerCollisionEventListener(Mine listener) {

    }

    public void update() {
        if (units.isEmpty()) {
            return;
        }
        ArrayList<AttackIntent> attackIntents = new ArrayList<>(units.size());
        for (Unit unit : units) {
            unit.setNowUsed(false);
            AttackIntent attackIntent = unit.attack();
            if (attackIntent != null) {
                unit.setNowUsed(true);
                attackIntents.add(attackIntent);
            }
        }
        ArrayList<MoveIntent> moveIntents = new ArrayList<>(units.size());
        for (Unit unit : units) {
            if (unit.isNowUsed() == false && unit.getUnitComponents().contains(UnitComponent.MOVABLE)) {
                MoveIntent moveIntent = ((IMovable) unit).move();
                if (moveIntent != null) {
                    moveIntents.add(moveIntent);
                }
            }
        }
        for (MoveIntent moveIntent : moveIntents) {
            moveIntent.execute();
            for (Mine mine : mines) {
                if (((Unit) moveIntent.getWho()).getPosition().getX() == mine.getPosition().getX() && ((Unit) moveIntent.getWho()).getPosition().getY() == mine.getPosition().getY()) {
                    mine.touch();
                }
            }
        }
        for (AttackIntent attackIntent : attackIntents) {
            attackIntent.execute();
        }
        ArrayList<Mine> willBeDeleted = new ArrayList<>(mines.size());
        for (Mine mine : mines) {
            if (units.contains(mine) == false) {
                willBeDeleted.add(mine);
                mines.remove(mine);
            }
        }
        for (Mine mine : willBeDeleted) {
            mines.remove(mine);
        }
    }
}