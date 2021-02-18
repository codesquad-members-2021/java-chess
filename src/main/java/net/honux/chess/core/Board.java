package net.honux.chess.core;

import net.honux.chess.attribute.Color;
import net.honux.chess.entity.pieces.Piece;
import net.honux.chess.util.PieceList;
import net.honux.chess.util.StringUtils;

import java.util.Optional;

import static net.honux.chess.entity.pieces.Piece.*;
import static net.honux.chess.util.StringUtils.appendNewLine;
import static net.honux.chess.util.StringUtils.convertString;

public class Board {

    public static final int BOARD_SIZE = 8;
    private static final String BLANK = "********";
    private static final int initialSpaceInterval = 4;
    private PieceList whitePieceList;
    private PieceList blackPieceList;

    public void initialize() {
        whitePieceList = new PieceList();
        blackPieceList = new PieceList();
        addPiecesToBoardSize();
    }

    public void add(Piece piece) {
        getListByColor(piece).add(piece);
    }

    public int whitePawnSize() {
        return whitePieceList.size();
    }

    public int blackPawnSize() {
        return blackPieceList.size();
    }

    public Optional<Piece> findWhitePawn(int index) {
        Optional<Piece> pawn = Optional.empty();
        try {
            pawn = Optional.ofNullable(whitePieceList.get(index));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
        return pawn;
    }

    public Optional<Piece> findBlackPawn(int index) {
        Optional<Piece> pawn = Optional.empty();
        try {
            pawn = Optional.ofNullable(blackPieceList.get(index));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
        return pawn;
    }

    public String getWhitePawnsResult() {
        return whitePieceList.getStringPiecesList(0, 7);
    }

    public String getBlackPawnsResult() {
        return blackPieceList.getStringPiecesList(8, 15);
    }

    public String getBlackPiecesExceptPawns() {
        return blackPieceList.getStringPiecesList(0, 7);
    }

    public String getWhitePiecesExceptPawns() {
        return whitePieceList.getStringPiecesList(8, 15);
    }

    public String getBoardStatusToString() {
        appendNewLine(getBlackPiecesExceptPawns());
        appendNewLine(getBlackPawnsResult());
        for (int i = 0; i < initialSpaceInterval; i++) {
            appendNewLine(BLANK);
        }
        appendNewLine(getWhitePawnsResult());
        appendNewLine(getWhitePiecesExceptPawns());
        return convertString();
    }

    public void print() {
        StringUtils.init();
        System.out.println(this.getBoardStatusToString());
    }

    private void addPiecesToBoardSize() {
        setBlackPiecesExceptPawns();
        for (int i = 0; i < BOARD_SIZE; i++) {
            blackPieceList.add(createBlackPawn());
            whitePieceList.add(createWhitePawn());
        }
        setWhitePiecesExceptPawns();
    }

    private void setWhitePiecesExceptPawns() {
        whitePieceList.add(createWhiteRook()).add(createWhiteKnight())
                .add(createWhiteBishop()).add(createWhiteQueen()).add(createWhiteKing())
                .add(createWhiteBishop()).add(createWhiteKnight()).add(createWhiteRook());
    }

    private void setBlackPiecesExceptPawns() {
        blackPieceList.add(createBlackRook()).add(createBlackKnight())
                .add(createBlackBishop()).add(createBlackQueen()).add(createBlackKing())
                .add(createBlackBishop()).add(createBlackKnight()).add(createBlackRook());
    }

    private PieceList getListByColor(Piece piece) {
        if (piece.getColor() == Color.BLACK) {
            return blackPieceList;
        }
        return whitePieceList;
    }

}
