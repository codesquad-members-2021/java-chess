package chess;

import pieces.Piece;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.appendNewLine;

public class Board {
    private static final int BOARD_FILE = 8;

    private List<Piece> whitePieces = new ArrayList<>();
    private List<Piece> whitePawns = new ArrayList<>();
    private List<Piece> blackPawns = new ArrayList<>();
    private List<Piece> blackPieces = new ArrayList<>();

    void addWhitePawn(Piece piece) {
        if (piece.getColor() != Piece.Color.WHITE || piece.getType() != Piece.Type.PAWN) {
            throw new InvalidParameterException("흰색의 pawn만 추가할 수 있습니다.");
        }
        whitePawns.add(piece);
    }

    void addBlackPawn(Piece piece) {
        if (piece.getColor() != Piece.Color.BLACK || piece.getType() != Piece.Type.PAWN) {
            throw new InvalidParameterException("검은색의 pawn만 추가할 수 있습니다");
        }
        blackPawns.add(piece);
    }

    void addWhitePiece(Piece piece) {
        if (piece.getColor() != Piece.Color.WHITE){
            throw new InvalidParameterException("흰색의 piece만 추가할 수 있습니다");
        }

        whitePieces.add(piece);
    }

    void addBlackPiece(Piece piece) {
        if (piece.getColor() != Piece.Color.BLACK){
            throw new InvalidParameterException("검은색의 piece만 추가할수 있습니다");
        }
        blackPieces.add(piece);
    }

    public int pieceCount() {
        return whitePieces.size() +
                whitePawns.size() +
                blackPawns.size() +
                blackPieces.size();
    }

    public String getWhitePiecesResult() {
        return getPiecesResult(whitePieces);
    }

    public String getBlackPiecesResult() {
        return getPiecesResult(blackPieces);
    }

    public String getWhitePawnsResult() {
        return getPiecesResult(whitePawns);
    }

    public String getBlackPawnsResult() {
        return getPiecesResult(blackPawns);
    }

    private String getPiecesResult(List<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        for (char representation : getRepresentations(pieces)) {
            sb.append(representation);
        }
        return sb.toString();
    }

    private char[] getRepresentations(List<Piece> pieces) {
        char[] representations = new char[pieces.size()];
        for (int i = 0; i < pieces.size(); i++) {
            representations[i] = pieces.get(i).getRepresentation();
        }
        return representations;
    }

    public void initialize() {
        addWhitePiece(Piece.createWhiteRook());
        addWhitePiece(Piece.createWhiteKnight());
        addWhitePiece(Piece.createWhiteBishop());
        addWhitePiece(Piece.createWhiteQueen());
        addWhitePiece(Piece.createWhiteKing());
        addWhitePiece(Piece.createWhiteBishop());
        addWhitePiece(Piece.createWhiteKnight());
        addWhitePiece(Piece.createWhiteRook());

        for (int i = 0; i < BOARD_FILE; i++) {
            addWhitePawn(Piece.createWhitePawn());
            addBlackPawn(Piece.createBlackPawn());
        }
        addBlackPiece(Piece.createBlackRook());
        addBlackPiece(Piece.createBlackKnight());
        addBlackPiece(Piece.createBlackBishop());
        addBlackPiece(Piece.createBlackQueen());
        addBlackPiece(Piece.createBlackKing());
        addBlackPiece(Piece.createBlackBishop());
        addBlackPiece(Piece.createBlackKnight());
        addBlackPiece(Piece.createBlackRook());
    }

    public String showBoard() {
        StringBuilder result = new StringBuilder();
        String blankRank = "........";
        result.append(appendNewLine(getBlackPiecesResult()))
                .append(appendNewLine(getBlackPawnsResult()))
                .append(appendNewLine(blankRank))
                .append(appendNewLine(blankRank))
                .append(appendNewLine(blankRank))
                .append(appendNewLine(blankRank))
                .append(appendNewLine(getWhitePawnsResult()))
                .append(appendNewLine(getWhitePiecesResult()));
        return result.toString();
    }


}
