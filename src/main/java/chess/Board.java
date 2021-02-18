package chess;

import pieces.Piece;

import static utils.StringUtils.*;

public class Board {

    private final Piece[] pieceList;
    private int size;

    private final int ROWS = 4;
    private final int FILES = 8;

    public Board() {
        this.pieceList = new Piece[ROWS * FILES];
        this.size = 0;
    }

    private void initBlackPawns() {
        for (int i = 0; i < FILES; i++) {
            pieceList[1 * FILES + i] = Piece.createBlackPawn();
        }
        size += FILES;
    }

    private void initWhitePawns() {
        for (int i = 0; i < FILES; i++) {
            pieceList[2 * FILES + i] = Piece.createWhitePawn();
        }
        size += FILES;
    }

    private void initBlackPieces() {
        pieceList[0] = Piece.createBlackRook();
        pieceList[1] = Piece.createBlackKnight();
        pieceList[2] = Piece.createBlackBishop();
        pieceList[3] = Piece.createBlackQueen();
        pieceList[4] = Piece.createBlackKing();
        pieceList[5] = Piece.createBlackBishop();
        pieceList[6] = Piece.createBlackKnight();
        pieceList[7] = Piece.createBlackRook();
        size += FILES;
    }

    private void initWhitePieces() {
        pieceList[3 * FILES    ] = Piece.createWhiteRook();
        pieceList[3 * FILES + 1] = Piece.createWhiteKnight();
        pieceList[3 * FILES + 2] = Piece.createWhiteBishop();
        pieceList[3 * FILES + 3] = Piece.createWhiteQueen();
        pieceList[3 * FILES + 4] = Piece.createWhiteKing();
        pieceList[3 * FILES + 5] = Piece.createWhiteBishop();
        pieceList[3 * FILES + 6] = Piece.createWhiteKnight();
        pieceList[3 * FILES + 7] = Piece.createWhiteRook();
        size += FILES;
    }

    private String getPiecesResult(int row) {
        StringBuilder pieceResult = new StringBuilder();
        for (int file = 0; file < FILES; file++) {
            int index = row * FILES + file;
            if (pieceList[index] != null) {
                pieceResult.append(pieceList[index].getRepresentation());
                continue;
            }
            pieceResult.append('.');
        }
        return pieceResult.toString();
    }

    public void initialize() {
        initBlackPieces();
        initBlackPawns();
        initWhitePawns();
        initWhitePieces();
    }

    public String showBoard() {
        StringBuilder output = new StringBuilder();
        String blankRank = appendNewLine("........");
        output.append(appendNewLine(getPiecesResult(0)));
        output.append(appendNewLine(getPiecesResult(1)));
        output.append(blankRank).append(blankRank).append(blankRank).append(blankRank);
        output.append(appendNewLine(getPiecesResult(2)));
        output.append(appendNewLine(getPiecesResult(3)));
        return output.toString();
    }

    public int pieceCount() {
        return size;
    }

}
