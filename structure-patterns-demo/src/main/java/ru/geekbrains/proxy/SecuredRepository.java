package ru.geekbrains.proxy;

class SecuredRepository implements Repository {

    private final Repository repository;
    private SecureService secureService;

    public SecuredRepository(Repository repository, SecureService secureService) {
        this.repository = repository;
        this.secureService = secureService;
    }

    @Override
    public void save(Object obj) {
        if (secureService.hasPermission("save")) {
            repository.save(obj);
        }
    }

    @Override
    public void getAll(Object obj) {
        if (secureService.hasPermission("getAll")) {
            repository.getAll(obj);
        }
    }

    @Override
    public void delete(Long id) {
        if (secureService.hasPermission("delete")) {
            repository.delete(id);
        }
    }
}
