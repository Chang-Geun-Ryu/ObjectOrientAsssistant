package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Option extends Product {
    protected OrientationType orientation;
    private ArrayList<Aperture> apertures;
//    private int color;

//    protected Type type;

    protected Option(OrientationType orientation) {
        this.orientation = orientation;
        this.apertures = new ArrayList<>();
//        this.side = BusinessCardSide.SINGLE;
    }

//    public BusinessCardSide getSide() {
//        return this.side;
//    }

    public OrientationType getOrientation() {
        return this.orientation;
    }

//    protected void setSide(BusinessCardSide side) {
//        this.side = side;
//    }

    public void addAperture(Aperture aperture) {
        this.apertures.add(aperture);
        addPrice(aperture);
    }

    public ArrayList<Aperture> getApertures() {
        return this.apertures;
    }

    private void addPrice(Aperture aperture) {
        int w = this.orientation == OrientationType.LANDSCAPE ? this.width : this.height;
        int h = this.orientation == OrientationType.LANDSCAPE ? this.height : this.width;

        ArrayList<Integer> elements = aperture.getElements();
        int left = elements.get(0);
        int top = elements.get(1);
        int right = this.orientation == OrientationType.LANDSCAPE ? elements.get(2) : elements.get(3);
        int bottom = this.orientation == OrientationType.LANDSCAPE ? elements.get(3) : elements.get(2);

        right += left;
        bottom += bottom;

        if (aperture.getText().length() > 0) {
            // A: 0,0,w,h
            // B: left, top, right, bottom
            if (0 < right && w > left &&
                    0 < bottom && h > top) {
                super.setPrice(super.getPrice() + 5);
            } else {
                System.out.println("No Overlap");
            }
        }
    }
}

