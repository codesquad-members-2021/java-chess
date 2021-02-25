package chess;

import pieces.Piece;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Piece> whitePawns = new ArrayList<>();
    private List<Piece> blackPawns = new ArrayList<>();
    private List<Piece> whitePieces = new ArrayList<>();
    private List<Piece> blackPieces = new ArrayList<>();

    private static final int PAWN_NUMBER = 8;

    public void addWhitePawn(Piece whitePawn) {
        whitePawns.add(whitePawn);
    }

    public void addBlackPawn(Piece blackPawn) {
        blackPawns.add(blackPawn);
    }

    public void initialize() {
        for (int i = 0; i < PAWN_NUMBER; i++) {
            addWhitePawn(Piece.createWhitePawn());
            addBlackPawn(Piece.createBlackPawn());
        }
        addWhitePieces();
        addBlackPieces();
    }

    public String bringBoard() {
        String dots = "........";
        StringBuilder sb = new StringBuilder();

        sb.append(StringUtils.appendNewLine(bringBlackPiecesRepresentation()));
        sb.append(StringUtils.appendNewLine(bringBlackPawnsRepresentation()));
        sb.append(StringUtils.appendNewLine(dots));
        sb.append(StringUtils.appendNewLine(dots));
        sb.append(StringUtils.appendNewLine(dots));
        sb.append(StringUtils.appendNewLine(dots));
        sb.append(StringUtils.appendNewLine(bringWhitePawnsRepresentation()));
        sb.append(StringUtils.appendNewLine(bringWhitePiecesRepresentation()));

        return sb.toString();
    }

    public int sizeOfPieces() {
        return whitePawns.size() +
                whitePieces.size() +
                blackPawns.size() +
                blackPieces.size();
    }

    private void addWhitePieces() {
        whitePieces.add(Piece.createWhiteRook());
        whitePieces.add(Piece.createWhiteKnight());
        whitePieces.add(Piece.createWhiteBishop());
        whitePieces.add(Piece.createWhiteQueen());
        whitePieces.add(Piece.createWhiteKing());
        whitePieces.add(Piece.createWhiteBishop());
        whitePieces.add(Piece.createWhiteKnight());
        whitePieces.add(Piece.createWhiteRook());
    }

    private void addBlackPieces() {
        blackPieces.add(Piece.createBlackRook());
        blackPieces.add(Piece.createBlackKnight());
        blackPieces.add(Piece.createBlackBishop());
        blackPieces.add(Piece.createBlackQueen());
        blackPieces.add(Piece.createBlackKing());
        blackPieces.add(Piece.createBlackBishop());
        blackPieces.add(Piece.createBlackKnight());
        blackPieces.add(Piece.createBlackRook());
    }

    private String bringWhitePawnsRepresentation() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < whitePawns.size(); i++) {
            sb.append(Piece.WHITE_PAWN_REPRESENTATION);
        }
        return sb.toString();
    }

    private String bringBlackPawnsRepresentation() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < blackPawns.size(); i++) {
            sb.append(Piece.BLACK_PAWN_REPRESENTATION);
        }
        return sb.toString();
    }

    private String bringWhitePiecesRepresentation() {
        StringBuilder sb = new StringBuilder();

        for (Piece whiteUnit : whitePieces) {
            sb.append(whiteUnit.getRepresentation());
        }
        return sb.toString();
    }

    private String bringBlackPiecesRepresentation() {
        StringBuilder sb = new StringBuilder();

        for (Piece blackUnit : blackPieces) {
            sb.append(blackUnit.getRepresentation());
        }
        return sb.toString();
    }
}
