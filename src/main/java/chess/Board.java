package chess;

import chess.pieces.Color;
import chess.pieces.Piece;
import chess.pieces.Type;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int BOARD_SIZE = 8;

    private final List<Piece> whitePieces = new ArrayList<>();
    private final List<Piece> blackPieces = new ArrayList<>();

    public void addWhitePieces(Piece piece) {
        if (piece.isWhite()) {
            whitePieces.add(piece);
            return;
        }
        getAddErrorMessage();
    }

    public void addBlackPieces(Piece piece) {
        if (piece.isBlack()) {
            blackPieces.add(piece);
            return;
        }
        getAddErrorMessage();
    }

    private void getAddErrorMessage(){
        System.out.println("알 수 없는 color의 piece입니다.");
        System.out.println("add에 실패하였습니다.");
    }

    public int totalPiecesCount() {
        return whitePieces.size() + blackPieces.size();
    }

    private void appendChessPieceToSort(StringBuilder stringBuilder, Piece piece){
        stringBuilder.append(piece.getRepresentation());
        if (stringBuilder.length() == BOARD_SIZE) {
            stringBuilder.append(StringUtils.getNewLine());
        }
    }

    private String getPiecesSort(Color color) {
        StringBuilder sb = new StringBuilder();
        switch (color) {
            case WHITE:
                for (Piece piece : whitePieces) {
                    appendChessPieceToSort(sb, piece);
                }
                return sb.toString();

            case BLACK:
                for (Piece piece : blackPieces) {
                    appendChessPieceToSort(sb, piece);
                }
                return sb.toString();

            default:
                return "";
        }
    }

    public void initialize() {
        initializeBlackPieces();
        initializeWhitePieces();
    }

    private void initializeWhitePieces() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            addWhitePieces(Piece.createWhitePawn());
        }

        addWhitePieces(Piece.createWhiteRook());
        addWhitePieces(Piece.createWhiteKnight());
        addWhitePieces(Piece.createWhiteBishop());
        addWhitePieces(Piece.createWhiteQueen());
        addWhitePieces(Piece.createWhiteKing());
        addWhitePieces(Piece.createWhiteBishop());
        addWhitePieces(Piece.createWhiteKnight());
        addWhitePieces(Piece.createWhiteRook());
    }

    private void initializeBlackPieces() {

        addBlackPieces(Piece.createBlackRook());
        addBlackPieces(Piece.createBlackKnight());
        addBlackPieces(Piece.createBlackBishop());
        addBlackPieces(Piece.createBlackQueen());
        addBlackPieces(Piece.createBlackKing());
        addBlackPieces(Piece.createBlackBishop());
        addBlackPieces(Piece.createBlackKnight());
        addBlackPieces(Piece.createBlackRook());

        for (int i = 0; i < BOARD_SIZE; i++) {
            addBlackPieces(Piece.createBlackPawn());
        }
    }

    public String getChessBoard() {
        StringBuilder boardRank = new StringBuilder();
        String blank = "........";

        boardRank.append(StringUtils.addNewLine(getPiecesSort(Color.BLACK)));

        boardRank.append(StringUtils.addNewLine(blank));
        boardRank.append(StringUtils.addNewLine(blank));
        boardRank.append(StringUtils.addNewLine(blank));
        boardRank.append(StringUtils.addNewLine(blank));

        boardRank.append(StringUtils.addNewLine(getPiecesSort(Color.WHITE)));

        return boardRank.toString();
    }
}