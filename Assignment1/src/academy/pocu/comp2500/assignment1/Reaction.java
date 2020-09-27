package academy.pocu.comp2500.assignment1;

public class Reaction {
    private String userId;
    private ReactionType reactionType;

    public enum ReactionType {
        GREAT,
        SAD,
        ANGRY,
        FUN,
        LOVE;
    }

    public Reaction(String userId, ReactionType reactionType) {
        this.userId = userId;
        this.reactionType = reactionType;
    }

    public String getUserId() {
        return this.userId;
    }

    public ReactionType getReactionType() {
        return this.reactionType;
    }
}
