package chess;

import chess.pieces.Piece;
import chess.pieces.Piece.*;

import java.util.*;
import java.util.stream.Collectors;

import static chess.utils.StringUtils.appendNewLine;

public class Board {
    public static final int BOARD_RANK = 8;
    public static final int BOARD_FILE = 8;
    private List<Rank> board = new ArrayList<>(BOARD_RANK);

    public void initializeEmpty() {
        for (int i = 0; i < BOARD_RANK; i++) {
            board.add(Rank.initBlankRank());
        }
    }

    public void initializeBoard() {
        // 랭크 번호 순서대로 board 리스트에 담기
        board.add(Rank.initWhitePieceRank());
        board.add(Rank.initWhitePawnRank());
        for (int i = 0; i < 4; i++) {
            board.add(Rank.initBlankRank());
        }
        board.add(Rank.initBlackPawnRank());
        board.add(Rank.initBlackPieceRank());
    }

    public String showBoard() {
        StringBuilder result = new StringBuilder();
        for (int i = BOARD_RANK - 1; i >= 0; i--) {
            result.append(appendNewLine(getRankResult(i)));
        }
        return result.toString();
    }

    private String getRankResult(int index) {
        return getPieceResult(board.get(index));
    }

    private String getPieceResult(Rank rank) {
        StringBuilder result = new StringBuilder();
        List<Piece> pieceList = rank.getPieceList();
        for (Piece piece : pieceList) {
            result.append(piece.getRepresentation());
        }
        return result.toString();
    }

    public Piece findPiece(String position) {
        int x = getX(position);
        int y = getY(position);
        return board.get(y).getPieceList().get(x);
    }

    public void setPiece(String position, Piece piece) {
        int x = getX(position);
        int y = getY(position);
        board.get(y).remove(x);
        board.get(y).setPiece(x, piece);
    }

    private int getX(String position) {
        return position.charAt(0) - 'a';
    }

    private int getY(String position) {
        return position.charAt(1) - '0' - 1;
    }

    public double calculatePoint(Color color) {
        double result = board.stream()
                .map(Rank::getPieceList)
                .flatMap(List::stream)
                .filter(x -> x.getColor() == color)
                .mapToDouble(x -> x.getType().getDefaultPoint())
                .sum();

    }

    public List<Type> sortPiece(Color color) {
        return board.stream()
                .map(x -> x.getPieceList())
                .flatMap(List::stream)
                .filter(s -> s.getColor() == color)
                .map(x -> x.getType())
                .sorted(Comparator.comparing(Type::getDefaultPoint).reversed())
                .collect(Collectors.toList());
    }
}
