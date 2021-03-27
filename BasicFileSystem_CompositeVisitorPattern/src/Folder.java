import java.util.ArrayList;

public class Folder extends Component {


    public ArrayList <Component> components = new ArrayList <> ( );

    public void add (Component c) {
        this.components.add ( c );
    }

    public void remove (Component c) {
        this.components.remove ( c );
    }

    public void accept (Visitor visitor) {

        for (Component c : components) {
            c.accept ( visitor );
        }
    }

}
