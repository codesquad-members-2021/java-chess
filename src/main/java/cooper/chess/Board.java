package cooper.chess;

import cooper.chess.piece.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static cooper.chess.utils.StringUtils.appendNewLine;

public class Board {
    public static final int BOARD_SIZE = 8;

    private final List<Rank> rankList;

    public Board() {
        this.rankList = new ArrayList<>();
        initRankList();
    }

    private void initRankList() {
        initWhitPieces();
        initBlank();
        initBlackPieces();
    }

    private void initWhitPieces() {
        initWhiteOtherPieces();
        initWhitePawn();
    }

    private void initWhiteOtherPieces() {
        List<Piece> pieceList = new ArrayList<>();

        pieceList.add(Piece.createWhiteRook());
        pieceList.add(Piece.createWhiteKnight());
        pieceList.add(Piece.createWhiteBishop());
        pieceList.add(Piece.createWhiteQueen());
        pieceList.add(Piece.createWhiteKing());
        pieceList.add(Piece.createWhiteBishop());
        pieceList.add(Piece.createWhiteKnight());
        pieceList.add(Piece.createWhiteRook());

        rankList.add(new Rank(pieceList));
    }

    private void initWhitePawn() {
        List<Piece> pieceList = new ArrayList<>();
        IntStream.range(0, BOARD_SIZE)
                .forEach(count -> pieceList.add(Piece.createWhitePawn()));

        this.rankList.add(new Rank(pieceList));
    }

    private void initBlank() {
        for (int rankNum = 3; rankNum < 7; rankNum++) {
            List<Piece> pieceList = new ArrayList<>();
            IntStream.range(0, BOARD_SIZE).forEach(count -> pieceList.add(Piece.createBlank()));
            this.rankList.add(new Rank(pieceList));
        }
    }

    private void initBlackPieces() {
        initBlackPawn();
        initBlackOtherPieces();
    }

    private void initBlackPawn() {
        List<Piece> pieceList = new ArrayList<>();
        IntStream.range(0, BOARD_SIZE)
                .forEach(count -> pieceList.add(Piece.createBlackPawn()));

        this.rankList.add(new Rank(pieceList));
    }

    private void initBlackOtherPieces() {
        List<Piece> pieceList = new ArrayList<>();

        pieceList.add(Piece.createBlackRook());
        pieceList.add(Piece.createBlackKnight());
        pieceList.add(Piece.createBlackBishop());
        pieceList.add(Piece.createBlackQueen());
        pieceList.add(Piece.createBlackKing());
        pieceList.add(Piece.createBlackBishop());
        pieceList.add(Piece.createBlackKnight());
        pieceList.add(Piece.createBlackRook());

        rankList.add(new Rank(pieceList));
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();

        for (Rank rank : rankList) {
            sb.append(appendNewLine(rank.getRankStatus()));
        }

        return sb.toString();
    }

    public int pieceCount() {
        return rankList.stream().mapToInt(Rank::getPieceCount).sum();
    }

    public int getEachPieceCount(Color color, Type type) {
        return rankList.stream()
                .mapToInt(rank -> rank.getEachPieceCount(color, type))
                .sum();
    }

    public Piece findPiece(Position position) {
        return rankList.get(position.getyPos())
                .findPiece(position.getxPos());
    }

    public void initializeEmpty() {
        rankList.forEach(Rank::initializeEmpty);
    }

    public void addPiece(Position position, Piece piece) {
        rankList.get(position.getyPos())
                .addPiece(piece, position.getxPos());
    }

    public void move(Position before, Position after) {
        Piece beforePiece = findPiece(before);
        addPiece(before, Piece.createBlank());
        addPiece(after, beforePiece);
    }

    public double calculatePoint(Color color) {
        double result = 0;
        for (int column = 0; column < BOARD_SIZE; column++) {
            result += havePawnsInColumn(column, color) ?
                    addPointInColumn(column, color)
                            - countPawnCount(column, color) * 0.5
                    : addPointInColumn(column, color);
        }

        return result;
    }

    public boolean havePawnsInColumn(int column, Color color) {
        return rankList.stream()
                .filter(rank -> rank.hasPawnIn(column, color))
                .count() > 1;
    }

    private double addPointInColumn(int column, Color color) {
        return rankList.stream()
                .filter(rank -> rank.getInColumn(column).getColor() == color)
                .mapToDouble(rank -> rank.getInColumn(column)
                        .getDefaultPoint())
                .sum();
    }

    private int countPawnCount(int column, Color color) {
        return (int)rankList.stream()
                .map(rank -> rank.getInColumn(column))
                .filter(piece -> (piece.getType() == Type.PAWN)
                && (piece.getColor() == color))
                .count();
    }

    public List<Piece> sortByTypePoint(Color color) {
        List<Piece> list = getListOf(color);

        list.sort(Comparator.comparingDouble(piece
                -> piece.getDefaultPoint()));

        return list;
    }

    public List<Piece> sortByTypePointReverse(Color color) {
        List<Piece> list = getListOf(color);

        list.sort(Comparator.comparingDouble(piece
                -> - piece.getDefaultPoint()));

        return list;
    }

    private List<Piece> getListOf(Color color) {
        List<Piece> list = new ArrayList<>();

        for (Rank rank : rankList) {
            list.addAll(rank.getList(color));
        }

        return list;
    }
}
