package ru.geekbrains.patterns.service.factory.method;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class StreamCopier {

    protected abstract InputStream getInputStream() throws IOException;

    protected abstract OutputStream getOutputStream() throws IOException;

    public void copyData() throws IOException {
        try (InputStream inputStream = getInputStream();
             OutputStream outputStream = getOutputStream()) {
            byte[] bytes = new byte[1024];
            while (inputStream.read(bytes) > 0) {
                outputStream.write(bytes);
            }
        }
    }
}
