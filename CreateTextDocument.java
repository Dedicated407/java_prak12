package ikbo.prak12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class CreateTextDocument extends CreateAbstractDocument{

    public IDocument CreateNew() {
        return new TextDocument("./untiled.txt");
    }

    public IDocument CreateOpen() {
        try {
            String str = Files.readString(Paths.get("./untiled.txt"));
            return new TextDocument(str);
        } catch (InvalidPathException e) {
            System.out.println("Путь неверен!");
        } catch (IOException e) {
            System.out.println("Упс... Что-то пошло так...");
        }
        return new TextDocument("");
    }
}
