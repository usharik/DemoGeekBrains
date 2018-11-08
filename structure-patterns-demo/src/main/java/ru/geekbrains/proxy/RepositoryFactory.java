package ru.geekbrains.proxy;

public class RepositoryFactory {

    public static Repository getRepository() {
        Repository rep = new RepositoryImpl();
        return new SecuredRepository(rep, new SecureService());
    }
}
