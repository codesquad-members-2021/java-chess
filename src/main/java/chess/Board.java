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

        sb.append(StringUtils.appendNewLine(bringUnitRepresentation(blackPieces)));
        sb.append(StringUtils.appendNewLine(bringUnitRepresentation(blackPawns)));
        sb.append(StringUtils.appendNewLine(dots));
        sb.append(StringUtils.appendNewLine(dots));
        sb.append(StringUtils.appendNewLine(dots));
        sb.append(StringUtils.appendNewLine(dots));
        sb.append(StringUtils.appendNewLine(bringUnitRepresentation(whitePawns)));
        sb.append(StringUtils.appendNewLine(bringUnitRepresentation(whitePieces)));

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

    private String bringUnitRepresentation(List<Piece> unitList ){
        StringBuilder sb = new StringBuilder();

        for(Piece unit: unitList){
            sb.append(unit.getRepresentation());
        }
        return sb.toString();
    }
}
