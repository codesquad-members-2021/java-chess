package chess;

import chess.pieces.Color;
import chess.pieces.Piece;
import chess.pieces.Type;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int BOARDSIZE = 8;
    private final List<Piece> whitePieces = new ArrayList<>();
    private final List<Piece> blackPieces = new ArrayList<>();

    public void addWhitePieces(Piece piece) {
        if (piece.getColorName().equals(Color.WHITE.getColorName())) {
            whitePieces.add(piece);
            return;
        }
        System.out.println("알 수 없는 color의 piece입니다.");
        System.out.println("add에 실패하였습니다.");
    }

    public void addBlackPieces(Piece piece) {
        if (piece.getColorName().equals(Color.BLACK.getColorName())) {
            blackPieces.add(piece);
            return;
        }
        System.out.println("알 수 없는 color의 piece입니다.");
        System.out.println("add에 실패하였습니다.");
    }

    public int totalPiecesCount() {
        return whitePieces.size() + blackPieces.size();
    }

    public String getWhitePiecesResult() {
        return getPawnsResult(Color.WHITE);
    }

    public String getBlackPiecesResult() {
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
        initializeBlackPieces();
        initializeWhitePieces();
    }

    private void initializeWhitePieces() {
        for (int i = 0; i < BOARDSIZE; i++) {
            addWhitePieces(Piece.createWhitePawn());
        }

        addWhitePieces(Piece.createWhiteRook());
        addWhitePieces(Piece.createWhiteKnight());
        addWhitePieces(Piece.createWhiteBishop());
        addWhitePieces(Piece.createWhiteQueen());
        addWhitePieces(Piece.createWhiteKing());
        addWhitePieces(Piece.createWhiteBishop());
        addWhitePieces(Piece.createWhiteKnight());
        addWhitePieces(Piece.createWhiteRook());
    }

    private void initializeBlackPieces() {

        addBlackPieces(Piece.createBlackRook());
        addBlackPieces(Piece.createBlackKnight());
        addBlackPieces(Piece.createBlackBishop());
        addBlackPieces(Piece.createBlackQueen());
        addBlackPieces(Piece.createBlackKing());
        addBlackPieces(Piece.createBlackBishop());
        addBlackPieces(Piece.createBlackKnight());
        addBlackPieces(Piece.createBlackRook());

        for (int i = 0; i < BOARDSIZE; i++) {
            addBlackPieces(Piece.createBlackPawn());
        }

    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();

        sb.append(StringUtils.addNewLine(getBlackPiecesResult()));

        String BLANK = "........";
        sb.append(StringUtils.addNewLine(BLANK));
        sb.append(StringUtils.addNewLine(BLANK));
        sb.append(StringUtils.addNewLine(BLANK));
        sb.append(StringUtils.addNewLine(BLANK));

        sb.append(StringUtils.addNewLine(getWhitePiecesResult()));

        return sb.toString();
    }
}
