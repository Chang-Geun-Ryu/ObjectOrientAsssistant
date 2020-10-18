package academy.pocu.comp2500.assignment2;

import java.util.Objects;

public class RGB {
    private int r, g, b;
    public RGB(int r, int g, int b) {
        this.r = Math.min(Math.max(0, r), 0xff);
        this.g = Math.min(Math.max(0, g), 0xff);
        this.b = Math.min(Math.max(0, b), 0xff);
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        RGB rgb = (RGB) o;
//        return r == rgb.r &&
//                g == rgb.g &&
//                b == rgb.b;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(r, g, b);
//    }
}
