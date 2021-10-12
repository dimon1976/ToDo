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
            System.out.println("1 - задачи");
            System.out.println("2 - категории");
            System.out.println("0 - завершить работу");
            int i = check.checkInt();
            if (i == 0) {
                System.out.println("Завершаем работу.");
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
            System.out.println("1 - добавить задачу");
            System.out.println("2 - удалить задачу");
            System.out.println("3 - редактировать задачу");
            System.out.println("4 - изменить статус задачи");
            System.out.println("5 - показать все задачи");
            System.out.println("6 - показать задачу по ID");
            System.out.println("7 - добавить задачу в категорию");
            System.out.println("8 - показать все задачи (отбор по статусу)");
            System.out.println("9 - вернуться в начальное меню");
            System.out.println("0 - завершить работу");
            int i = check.checkInt();
            if (i == 0) {
                System.out.println("Завершаем работу.");
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
            System.out.println("1 - добавить категорию");
            System.out.println("2 - удалить категорию");
            System.out.println("3 - редактировать категорию");
            System.out.println("4 - показать все категории");
            System.out.println("5 - показать все задачи в категории");
            System.out.println("6 - вернуться в начальное меню");
            System.out.println("0 - завершить работу");
            int i = check.checkInt();
            if (i == 0) {
                System.out.println("Завершаем работу.");
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
                System.out.println("Такого пункта нет");
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
                System.out.println("Такого пункта нет");
                task();
                break;
        }
    }
}
