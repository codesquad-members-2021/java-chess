package net.Dong;

import java.util.Scanner;




public class Main {
    private static final String PROMPT = "J-chess>>";
    public static void main(String[]args){
        Main app = new Main();
        Scanner sc = new Scanner(System.in);
        app.launcher(sc,app.auth(sc));
        return;
    }

    public String auth(Scanner sc) {
        // 멀티플레이, 싱글플레이 구분
        // 멀티플레이시 플레이어 구분을 위해 필요해서 추가함 추후개발
        return "";
    }
    public void launcher(Scanner sc, String authInfo) {
        String buffer = "";
        if(!authInfo.equals("")) {
            System.out.println("Authenfication failed");
            return;
        }

        buffer = sc.next();
        /* main의 역활이 명확해지면 다시 개발
        switch (buffer) {
            case buffer.equals(""):
        }
        */

        

    }


}

