package chess;

public enum Rank {
    EIGHT(0),
    SEVEN(1),
    SIX  (2),
    FIVE (3),
    FOUR (4),
    THREE(5),
    TWO  (6),
    ONE  (7);

    private final int index;

    Rank(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static Rank getByInt(int rank) {
        for (Rank r : Rank.values()) {
            if (r.getIndex() == 8 - rank) {
                return r;
            }
        }
        throw new IllegalArgumentException();
    }

}
