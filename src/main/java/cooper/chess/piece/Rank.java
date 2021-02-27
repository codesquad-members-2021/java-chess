package cooper.chess.piece;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rank {
    public static final int RANK_SIZE = 8;
    private final List<Piece> pieceList;

    public Rank(List<Piece> pieceList) {
        this.pieceList = pieceList;
        Collections.unmodifiableList(pieceList);
    }

    public String getRankStatus() {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : pieceList) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }

    public int getPieceCount() {
        return (int) pieceList.stream()
                .filter(piece -> piece.getColor() != Color.NO_COLOR)
                .count();
    }

    public void addPiece(Piece piece, int column) {
        pieceList.set(column, piece);
    }

    public int getEachPieceCount(Color color, Type type) {
        return (int) pieceList.stream()
                .filter(piece -> piece.getColor() == color
                        && piece.getType() == type)
                .count();
    }

    public Piece findPiece(int xPos) {
        return pieceList.get(xPos);
    }

    public void initializeEmpty() {
        IntStream.range(0, RANK_SIZE).
                forEach(col -> pieceList.set(col, Piece.createBlank()));
    }
    
    public boolean hasPawnIn(int column, Color color) {
        Piece piece = pieceList.get(column);
        return (piece.getType() == Type.PAWN) &&
                (piece.getColor() == color);
    }

    public Piece getInColumn(int column) {
        return pieceList.get(column);
    }

    public List<Piece> getList(Color color) {
        return pieceList.stream()
                .filter(piece -> piece.getColor() == color)
                .collect(Collectors.toList());
    }
}
