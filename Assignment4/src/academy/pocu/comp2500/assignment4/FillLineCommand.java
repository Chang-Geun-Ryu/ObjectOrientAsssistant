package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public abstract class FillLineCommand extends Command {
    protected char character;
    protected int vector;
    protected ArrayList<Character> characters;

    public FillLineCommand(int vector, char character) {
        this.vector = vector;
        this.character = character;
        this.characters = new ArrayList<>();
    }
}
