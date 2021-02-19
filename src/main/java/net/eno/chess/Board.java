package net.eno.chess;

import net.eno.pieces.Piece;
import net.eno.pieces.Color;
import net.eno.pieces.PieceType;
import static net.eno.utils.StringUtils.appendNewLine;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public class Board {

    private final Map<String, Map<String, List<Piece>>> pieces;

    public Board() {
        this.pieces = new HashMap<>();
        this.pieces.put(Color.WHITE.toString(), new HashMap<String, List<Piece>>() {
            {
                put("pawn", new ArrayList<>());
                put("piece", new ArrayList<>());
            }
        });
        this.pieces.put(Color.BLACK.toString(), new HashMap<String, List<Piece>>() {
            {
                put("pawn", new ArrayList<>());
                put("piece", new ArrayList<>());
            }
        });
    }

    public void addPiece(Color color, Piece piece) {
        char representation = piece.getRepresentation();
        if (Character.toLowerCase(representation) == 'p') {
            this.pieces.get(color.toString()).get("pawn").add(piece);
        } else {
            this.pieces.get(color.toString()).get("piece").add(piece);
        }
    }

    public int pieceCount() {
        Map<String, List<Piece>> whitePieces = this.pieces.get(Color.WHITE.toString());
        Map<String, List<Piece>> blackPieces = this.pieces.get(Color.BLACK.toString());
        return whitePieces.get("pawn").size() +
                whitePieces.get("piece").size() +
                blackPieces.get("pawn").size() +
                blackPieces.get("piece").size();
    }

    public void initialize() {
        List<PieceType> arrangePieceList = arrangePiece();
        for (int i = 0; i < 8; i++) {
            addPiece(Color.WHITE, Piece.createPiece(Color.WHITE, arrangePieceList.get(i)));
            addPiece(Color.BLACK, Piece.createPiece(Color.BLACK, arrangePieceList.get(i)));
            addPiece(Color.WHITE, Piece.createPiece(Color.WHITE, PieceType.PAWN));
            addPiece(Color.BLACK, Piece.createPiece(Color.BLACK, PieceType.PAWN));
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

    public String showBoard() {
        StringBuilder result = new StringBuilder();
        result.append(appendNewLine(getPiecesResult(Color.BLACK, "piece")));
        result.append(appendNewLine(getPiecesResult(Color.BLACK, "pawn")));
        result.append(appendNewLine("........"));
        result.append(appendNewLine("........"));
        result.append(appendNewLine("........"));
        result.append(appendNewLine("........"));
        result.append(appendNewLine(getPiecesResult(Color.WHITE, "pawn")));
        result.append(appendNewLine(getPiecesResult(Color.WHITE, "piece")));
        return result.toString();
    }

    private String getPiecesResult(Color color, String piece) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.pieces.get(color.toString()).get(piece).size(); i++) {
            result.append(findPiece(color, piece, i).getRepresentation());
        }
        return result.toString();
    }

    private Piece findPiece(Color color, String piece, int index) {
        return this.pieces.get(color.toString()).get(piece).get(index);
    }

}
