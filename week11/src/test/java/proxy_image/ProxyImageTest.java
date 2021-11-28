package proxy_image;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ProxyImageTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    void display() {
        System.setOut(new PrintStream(outContent));

        ProxyImage pi = new ProxyImage(".");
        pi.display();

        System.setOut(System.out);
        // shows that proxy image logic was executed
        assertTrue(outContent.toString().contains("Proxy"));
        // shows that main image display logic worked as well
        assertTrue(outContent.toString().contains("real"));
    }

}