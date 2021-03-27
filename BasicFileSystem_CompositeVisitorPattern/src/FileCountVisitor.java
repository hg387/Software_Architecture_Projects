public class FileCountVisitor implements Visitor {

    Integer count = 0;

    @Override
    public void visit (File file) {
        count += 1;
    }

    @Override
    public void visit (Folder folder) {
        folder.accept ( this );
    }

}
