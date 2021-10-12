package service;

import entity.User;
import repository.RepoUser;
import service.serviceimpl.ServiceImplUser;


public class ServiceUser implements ServiceImplUser {

    public boolean userLogin() {
        RepoUser repository = new RepoUser();
        CheckScanner check = new CheckScanner();
        System.out.println("������� �����");
        String login = check.checkString().toLowerCase();
        System.out.println("������� ������");
        String pass = check.checkString();
        if (repository.userLogin(login, pass)) {
            User user = new User(login, pass);
            user.setId(repository.returnUserId(login));
            return true;
        }
        return false;
    }


    public boolean userRegister() {
        RepoUser repository = new RepoUser();
        CheckScanner check = new CheckScanner();
        System.out.println("������� �����");
        String login = check.checkString().toLowerCase();
        System.out.println("������� ������");
        String pass = check.checkString();
        if (repository.userRegister(login, pass)) {
            User user = new User(login, pass);
            user.setId(repository.returnUserId(login));
            return true;
        }
        return false;
    }
}
