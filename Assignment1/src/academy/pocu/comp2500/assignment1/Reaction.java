package academy.pocu.comp2500.assignment1;

public enum Reaction {
    GREAT("최고!(Great)", 0),
    SAD("슬퍼요!(Sad)", 1),
    ANGRY("화나요!(Angry)", 2),
    FUN("잼나요!(Fun)", 3),
    LOVE("사랑해요(Love)", 4);

    private final String reactionType;
    private final int reactionId;

    Reaction(String reactionType, int reactionId) {
        this.reactionType = reactionType;
        this.reactionId = reactionId;
    }

    public String getReactionType() {
        return reactionType;
    }

    public int getReactionId() {
        return reactionId;
    }


}
