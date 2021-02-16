package chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Board board = new Board();

        System.out.println("명령어를 입력해주세요.");
        System.out.println("end를 입력하면 종료됩니다.");
        System.out.println(" start   |   end");
        System.out.print("> ");

        String commend = br.readLine();

        while (!commend.equals("end")) {
            if (commend.equals("start")) {
                System.out.println(board.print());
            }
            System.out.print("> ");
            commend = br.readLine();
        }

        System.out.println("게임이 종료되었습니다.");
        br.close();
    }
}
