package ru.geekbrains.patterns.service;

class ServiceImp implements Service {

    private final SubService1 subService1;
    private final SubService2 subService2;

    public ServiceImp(SubService1 subService1, SubService2 subService2) {

        this.subService1 = subService1;
        this.subService2 = subService2;
    }

    @Override
    public void action() {
        System.out.println("Performing the service action.");
    }
}

/*

zsdsdfgsdfgsdfgdfg <b>asdgfsdfgs<i>adsfasdfafsd</i>dfgsdfg</b>

HTMLBuilder()
    .addText("asdfasdfadfsadf")
    .addHTMLTag("b")
        .addText("sdasdasdasd")
        .addHTMLTag("i")
            .addText("sdfasdfasdf")
        .closeTag()
    .closeTag()
.build();

 */