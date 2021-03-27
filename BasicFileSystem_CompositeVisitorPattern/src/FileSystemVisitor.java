public class FileSystemVisitor implements Visitor {

    String output = "";

    @Override
    public void visit (File file) {
        output += "File: " + file.getName() + "\t\t Size: " + file.getSize() + "\t\t Date: " + file.getDate();
        output += "\n";
    }

    @Override
    public void visit (Folder folder) {
        folder.accept ( this );
    }
}
