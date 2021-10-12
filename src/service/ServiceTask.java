package service;


import entity.Status;
import entity.Task;
import entity.User;
import repository.RepoCategory;
import repository.RepoTask;
import service.serviceimpl.ServiceImpl;

public class ServiceTask implements ServiceImpl {

    RepoCategory category = new RepoCategory();

    Status nw = Status.NEW;
    Status in = Status.IN_PROGRESS;
    Status pl = Status.PLANNED;
    Status cl = Status.CLOSED;


    @Override
    public void addTask(int userId) {
        RepoTask repoTask = new RepoTask();
        CheckScanner check = new CheckScanner();
        System.out.println("Введите название - ");
        String name = check.checkString();
        System.out.println("Введите Description - ");
        String desc = check.checkString();
        Task task = new Task(name,desc);
        repoTask.addTask(task, "NEW", User.getId());
    }

    @Override
    public void removeTask(int userId) {
        RepoTask repoTask = new RepoTask();
        CheckScanner check = new CheckScanner();
        System.out.println("Какую задачу хотите удалить ?");
        printTask(userId);
        int i = Integer.parseInt(check.checkString());
        repoTask.removeTask(i);
    }

    @Override
    public void editTask(int userId) {
        RepoTask repoTask = new RepoTask();
        CheckScanner check = new CheckScanner();
        System.out.println("Какую задачу нужно отредактировать ?");
        printTask(userId);
        int i = Integer.parseInt(check.checkString());
        System.out.println("Введите новое имя задачи");
        String st = check.checkString();
        System.out.println("Введите новое описание");
        String desc = check.checkString();
        repoTask.editTask(i, st, desc);
    }

    @Override
    public void editTaskStatus(int userId) {
        CheckScanner check = new CheckScanner();
        RepoTask repoTask = new RepoTask();
        System.out.println("Какую задачу нужно отредактировать ?");
        printTask(userId);
        int i = Integer.parseInt(check.checkString());
        System.out.println("Введите новый статус");
        System.out.println("1: " + in.getTranslation());
        System.out.println("2: " + pl.getTranslation());
        System.out.println("3: " + cl.getTranslation());
        int st = Integer.parseInt(check.checkString());
        switch (st) {
            case 1:
                repoTask.editTaskStatus(i, in.name());
                break;
            case 2:
                repoTask.editTaskStatus(i, pl.name());
                break;
            case 3:
                repoTask.editTaskStatus(i, cl.name());
                break;
            default:
                break;
        }
    }

    @Override
    public void printTask(int userId) {
        RepoTask repoTask = new RepoTask();
        repoTask.printTask(User.getId());
    }

    @Override
    public void printTaskId(int userId) {
        RepoTask repoTask = new RepoTask();
        CheckScanner check = new CheckScanner();
        System.out.println("Введите ID задачи");
        repoTask.printTask(User.getId());
        int i = Integer.parseInt(check.checkString());
        repoTask.printTaskId(i);
    }

    @Override
    public void printTaskStatus(int userId) {
        CheckScanner check = new CheckScanner();
        RepoTask repoTask = new RepoTask();
        System.out.println("Введите № статуса");
        System.out.println("1: " + nw.getTranslation());
        System.out.println("2: " + in.getTranslation());
        System.out.println("3: " + pl.getTranslation());
        System.out.println("4: " + cl.getTranslation());
        int st = Integer.parseInt(check.checkString());
        switch (st) {
            case 1:
                repoTask.printTaskStatus(nw.name(),User.getId());
                break;
            case 2:
                repoTask.printTaskStatus(in.name(),User.getId());
                break;
            case 3:
                repoTask.printTaskStatus(pl.name(),User.getId());
                break;
            case 4:
                repoTask.printTaskStatus(cl.name(),User.getId());
                break;
            default:
                break;
        }
    }

    @Override
    public void selectTaskCategory(int userId) {
        CheckScanner check = new CheckScanner();
        System.out.println("Выберите категорию");
        category.printAllCategory(User.getId());
        int pr = check.checkInt();
        category.printTaskInCategory(pr);
    }
}