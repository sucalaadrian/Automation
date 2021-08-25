package setup;

import io.qameta.allure.Allure;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

import static com.codeborne.selenide.Selenide.screenshot;

public class Setup {
    public void takeScreenShot(String name) {
        try {
            String uuid = UUID.randomUUID().toString();
            Path path = Paths.get(URI.create(Objects.requireNonNull(screenshot(uuid))));
            Allure.addAttachment("PrintScreen " + name, Files.newInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
