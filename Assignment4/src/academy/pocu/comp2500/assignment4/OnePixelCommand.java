package academy.pocu.comp2500.assignment4;

public abstract class OnePixelCommand extends Command {
    protected int x;
    protected int y;

    public OnePixelCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
