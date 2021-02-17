package chess;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utills.StringUtils.*;

class BoardTest {

    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
        board.initialize();
    }

    @Test
    @DisplayName("boardInit")
    public void create() throws Exception {

        assertEquals(32, board.pieceCount());

        String blankRank = appendNewLine("* * * * * * * *");

        assertEquals(
                appendNewLine("R"+" "+"N"+" "+"B"+" "+"Q"+" "+"K"+" "+"B"+" "+"N"+" "+"R"+" ") +
                appendNewLine(NEWLINE)+
                appendNewLine("P" +" " +"P" +" " +"P" +" " +"P" +" " +"P" +" " +"P" +" " +"P" +" " +"P" +" ") +
                appendNewLine(NEWLINE)+
                blankRank +appendNewLine(NEWLINE)+
                blankRank +appendNewLine(NEWLINE)+
                blankRank +appendNewLine(NEWLINE)+
                blankRank +appendNewLine(NEWLINE)+
                appendNewLine("p"+" "+"p"+" "+"p"+" "+"p"+" "+"p"+" "+"p"+" "+"p"+" "+"p"+" ")+
                appendNewLine(NEWLINE)+
                appendNewLine("r"+" "+"n"+" "+"b"+" "+"q"+" "+"k"+" "+"b"+" "+"n"+" "+"r"+" "),

                board.showBoard());
    }

}