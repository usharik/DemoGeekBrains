package ru.geekbrains.proxy;

import org.junit.Test;

public class ProxyTest {

    @Test
    public void test() {
        Repository repository = RepositoryFactory.getRepository();
        repository.getAll(1);
    }
}
