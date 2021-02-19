package net.eno.chess;

import net.eno.pieces.Piece;
import net.eno.pieces.Color;
import net.eno.pieces.PieceType;
import static net.eno.utils.StringUtils.appendNewLine;

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
        List<PieceType> arrangePieceList = arrangePiece();
        for (int i = 0; i < 8; i++) {
            addPiece(0 , Piece.createPiece(Color.BLACK, arrangePieceList.get(i)));
            addPiece(1, Piece.createPiece(Color.BLACK, PieceType.PAWN));
            addPiece(2, Piece.createPiece(Color.WHITE, PieceType.PAWN));
            addPiece(3, Piece.createPiece(Color.WHITE, arrangePieceList.get(i)));
        }
    }

    private List<PieceType> arrangePiece() {
        List<PieceType> arrangePieceList = new ArrayList<>();
        arrangePieceList.add(PieceType.ROOK);
        arrangePieceList.add(PieceType.KNIGHT);
        arrangePieceList.add(PieceType.BISHOP);
        arrangePieceList.add(PieceType.QUEEN);
        arrangePieceList.add(PieceType.KING);
        arrangePieceList.add(PieceType.BISHOP);
        arrangePieceList.add(PieceType.KNIGHT);
        arrangePieceList.add(PieceType.ROOK);
        return arrangePieceList;
    }

    public String showBoard(Color color) {
        StringBuilder result = new StringBuilder();
        int num = color.equals(Color.WHITE) ? 0 : 3;

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

    private String getPiecesResult(Color color, int rank) {
        StringBuilder result = new StringBuilder();
        int num = color.equals(Color.WHITE) ? 0 : this.board.get(rank).size() - 1;

        for (int i = 0; i < this.board.get(rank).size(); i++) {
            result.append(findPiece(rank, Math.abs(i - num)).getRepresentation());
        }
        return result.toString();
    }

    private Piece findPiece(int rank, int file) {
        return this.board.get(rank).get(file);
    }

}
