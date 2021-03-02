package kr.codesquad.freddie.chess;

import kr.codesquad.freddie.chess.board.BoardView;
import kr.codesquad.freddie.chess.command.Command;
import kr.codesquad.freddie.chess.game.ChessGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            ChessGame chessGame = ChessGame.create();
            BoardView boardView = new BoardView(chessGame.getBoard());

            for (String command = getInput(br); !command.equals("end"); command = getInput(br)) {
                try {
                    Command.create(command).execute(chessGame);
                    System.out.println(boardView.getRepresentation());
                } catch (IllegalArgumentException e) {
                    System.out.println("잘못된 입력입니다. command : " + command);
                }
            }
        }
    }

    public static String getInput(BufferedReader br) throws IOException {
        StringBuilder sb = new StringBuilder();

        sb.append("명령어를 입력해주세요").append(System.lineSeparator())
                .append("start : 게임 시작").append(System.lineSeparator())
                .append("move source target : source에서 target으로 이동 e.g. move a1 a2").append(System.lineSeparator())
                .append("end : 게임 종료").append(System.lineSeparator())
                .append("> ");

        System.out.print(sb.toString());

        return br.readLine();
    }
}
