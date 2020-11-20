package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;
import java.util.HashMap;

public final class StatusCanvas {
    private ArrayList<HashMap<Integer, Pixel>> status = new ArrayList<>();

    public void addStatus(HashMap<Integer, Pixel> info) {
        this.status.add(info);
    }

    public HashMap<Integer, Pixel> getStatus(int index) {
        if (this.status.size() <= index) {
            return null;
        }

        return this.status.get(index);
    }

    public void remove() {

    }
}
