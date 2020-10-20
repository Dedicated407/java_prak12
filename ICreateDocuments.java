package ikbo.prak12;

public interface ICreateDocuments {
    IDocument CreateNew();
    IDocument CreateOpen();
}
/*
•	Нужно создать фабричный интерфейс ICreateDocument.
Этот интерфейс содержит два абстрактных фабричных метода: CreateNew и CreateOpen, оба возвращают экземпляр IDocument
*/