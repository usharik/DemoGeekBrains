package ru.geekbrains.patterns.service;

class ServiceFactoryImp implements ServiceFactory {

    private SubService1 subService1;

    @Override
    public Service createService() {
        SubService1 subService1 = createSubService1();
        SubService2 subService2 = new SubService2();
        return new ServiceImp(subService1, subService2);
    }

    /**
     * This method of factory create Singleton
     *
     * @return SubService1 instance
     */
    @Override
    public SubService1 createSubService1() {
        if (subService1 == null) {
            subService1 = new SubService1Impl();
        }
        return subService1;
    }
}
