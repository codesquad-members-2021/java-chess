package kr.codesquad.freddie.chess.piece;

public enum Color {
    WHITE(7, 6) {
        @Override
        String getRepresentationBy(String representation) {
            return representation.toLowerCase();
        }
    }, BLACK(0, 1) {
        @Override
        String getRepresentationBy(String representation) {
            return representation.toUpperCase();
        }
    };

    private int royalInitializationRank;
    private int pawnInitializationRank;

    Color(int royalInitializationRank, int pawnInitializationRank) {
        this.royalInitializationRank = royalInitializationRank;
        this.pawnInitializationRank = pawnInitializationRank;
    }

    abstract String getRepresentationBy(String representation);

    public int getRoyalInitializationRank() {
        return royalInitializationRank;
    }

    public int getPawnInitializationRank() {
        return pawnInitializationRank;
    }
}
