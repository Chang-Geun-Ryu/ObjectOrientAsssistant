package academy.pocu.comp2500.assignment3;

public class MoveIntent {
    private IMovable who;
    private IntVector2D will;

    public MoveIntent(IMovable who, IntVector2D will) {
        this.who = who;
        this.will = will;
    }

    public IMovable getWho() {
        return who;
    }

    public void execute() {
        ((Unit) who).setPosition(this.will);
    }
}
