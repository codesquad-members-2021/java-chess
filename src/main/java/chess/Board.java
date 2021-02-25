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
        double pawn = countPiece(color, Type.PAWN);
        double knight = countPiece(color, Type.KNIGHT);
        double rook = countPiece(color, Type.ROOK);
        double bishop = countPiece(color, Type.BISHOP);
        double queen = countPiece(color, Type.QUEEN);

        double sameFilePawn = getSameFileNum(pawn, color);
        pawn = pawn - sameFilePawn;

        return getSum(pawn, sameFilePawn, knight, rook, bishop, queen);
    }

    private int countPiece(Color color, Type type) {
        Optional<Long> result = board.stream()
                .map(x -> x.count(color, type))
                .reduce((a, b) -> a + b);
        return result.get().intValue();
    }

    private double getSameFileNum(double pawnNum, Color color) {
        Piece pawn =
                color == Color.WHITE ? Piece.createWhitePawn() : Piece.createBlackPawn();
        String[] positions = getPawnPosition(pawn);
        Set<String> deletedSamePositions = new HashSet<>(Arrays.asList(positions));
        return (pawnNum - deletedSamePositions.size()) * 2;
    }

    private String[] getPawnPosition(Piece pawn) {
        String[] positionArr = new String[countPiece(pawn.getColor(), pawn.getType())];
        int index = 0;
        for (int i = 0; i < BOARD_RANK; i++) {
            for (int j = 0; j < BOARD_FILE; j++) {
                char x = (char) ('a' + i);
                char y = (char) ('1' + j);
                String position = x + "" + y;
                if (pawn.equals(findPiece(position))) {
                    positionArr[index] = x + "";
                    index++;
                }
            }
        }
        return positionArr;
    }

    private double getSum(double pawn, double sameFilePawn, double knight, double rook, double bishop, double queen) {
        return pawn * Type.PAWN.getDefaultPoint() +
                sameFilePawn * Type.PAWN.getDefaultPoint() * 0.5 +
                knight * Type.KNIGHT.getDefaultPoint() +
                rook * Type.ROOK.getDefaultPoint() +
                bishop * Type.BISHOP.getDefaultPoint() +
                queen * Type.QUEEN.getDefaultPoint();
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
