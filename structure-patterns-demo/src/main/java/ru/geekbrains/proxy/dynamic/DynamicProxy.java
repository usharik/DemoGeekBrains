package ru.geekbrains.proxy.dynamic;

import ru.geekbrains.proxy.Repository;

import java.lang.reflect.Proxy;

/**
 * Example how to create dynamic proxy from any interface with usage of {@link Proxy} class from standard java reflection
 */
public class DynamicProxy {

    // Repository instance which should be wrapped by proxy
    private static Repository repository = new RepositoryImpl();

    public static void main(String[] args) {
        // creating of Proxy class based on Repository interface
        Repository f = (Repository) Proxy.newProxyInstance(Repository.class.getClassLoader(),
                new Class<?>[]{Repository.class},

                // handler of method calls
                (proxy, method, args1) -> {
                    // Doing some logging or any other functionality
                    System.out.println("Calling method " + method.getName());

                    // searching for the same method in proxied object and invoking it with reflection
                    return repository.getClass()
                            .getMethod(method.getName(), method.getParameterTypes())
                            .invoke(repository, args1);
                });
        f.save(new Object());
    }
}
