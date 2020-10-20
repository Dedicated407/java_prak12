package ikbo.prak12;

public abstract class CreateAbstractDocument implements ICreateDocuments{
    public IDocument CreateNew(IDocument abs) {
        return abs;
    }

    public IDocument CreateOpen(IDocument abs) {
        return abs;
    }
}
