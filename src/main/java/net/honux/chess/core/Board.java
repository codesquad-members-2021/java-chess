package net.honux.chess.core;

import net.honux.chess.entity.pieces.Piece;

import java.util.Optional;

import static net.honux.chess.entity.pieces.Piece.*;
import static net.honux.chess.util.StringUtils.appendNewLine;
import static net.honux.chess.util.StringUtils.convertString;

public class Board {

    public static final int BOARD_SIZE = 8;
    private Pieces whitePieces;
    private Pieces whitePawns;
    private Pieces blackPieces;
    private Pieces blackPawns;

    public void initialize() {
        blackPieces = Pieces.createBlackPiecesExceptPawns();
        blackPawns = Pieces.createBlackPawns();
        whitePawns = Pieces.createWhitePawns();
        whitePieces = Pieces.createWhitePiecesExceptPawns();
    }

    public Pieces getWhitePieces() {
        return whitePieces;
    }

    public Pieces getWhitePawns() {
        return whitePawns;
    }

    public Pieces getBlackPieces() {
        return blackPieces;
    }

    public Pieces getBlackPawns() {
        return blackPawns;
    }

    public int whitePawnSize() {
        return whitePieces.size() + whitePawns.size();
    }

    public int blackPawnSize() {
        return blackPieces.size() + blackPawns.size();
    }

    public Optional<Piece> findWhitePawn(int index) {
        Optional<Piece> pawn = Optional.empty();
        try {
            pawn = Optional.ofNullable(whitePawns.get(index));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
        return pawn;
    }

    public Optional<Piece> findWhitePiece(int index) {
        Optional<Piece> pawn = Optional.empty();
        try {
            pawn = Optional.ofNullable(whitePieces.get(index));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
        return pawn;
    }

    public Optional<Piece> findBlackPawn(int index) {
        Optional<Piece> pawn = Optional.empty();
        try {
            pawn = Optional.ofNullable(blackPawns.get(index));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
        return pawn;
    }

    public Optional<Piece> findBlackPiece(int index) {
        Optional<Piece> pawn = Optional.empty();
        try {
            pawn = Optional.ofNullable(blackPieces.get(index));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
        return pawn;
    }

    public String getBoardStatusToString() {
        final String BLANK = "********";
        final int initialSpaceInterval = 4;
        StringBuilder sb = new StringBuilder();
        appendNewLine(sb, getStringPiecesResult(blackPieces));
        appendNewLine(sb, getStringPiecesResult(blackPawns));
        for (int i = 0; i < initialSpaceInterval; i++) {
            appendNewLine(sb, BLANK);
        }
        appendNewLine(sb, getStringPiecesResult(whitePawns));
        appendNewLine(sb, getStringPiecesResult(whitePieces));
        return convertString(sb);
    }

    public void print() {
        System.out.println(this.getBoardStatusToString());
    }

    private String getStringPiecesResult(Pieces pieces) {
        return pieces.getString();
    }

}
