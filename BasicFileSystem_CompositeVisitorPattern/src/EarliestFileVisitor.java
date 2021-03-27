public class EarliestFileVisitor implements Visitor {

    Component earliest = null;

    @Override
    public void visit (File f) {
        if (earliest == null) {
            earliest = f;

        }

        if (f.date.isBefore ( earliest.date )) {
            earliest = f;
        }

    }

    @Override
    public void visit (Folder f) {
        f.accept ( this );

    }
}

