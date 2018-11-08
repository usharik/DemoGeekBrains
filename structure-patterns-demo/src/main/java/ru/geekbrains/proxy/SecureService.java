package ru.geekbrains.proxy;

class SecureService {

    boolean hasPermission(String name) {
        switch (name) {
            case "save":
                return true;
            case "getAll":
                return true;
            case "delete":
                return false;
            default:
                return false;
        }
    }
}
