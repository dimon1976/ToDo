package service;

import java.util.Scanner;

public class CheckScanner {
    Scanner scan = new Scanner(System.in);

    public int checkInt() {
        while (!scan.hasNextInt()) {
            System.out.println("�� ����� �������� �� ���� ����");
            scan.next();
        }
        return scan.nextInt();
    }

    public String checkString() {
        while (!scan.hasNext()) {
            System.out.println("�� ����� �������� �� ���� ����");
            scan.next();
        }
        return scan.nextLine();
    }
}
