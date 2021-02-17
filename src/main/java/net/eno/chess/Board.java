package net.eno.chess;

import net.eno.pieces.Piece;
import net.eno.pieces.Color;
import net.eno.pieces.Representation;
import static net.eno.utils.StringUtils.appendNewLine;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public class Board {

    private final Map<String, List<Piece>> pieces;

    public Board() {
        this.pieces = new HashMap<>();
        this.pieces.put(Color.WHITE.toString(), new ArrayList<>());
        this.pieces.put(Color.BLACK.toString(), new ArrayList<>());
    }

    public void addPiece(Color color, Piece piece) {
        this.pieces.get(color.toString()).add(piece);
    }

    public int pieceSize(Color color) {
        return this.pieces.get(color.toString()).size();
    }

    public Piece findPiece(Color color, int index) {
        return this.pieces.get(color.toString()).get(index);
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            addPiece(Color.WHITE, Piece.createPiece(Color.WHITE, Representation.PAWN));
            addPiece(Color.BLACK, Piece.createPiece(Color.BLACK, Representation.PAWN));
        }
    }

    public String getPiecesResult(Color color) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < pieceSize(color); i++) {
            result.append(findPiece(color, i).getRepresentation());
        }
        return result.toString();
    }

    public void print() {
        System.getProperty("line.separator");
        StringBuilder result = new StringBuilder();
        result.append(appendNewLine("........"));
        result.append(appendNewLine(getPiecesResult(Color.BLACK)));
        result.append(appendNewLine("........"));
        result.append(appendNewLine("........"));
        result.append(appendNewLine("........"));
        result.append(appendNewLine("........"));
        result.append(appendNewLine(getPiecesResult(Color.WHITE)));
        result.append(appendNewLine("........"));
        System.out.println(result);
    }

}
