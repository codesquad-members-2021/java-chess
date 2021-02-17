package kr.codesquad.freddie.chess.piece;

public enum Color {
    WHITE {
        @Override
        String getRepresentationBy(String representation) {
            return representation.toLowerCase();
        }
    }, BLACK {
        @Override
        String getRepresentationBy(String representation) {
            return representation.toUpperCase();
        }
    };

    abstract String getRepresentationBy(String representation);
}
