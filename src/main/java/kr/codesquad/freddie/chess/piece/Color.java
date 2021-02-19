package kr.codesquad.freddie.chess.piece;

public enum Color {
    WHITE(1, 2) {
        @Override
        String getRepresentationBy(String representation) {
            return representation.toLowerCase();
        }
    }, BLACK(8, 7) {
        @Override
        String getRepresentationBy(String representation) {
            return representation.toUpperCase();
        }
    }, NOCOLOR(-1, -1) {
        @Override
        String getRepresentationBy(String representation) {
            return Kind.EMPTY.representation;
        }
    };

    private final int royalInitializationRank;
    private final int pawnInitializationRank;

    Color(int royalInitializationRank, int pawnInitializationRank) {
        this.royalInitializationRank = royalInitializationRank;
        this.pawnInitializationRank = pawnInitializationRank;
    }

    abstract String getRepresentationBy(String representation);

    public int royalInitializationRank() {
        return royalInitializationRank;
    }

    public int pawnInitializationRank() {
        return pawnInitializationRank;
    }
}
