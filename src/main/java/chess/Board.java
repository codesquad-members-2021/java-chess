package chess;

import chess.pieces.Color;
import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Piece> whitePieces = new ArrayList<>();
    private final List<Piece> blackPieces = new ArrayList<>();

    public static final int BOARDSIZE = 8;
    private final String BLANK = "........";

    public void addWhitePawn(Piece piece) {
        if (piece.getColorName().equals(Color.WHITE.getColorName())) {
            whitePieces.add(piece);
        } else {
            System.out.println("알 수 없는 color의 pawn입니다.");
            System.out.println("add에 실패하였습니다.");
        }
    }

    public void addBlackPawn(Piece piece) {
        if (piece.getColorName().equals(Color.BLACK.getColorName())) {
            blackPieces.add(piece);
        } else {
            System.out.println("알 수 없는 color의 pawn입니다.");
            System.out.println("add에 실패하였습니다.");
        }
    }

    public int whitePawnSize() {
        return whitePieces.size();
    }

    public int blackPawnSize() {
        return blackPieces.size();
    }

    public Piece getWhitePawn(int index) {
        return whitePieces.get(index);
    }

    public Piece getBlackPawn(int index) {
        return blackPieces.get(index);
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(Color.WHITE);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(Color.BLACK);
    }

    private String getPawnsResult(Color color) {
        StringBuilder sb = new StringBuilder();
        switch (color) {
            case WHITE:
                for (Piece piece : whitePieces) {
                    sb.append(piece.getRepresentation());
                }
                return sb.toString();

            case BLACK:
                for (Piece piece : blackPieces) {
                    sb.append(piece.getRepresentation());
                }
                return sb.toString();

            default:
                return "";
        }
    }

    public void initialize() {
        for (int i = 0; i < BOARDSIZE; i++) {
            addWhitePawn(new Piece(Color.WHITE));
            addBlackPawn(new Piece(Color.BLACK));
        }
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();

        final int blackPawnIndex = 1;
        final int whitePawnIndex = 6;

        for (int i = 0; i < BOARDSIZE; i++) {
            switch (i) {
                case blackPawnIndex:
                    sb.append(getBlackPawnsResult());
                    break;
                case whitePawnIndex:
                    sb.append(getWhitePawnsResult());
                    break;

                default:
                    sb.append(BLANK);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
