package Posttest6;

import java.io.IOException;

public interface AdminInterface {
    void add_data() throws IOException;
    void display();
    void update() throws IOException;
    void delete() throws IOException;
}