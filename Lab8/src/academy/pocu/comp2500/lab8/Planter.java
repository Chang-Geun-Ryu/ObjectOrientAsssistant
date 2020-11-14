package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Planter {
    private int waterAmount;
    private ArrayList<Sprinkler> sprinklers = new ArrayList<>();
    private ArrayList<Drainer> drainers = new ArrayList<>();

    public Planter(int waterAmount) {
        this.waterAmount = waterAmount;
    }

    public int getWaterAmount() {
        return waterAmount;
    }

    public void installSmartDevice(Sprinkler sprinkler) {
        sprinklers.add(sprinkler);
    }

    public void installSmartDevice(Drainer drainer) {
        drainers.add(drainer);
    }

    public void addWater(int amount) {
        waterAmount += amount;

        if (waterAmount < 0) {
            waterAmount = 0;
        }
    }

    public void tick() {
        // on off 상태 업데이트
        for (Sprinkler sprinkler : sprinklers) {
            sprinkler.onTick();
        }

        for (Drainer drainer : drainers) {
            drainer.onTick();
            drainer.detect(waterAmount);
        }

        // 급수
        for (Sprinkler sprinkler : sprinklers) {
            sprinkler.spray(this);
        }

        // 배수
        for (Drainer drainer : drainers) {
            drainer.drain(this);
        }

        // 화분이 쓰는 물
        addWater(-2);
    }
}
