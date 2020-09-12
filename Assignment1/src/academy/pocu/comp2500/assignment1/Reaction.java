/*
package academy.pocu.comp2500.assignment1;

public class Reaction {
    private boolean bGreat;
    private boolean bSad;
    private boolean bAngry;
    private boolean bFun;
    private boolean bLove;
    private String userId;

    public enum Type {
        GRATE,
        SAD,
        ANGRY,
        FUN,
        LOVE
    }

    public Reaction(Type type, String userId) {
        this.userId = userId;
        this.setStatus(type, true);
    }

    private void setStatus(Type type, boolean status) {
        switch (type) {
            case GRATE:
                this.bGreat = status;
                break;
            case SAD:
                this.bSad = status;
                break;
            case ANGRY:
                this.bAngry = status;
                break;
            case FUN:
                this.bFun = status;
                break;
            case LOVE:
                this.bLove = status;
                break;
            default:
                assert (true);
        }
    }

    public boolean isGreat() {
        return bGreat;
    }

    public boolean isSad() {
        return bSad;
    }

    public boolean isAngry() {
        return bAngry;
    }

    public boolean isFun() {
        return bFun;
    }

    public boolean isLove() {
        return bLove;
    }

    public String getUserId() {
        return this.userId;
    }
}
*/