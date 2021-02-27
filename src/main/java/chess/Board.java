package chess;

import chess.pieces.Piece;
import chess.pieces.Piece.*;

import java.util.*;
import java.util.stream.Collectors;

import static chess.utils.StringUtils.appendNewLine;
import static java.util.stream.Collectors.*;

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

    public void move(Position position, Piece piece) {
        int x = position.getX();
        int y = position.getY();
        board.get(y).remove(x);
        board.get(y).setPiece(x, piece);
    }

    public double calculatePoint(Color color) {
        double result = board.stream()
                .map(Rank::getPieceList)
                .flatMap(List::stream)
                .filter(x -> x.getColor() == color)
                .mapToDouble(x -> x.getType().getDefaultPoint())
                .sum();
        return result - getSameFilePawnPoint(color);
    }

    private double getSameFilePawnPoint(Color color) {
        Map<Integer, Long> pawnFileMap = getPawnFileMap(color);
        return getSameFilePawnNum(pawnFileMap) * 0.5;
    }

    private Map<Integer, Long> getPawnFileMap(Color color) {
        return board.stream()
                .map(Rank::getPieceList)
                .flatMap(List::stream)
                .filter(x -> x.getColor() == color)
                .filter(x -> x.getType() == Type.PAWN)
                .map(Piece::getPosition)
                .map(Position::getX)
                .collect(groupingBy(x -> x, counting()));
    }

    private int getSameFilePawnNum(Map map) {
        Collection valueSet = map.values();
        Iterator iterator = valueSet.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            int iteratorNext = Integer.parseInt(String.valueOf(iterator.next()));
            if (iteratorNext > 1) {
                sum += iteratorNext;
            }
        }
        return sum;
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
