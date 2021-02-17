package net.sky.chess;

import static net.sky.utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.List;

import net.sky.pieces.Color;
import net.sky.pieces.Piece;
import net.sky.pieces.PieceType;

public class Board {

    private List<Piece> whitePieces = new ArrayList<>();
    private List<Piece> blackPieces = new ArrayList<>();

    public void addWhitePawn(Piece piece) {
        whitePieces.add(piece);
    }

    public void addBlackPawn(Piece piece) {
        blackPieces.add(piece);
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            addWhitePawn(Piece.createPiece(Color.WHITE, PieceType.PAWN));
            addBlackPawn(Piece.createPiece(Color.BLACK, PieceType.PAWN));
        }
    }

    public String getWhitePawnsResult() {
        StringBuilder result = new StringBuilder();
        for (Piece piece : whitePieces) {
            result.append(piece.getRepresentation());
        }
        return result.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder result = new StringBuilder();
        for (Piece piece : blackPieces) {
            result.append(piece.getRepresentation());
        }
        return result.toString();
    }

    public void print() {
        String blankLine = "........";
        StringBuilder result = new StringBuilder();

        result.append(appendNewLine(blankLine));
        result.append(appendNewLine(getBlackPawnsResult()));
        result.append(appendNewLine(blankLine));
        result.append(appendNewLine(blankLine));
        result.append(appendNewLine(blankLine));
        result.append(appendNewLine(blankLine));
        result.append(appendNewLine(getWhitePawnsResult()));
        result.append(appendNewLine(blankLine));

        System.out.println(result);
    }
}
