package net.eno.chess;

import net.eno.pieces.Piece;
import net.eno.pieces.PieceType;
import static net.eno.utils.StringUtils.appendNewLine;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.ArrayList;


public class Board {

    private final List<List<Piece>> board;

    public Board() {
        this.board = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            this.board.add(new ArrayList<>());
        }
    }

    public void addPiece(int rank, Piece piece) {
        this.board.get(rank).add(piece);
    }

    public int pieceCount() {
        int pieceCount = 0;
        for (List<Piece> rank : this.board) {
            pieceCount += rank.size();
        }
        return pieceCount;
    }

    public void initialize() {
        List<PieceType> arrangeWhitePieceList = arrangeWhitePiece();
        List<PieceType> arrangeBlackPieceList = arrangeBlackPiece();
        for (int i = 0; i < 8; i++) {
            addPiece(0, Piece.createPiece(arrangeBlackPieceList.get(i)));
            addPiece(1, Piece.createPiece(PieceType.BLACK_PAWN));
            addPiece(2, Piece.createPiece(PieceType.WHITE_PAWN));
            addPiece(3, Piece.createPiece(arrangeWhitePieceList.get(i)));
        }
    }

    private List<PieceType> arrangeWhitePiece() {
        List<PieceType> arrangePieceList = new ArrayList<>();
        arrangePieceList.add(PieceType.WHITE_ROOK);
        arrangePieceList.add(PieceType.WHITE_KNIGHT);
        arrangePieceList.add(PieceType.WHITE_BISHOP);
        arrangePieceList.add(PieceType.WHITE_QUEEN);
        arrangePieceList.add(PieceType.WHITE_KING);
        arrangePieceList.add(PieceType.WHITE_BISHOP);
        arrangePieceList.add(PieceType.WHITE_KNIGHT);
        arrangePieceList.add(PieceType.WHITE_ROOK);
        return arrangePieceList;
    }

    private List<PieceType> arrangeBlackPiece() {
        List<PieceType> arrangePieceList = new ArrayList<>();
        arrangePieceList.add(PieceType.BLACK_ROOK);
        arrangePieceList.add(PieceType.BLACK_KNIGHT);
        arrangePieceList.add(PieceType.BLACK_BISHOP);
        arrangePieceList.add(PieceType.BLACK_QUEEN);
        arrangePieceList.add(PieceType.BLACK_KING);
        arrangePieceList.add(PieceType.BLACK_BISHOP);
        arrangePieceList.add(PieceType.BLACK_KNIGHT);
        arrangePieceList.add(PieceType.BLACK_ROOK);
        return arrangePieceList;
    }

    public String showBoard(String color) {
        checkColor(color);
        StringBuilder result = new StringBuilder();
        int num = color.equals("white") ? 0 : 3;

        result.append(appendNewLine(getPiecesResult(color, num)));
        result.append(appendNewLine(getPiecesResult(color, Math.abs(1 - num))));
        result.append(appendNewLine("........"));
        result.append(appendNewLine("........"));
        result.append(appendNewLine("........"));
        result.append(appendNewLine("........"));
        result.append(appendNewLine(getPiecesResult(color, Math.abs(2 - num))));
        result.append(appendNewLine(getPiecesResult(color, Math.abs(3 - num))));
        return result.toString();
    }

    private String getPiecesResult(String color, int rank) {
        checkColor(color);
        StringBuilder result = new StringBuilder();
        int num = color.equals("white") ? 0 : this.board.get(rank).size() - 1;

        for (int i = 0; i < this.board.get(rank).size(); i++) {
            result.append(findPiece(rank, Math.abs(i - num)).getRepresentation());
        }
        return result.toString();
    }

    private Piece findPiece(int rank, int file) {
        return this.board.get(rank).get(file);
    }

    private void checkColor(String color) {
        if (!color.equals("white") && !color.equals("black")) {
            throw new InvalidParameterException("Color error");
        }
    }

}
