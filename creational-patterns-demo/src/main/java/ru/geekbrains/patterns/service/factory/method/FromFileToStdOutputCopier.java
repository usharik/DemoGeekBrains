package ru.geekbrains.patterns.service.factory.method;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FromFileToStdOutputCopier extends StreamCopier {

    private final String filename;

    public FromFileToStdOutputCopier(String filename) {
        this.filename = filename;
    }

    @Override
    protected InputStream getInputStream() throws IOException {
        return new FileInputStream(filename);
    }

    @Override
    protected OutputStream getOutputStream() throws IOException {
        return System.out;
    }
}
