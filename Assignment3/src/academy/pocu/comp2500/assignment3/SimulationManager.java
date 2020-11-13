package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public final class SimulationManager {
    public static SimulationManager simulationManager;
    private int noSequence;
    private ArrayList<Unit> units;
    private ArrayList<IMovable> movables;
    private ArrayList<IThinkable> thinkables;
    private ArrayList<ICollidable> collidables;

    private SimulationManager() {
        this.noSequence = 0;
        this.units = new ArrayList<>();
        this.movables = new ArrayList<>();
        this.thinkables = new ArrayList<>();
        this.collidables = new ArrayList<>();
    }

    public static SimulationManager getInstance() {
        if (simulationManager == null) {
            simulationManager = new SimulationManager();
        }
        return simulationManager;
    }

    public ArrayList<Unit> getUnits() {
        return this.units;
    }

    public void deathUnit(Unit unit) {
        unit.die();
        if (unit.getHp() <= 0) {
            units.remove(unit);
            movables.remove(unit);
            thinkables.remove(unit);
            collidables.remove(unit);
        }
    }

    public void spawn(Unit unit) {
        unit.setNo(noSequence++);
        this.units.add(unit);
        switch (unit.getSymbol()) {
            case 'M':
                Marine marine = (Marine) unit;
                registerMovable(marine);
                registerThinkable(marine);
                break;
            case 'T':
                Tank tank = (Tank) unit;
                registerMovable(tank);
                registerThinkable(tank);
                break;
            case 'W':
                Wraith wraith = (Wraith) unit;
                registerMovable(wraith);
                registerThinkable(wraith);
                break;
            case 'U':
                Turret turret = (Turret) unit;
                registerThinkable(turret);
                break;
            case 'N':
                Mine mine = (Mine) unit;
                registerCollisionEventListener(mine);
                break;
            case 'A':
                SmartMine smartMine = (SmartMine) unit;
                registerThinkable(smartMine);
                registerCollisionEventListener(smartMine);
                break;
            case 'D':
                Destroyer destroyer = (Destroyer) unit;
                registerThinkable(destroyer);
                break;
            default:
                assert (false) : "Invalid Unit Symbol! (" + unit.getSymbol() + ")";
                break;
        }
        unit.onSpawn();
    }

    public void registerThinkable(IThinkable thinkable) {
        this.thinkables.add(thinkable);
    }

    public void registerMovable(IMovable movable) {
        this.movables.add(movable);
    }

    public void registerCollisionEventListener(ICollidable listener) {
        this.collidables.add(listener);
    }

    public void update() {
        if (units.isEmpty()) {
            return;
        }
        ArrayList<AttackIntent> attackIntents = new ArrayList<>(units.size());
        for (IThinkable thinkable : thinkables) {
            Unit unit = (Unit) thinkable;
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
        }
        for (ICollidable collidable : collidables) {
            for (Unit unit : units) {
                if (unit != collidable && unit.getUnitType() == UnitType.GROUND && unit.getPosition().getX() == ((Unit) collidable).getPosition().getX() && unit.getPosition().getY() == ((Unit) collidable).getPosition().getY()) {
                    collidable.touch();
//                    Mine mine = (Mine) collidable;
//                    System.out.println(mine.getNo() + "가 밟혔다~: " + mine.touchCount);
                }
            }
        }
        ArrayList<ICollidable> cloneCollidables = new ArrayList<>(collidables);
        for (AttackIntent attackIntent : attackIntents) {
            attackIntent.execute();
        }
        attackIntents.clear();
        for (ICollidable collidable : cloneCollidables) {
            Mine mine = (Mine) collidable;
            if (mine.getSymbol() == 'A' && ((SmartMine) mine).isActivated() == true) {
                continue;
            }
            AttackIntent attackIntent = collidable.collide();
            if (attackIntent != null) {
                attackIntents.add(attackIntent);
            }
        }
        for (AttackIntent attackIntent : attackIntents) {
            attackIntent.execute();
        }
//        for (Unit unit : units) {
//            if (unit.getSymbol() == 'T') {
//                Tank tank = (Tank) unit;
//                if (tank.isChangeMoveMode() == true) {
//                    tank.changeMode();
//                }
//            }
//        }
    }
}