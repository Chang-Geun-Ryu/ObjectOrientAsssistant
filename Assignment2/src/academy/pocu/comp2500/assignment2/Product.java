package academy.pocu.comp2500.assignment2;

public class Product {
    protected String displayName;
    //protected int width;
    //protected int height;
    //protected int color;
    protected int price;
    protected Shipment delivery;
    protected RGB color;
    protected Size size;

    public String getDisplayName() {
        return displayName;
    }

    public Size getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

//    public int getColor() {
//        return color;
//    }


    public RGB getColor() {
        return color;
    }

    protected Product() {
        //shipment = Shipment.PICKUP;
        delivery = Shipment.PICKUP;
    }
//
//    public Shipment getShipment() {
//        return shipment;
//    }
//
//    public void setShipment(Shipment shipment) {
//        if (shipment == null) {
//            return;
//        }
//        this.shipment = shipment;
//    }


    public Shipment getDelivery() {
        return delivery;
    }

    public void setDelivery(Shipment delivery) {
        this.delivery = delivery;
    }
}
