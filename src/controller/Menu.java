package controller;

import repository.RepoUser;
import service.CheckScanner;
import service.ServiceUser;

public class Menu {
    ServiceUser serviceUser = new ServiceUser();

    public static void main(String[] args) {
        RepoUser user = new RepoUser();
        Menu menu = new Menu();
        menu.userAuthorize();
    }

    public void userAuthorize() {
        CheckScanner checkScanner = new CheckScanner();
        while (true) {
            System.out.println("1 - �����");
            System.out.println("2 - ������������������");
            System.out.println("0 - ��������� ������");
            int i = checkScanner.checkInt();
            if (i == 0) {
                System.out.println("��������� ������");
                break;
            } else if (i == 1) {
                boolean login = serviceUser.userLogin();
                if (login) {
                    UserMenu userMenu = new UserMenu();
                    System.out.println("�� ������������\n");
                    userMenu.start();
                    break;
                }
                System.out.println("����� ������������ �� ������\n");
                userAuthorize();
            } else if (i == 2) {
                boolean register = serviceUser.userRegister();
                if (!register) {
                    System.out.println("����� ������������ ����������, �������������");
                    userAuthorize();
                    break;
                } else {
                    UserMenu userMenu = new UserMenu();
                    System.out.println("�� ����������������");
                    userMenu.start();
                    break;
                }
            }
            break;
        }
    }
}
