package service;

import entity.Category;
import entity.User;
import repository.RepoCategory;
import repository.RepoTask;
import service.serviceimpl.ServiceImplCategory;


public class ServiceCategory implements ServiceImplCategory {
    RepoCategory repoCategory = new RepoCategory();
    RepoTask task = new RepoTask();

    @Override
    public void categoryAdd(int userId) {
        CheckScanner check = new CheckScanner();
        System.out.println("Введите новую категорию");
        String nameCategory = check.checkString();
        Category category = new Category(nameCategory,User.getId());
        repoCategory.addCategory(category, User.getId());
    }

    @Override
    public void categoryRemove(int userId) {
        CheckScanner check = new CheckScanner();
        System.out.println("какую категорию удалить?");
        repoCategory.printAllCategory(User.getId());
        int remove = check.checkInt();
        repoCategory.removeCategory(remove);
    }

    @Override
    public void categoryEdit(int userId) {
        CheckScanner check = new CheckScanner();
        System.out.println("Какую категорию изменить?");
        if (repoCategory.printCheckCategory(User.getId())) {
            repoCategory.printAllCategory(User.getId());
            int edit = Integer.parseInt(check.checkString());
            System.out.println("Введите новое название");
            String name = check.checkString();
            repoCategory.editCategory(edit, name);
        }

    }

    @Override
    public void categoryPrint(int userId) {
        repoCategory.printAllCategory(User.getId());
    }

    public void addCategoryTask() {
        CheckScanner check = new CheckScanner();
        System.out.println("Выберите задачу");
        task.printTask(User.getId());
        int idTask = Integer.parseInt(check.checkString());
        System.out.println("В какую категорию добавляем?");
        repoCategory.printAllCategory(User.getId());
        int idCategory = Integer.parseInt(check.checkString());
        repoCategory.addCategoryTask(idTask, idCategory);
    }
}
