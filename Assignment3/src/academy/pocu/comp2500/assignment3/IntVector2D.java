package academy.pocu.comp2500.assignment3;

public class IntVector2D {
    private int x;
    private int y;

    public IntVector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public IntVector2D(IntVector2D other) {
        this.x = other.x;
        this.y = other.y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDistance(IntVector2D other) {
        if (this == other) {
            return 0;
        }
        int distanceY = Math.abs(this.y - other.y);
        int distanceX = Math.abs(this.x - other.x);
        return Math.max(distanceX, distanceY);
    }
}