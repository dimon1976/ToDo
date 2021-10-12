package controller;

import entity.User;
import service.CheckScanner;
import service.ServiceCategory;
import service.ServiceTask;

public class UserMenu {
    ServiceTask service = new ServiceTask();
    ServiceCategory serviceCategory = new ServiceCategory();

    public void start() {
        CheckScanner check = new CheckScanner();
        boolean a = true;
        while (a) {
            System.out.println("1 - ������");
            System.out.println("2 - ���������");
            System.out.println("0 - ��������� ������");
            int i = check.checkInt();
            if (i == 0) {
                System.out.println("��������� ������.");
                a = false;
                break;
            } else if (i == 1) {
                task();
            } else if (i == 2) {
                category();
            }
            break;
        }
    }

    public void task() {
        CheckScanner check = new CheckScanner();
        while (true) {
            System.out.println("1 - �������� ������");
            System.out.println("2 - ������� ������");
            System.out.println("3 - ������������� ������");
            System.out.println("4 - �������� ������ ������");
            System.out.println("5 - �������� ��� ������");
            System.out.println("6 - �������� ������ �� ID");
            System.out.println("7 - �������� ������ � ���������");
            System.out.println("8 - �������� ��� ������ (����� �� �������)");
            System.out.println("9 - ��������� � ��������� ����");
            System.out.println("0 - ��������� ������");
            int i = check.checkInt();
            if (i == 0) {
                System.out.println("��������� ������.");
                break;
            } else if (i == 9) {
                start();
            } else {
                taskID(i);
            }
        }
    }

    public void category() {
        CheckScanner check = new CheckScanner();
        while (true) {
            System.out.println("1 - �������� ���������");
            System.out.println("2 - ������� ���������");
            System.out.println("3 - ������������� ���������");
            System.out.println("4 - �������� ��� ���������");
            System.out.println("5 - �������� ��� ������ � ���������");
            System.out.println("6 - ��������� � ��������� ����");
            System.out.println("0 - ��������� ������");
            int i = check.checkInt();
            if (i == 0) {
                System.out.println("��������� ������.");
                break;
            } else if (i == 6) {
                start();
            } else {
                categoryID(i);
            }

        }
    }

    public void categoryID(int i) {
        switch (i) {
            case 1:
                serviceCategory.categoryAdd(User.getId());
                break;
            case 2:
                serviceCategory.categoryRemove(User.getId());
                break;
            case 3:
                serviceCategory.categoryEdit(User.getId());
                break;
            case 4:
                serviceCategory.categoryPrint(User.getId());
                break;
            case 5:
                service.selectTaskCategory(User.getId());
                break;
            default:
                System.out.println("������ ������ ���");
                category();
                break;
        }

    }

    public void taskID(int i) {
        switch (i) {
            case 1:
                service.addTask(User.getId());
                break;
            case 2:
                service.removeTask(User.getId());
                break;
            case 3:
                service.editTask(User.getId());
                break;
            case 4:
                service.editTaskStatus(User.getId());
                break;
            case 5:
                service.printTask(User.getId());
                break;
            case 6:
                service.printTaskId(User.getId());
                break;
            case 7:
                serviceCategory.addCategoryTask();
                break;

            case 8:
                service.printTaskStatus(User.getId());
                break;
            default:
                System.out.println("������ ������ ���");
                task();
                break;
        }
    }
}
