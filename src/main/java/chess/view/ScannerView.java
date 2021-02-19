package chess.view;

import java.util.Scanner;

public class ScannerView {
    private final Scanner scanner;

    public ScannerView() {
        this.scanner = new Scanner(System.in);
    }

    public String nextLine() {
        System.out.print("> ");
        return scanner.nextLine().toUpperCase();
    }

    public void close() {
        scanner.close();
    }
}
