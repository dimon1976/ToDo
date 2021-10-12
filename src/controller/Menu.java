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
            System.out.println("1 - Войти");
            System.out.println("2 - Зарегистрироваться");
            System.out.println("0 - Завершить работу");
            int i = checkScanner.checkInt();
            if (i == 0) {
                System.out.println("Завершаем работу");
                break;
            } else if (i == 1) {
                boolean login = serviceUser.userLogin();
                if (login) {
                    UserMenu userMenu = new UserMenu();
                    System.out.println("Вы авторизованы\n");
                    userMenu.start();
                    break;
                }
                System.out.println("Такой пользователь не найден\n");
                userAuthorize();
            } else if (i == 2) {
                boolean register = serviceUser.userRegister();
                if (!register) {
                    System.out.println("Такой пользователь существует, авторизуйтесь");
                    userAuthorize();
                    break;
                } else {
                    UserMenu userMenu = new UserMenu();
                    System.out.println("Вы зарегистрированы");
                    userMenu.start();
                    break;
                }
            }
            break;
        }
    }
}
