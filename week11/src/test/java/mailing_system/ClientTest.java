package mailing_system;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void getId() {
        Client c1 = new Client("b", 18, true);
        Client c2 = new Client("y", 18, false);
        // awkward test, though there is no easy way to reload
        // static vars for each test and as Client class is
        // created in other test it messes up strict values in this one
        assertTrue(c2.getId() > c1.getId());
    }
}