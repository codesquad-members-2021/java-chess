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
        for (int rankNum = 1; rankNum <= BOARD_RANK; rankNum++) {
            board.add(Rank.initBlankRank(rankNum));
        }
    }

    public void initializeBoard() {
        // 랭크 번호 순서대로 board 리스트에 담기
        board.add(Rank.initWhitePieceRank());
        board.add(Rank.initWhitePawnRank(2));
        for (int rankNum = 0; rankNum < 4; rankNum++) {
            board.add(Rank.initBlankRank(3 + rankNum));
        }
        board.add(Rank.initBlackPawnRank(7));
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

    public Piece findPiece(Position position) {
        return board.get(position.getY()).getPieceList().get(position.getX());
    }

    public void setPiece(Position position, Piece piece) {
        int x = position.getX();
        int y = position.getY();
        board.get(y).remove(x);
        board.get(y).setPiece(x, piece);
    }

    public double calculatePoint(Color color) {
        return board.stream()
                .map(Rank::getPieceList)
                .flatMap(List::stream)
                .filter(x -> x.getColor() == color)
                .mapToDouble(x -> x.getType().getDefaultPoint())
                .sum();
    }


    public List<Type> sortPiece(Color color) {
        return board.stream()
                .map(Rank::getPieceList)
                .flatMap(List::stream)
                .filter(x -> x.getColor() == color)
                .map(Piece::getType)
                .sorted(Comparator.comparing(Type::getDefaultPoint).reversed())
                .collect(Collectors.toList());
    }
}
