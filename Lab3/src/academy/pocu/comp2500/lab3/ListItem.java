package academy.pocu.comp2500.lab3;

import java.util.ArrayList;
import java.util.Arrays;

final public class ListItem {
    private String text;
    private ArrayList<ListItem> sublistItems;
    private char bulletStyle;

    public ListItem(String text) {
        this.text = text;
        this.bulletStyle = '*';
        this.sublistItems = new ArrayList<>();
    }

    public ListItem(String text, char bulletStyle) {
        this(text);
        this.bulletStyle = bulletStyle;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setBulletStyle(char bulletStyle) {
        this.bulletStyle = bulletStyle;
    }
    public char getBulletStyle() {
        return this.bulletStyle;
    }

    public void addSublistItem(ListItem sublistItems) {
        this.sublistItems.add(sublistItems);
    }

    public void removeSublistItem(int index) {
        sublistItems.remove(index);
    }

    public ListItem getSublistItem(int index) {
        return this.sublistItems.get(index);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append(this.bulletStyle);
        s.append(" ");
        s.append(this.text);
        s.append(System.lineSeparator());
        sublistItems.forEach(e -> {
            String str = e.toString();
            ArrayList<String> ss = new ArrayList<String>(Arrays.asList(str.split(System.lineSeparator())));
//            System.out.println("<<<<<----");
            ss.forEach(c -> {
                s.append("    ");
                s.append(c);
                s.append(System.lineSeparator());
            });
//            System.out.println("---->>>>");
        });

        return s.toString();
    }
}
