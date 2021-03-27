public class File extends Component {

    @Override
    public void accept (Visitor visitor) {
        visitor.visit ( this );
    }
}


