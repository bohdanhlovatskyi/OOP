package mailing_system;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public enum MailCode {
    HAPPY_BIRTHDAY("src/main/java/mailing_system/codes/happy_birthday.txt"),
    GREETINGS("src/main/java/mailing_system/codes/greetings.txt");

    private final String filename;

    // this will be private by default, so we won't be capable
    // to actually reach it other ways than enumeration
    MailCode(String filename) {
        this.filename = filename;
    }

    public String generateText() throws IOException {
        return new String(
                Files.readAllBytes(Paths.get(this.filename)),
                StandardCharsets.UTF_8);
    }
}
