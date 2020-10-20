package ikbo.prak12;

import java.io.FileWriter;
import java.io.IOException;

public class TextDocument implements IDocument{
    private String content;

    TextDocument(String content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = (String)content;
    }

    public void saveInformation(String path) {
        try(FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(content);
            fileWriter.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Текстовая информация будет тут!");
    }
}
/*
Потребуется создать конкретный унаследованный класс TextDocument и фабрику для него — CreateTextDocument.
*/