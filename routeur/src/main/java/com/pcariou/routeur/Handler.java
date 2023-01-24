package com.pcariou.routeur;

import java.io.IOException;

public interface Handler {
    void read() throws IOException;
    void write(String message) throws IOException;
    void disconnect() throws IOException;

}
