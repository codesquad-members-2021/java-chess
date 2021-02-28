package piece;

import chess.Position;
import piece.attribute.*;

import java.util.*;
import java.util.function.BiFunction;

public class PieceFactory {
    private static final Map<Type, BiFunction<Color, Position, Piece>> PIECE_FACTORY_MAP = new HashMap<>();

    static {
        PIECE_FACTORY_MAP.put(Type.PAWN, Pawn::new);
        PIECE_FACTORY_MAP.put(Type.ROOK, Rook::new);
        PIECE_FACTORY_MAP.put(Type.KNIGHT, Knight::new);
        PIECE_FACTORY_MAP.put(Type.BISHOP, Bishop::new);
        PIECE_FACTORY_MAP.put(Type.QUEEN, Queen::new);
        PIECE_FACTORY_MAP.put(Type.KING, King::new);
        PIECE_FACTORY_MAP.put(Type.BLANK, Blank::new);
    }

    public static Piece createPiece(Color color, Type type, Position position) {
        BiFunction<Color, Position, Piece> pieceFactory = PIECE_FACTORY_MAP.get(type);
        return pieceFactory.apply(color, position);
    }

    public static Piece createPiece(Color color, Type type, String position) {
        BiFunction<Color, Position, Piece> pieceFactory = PIECE_FACTORY_MAP.get(type);
        return pieceFactory.apply(color, new Position(position));
    }
}

