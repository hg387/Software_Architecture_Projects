package src.main.java.extraCredit;

public class Node {
    public String exp;
    public Node left = null;
    public Node right = null;

    public Node(String exp) {
        this.exp = exp;
    }

    public void accept(Visitor visitor){
        visitor.visit(this);
    };
}