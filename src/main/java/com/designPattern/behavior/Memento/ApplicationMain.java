package com.designPattern.behavior.Memento;

import java.util.Scanner;

public class ApplicationMain {
    public static void main(String[] args) {
        InputText inputText = new InputText();
        SnapshotHolder holder = new SnapshotHolder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (":list".equals(input)) {
                System.out.println(inputText.getText());
            }
            else if (":undo".equals(input)) {
                inputText.restoreSnapshot(holder.popSnapshot());
            } else {
                holder.pushSnapshot(inputText.createSnapshot());
                inputText.append(input);
            }
        }
    }
}
