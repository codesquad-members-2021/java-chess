package net.honux.chess.core;

import net.honux.chess.attribute.Color;
import net.honux.chess.attribute.Rank;
import net.honux.chess.attribute.Type;
import net.honux.chess.entity.pieces.Piece;

import java.util.ArrayList;
import java.util.Optional;

import static net.honux.chess.util.StringUtils.appendNewLine;
import static net.honux.chess.util.StringUtils.convertString;
import static net.honux.chess.attribute.Rank.*;
import static net.honux.chess.util.Position.*;

public class Board {

    public static final int BOARD_SIZE = 8;
    private ArrayList<Rank> board;

    public void initialize() {
        board = new ArrayList(BOARD_SIZE);
        board.add(createBlackPiecesExceptPawns());
        board.add(createBlackPawns());
        board.add(createBlankPieces());
        board.add(createBlankPieces());
        board.add(createBlankPieces());
        board.add(createBlankPieces());
        board.add(createWhitePawns());
        board.add(createWhitePiecesExceptPawns());
    }

    public void initializeEmpty() {
        board = new ArrayList(BOARD_SIZE);
        for(int i = 0; i < BOARD_SIZE; i++){
            board.add(createBlankPieces());
        }
    }

    public void move(String position, Piece piece) {
        board.get(getIndex(position)).putPiece(getRank(position), piece);
    }

    public int blackPiecesCount() {
        int countOfBlackPieces = 0;
        for (Rank RANK : board){
            countOfBlackPieces += RANK.countOfBlackPieces();
        }
        return countOfBlackPieces;
    }

    public int whitePiecesCount() {
        int countOfWhitePieces = 0;
        for (Rank RANK : board){
            countOfWhitePieces += RANK.countOfWhitePieces();
        }
        return countOfWhitePieces;
    }

    public int countOfPiece(Color color, Type type) {
        int countOfBlackPawns = 0;
        for(Rank rank : board) {
            countOfBlackPawns += rank.countOfPiece(color, type);
        }
        return countOfBlackPawns;
    }

    public Optional<Piece> findPiece(String position) {
        Optional<Piece> piece = Optional.empty();
        try {
            piece = Optional.ofNullable(board.get(getIndex(position)).get(getRank(position)));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
        return piece;
    }

    public String getBoardStatusToString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < BOARD_SIZE; i++){
            appendNewLine(sb, board.get(i).getString());
        }
        return convertString(sb);
    }

    public void print() {
        System.out.println(this.getBoardStatusToString());
    }

}
