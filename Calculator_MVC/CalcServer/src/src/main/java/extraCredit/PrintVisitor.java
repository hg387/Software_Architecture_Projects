package src.main.java.extraCredit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintVisitor implements  Visitor{
    public Queue<Node> queue = new LinkedList<Node>();
    private ArrayList<String> operations = new ArrayList<>(){{
        add("+");
        add("-");
        add("*");
        add("/");
    }};

    @Override
    public void visit(Node node) {
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);

        if (node.right != null) node.right.accept(this);
        if (node.left != null) node.left.accept(this);
    }

    public void traverseTree(StringBuilder sb){
        if (!queue.isEmpty()) {
            Node tmpNode = queue.poll();
            sb.append(tmpNode.exp);
        }

        while (!queue.isEmpty()){
            sb.append("\n").append("|").append(" \\\n");
            Node lNode = queue.poll();
            Node rNode = queue.poll();
            sb.append(lNode.exp).append("  ").append(rNode.exp);
        }
    }

    public static void tester(){
        /*

         *
         | \
         +   9
         | \
         3   4

         */
        PrintVisitor visitor = new PrintVisitor();
        StringBuilder sb = new StringBuilder();

        visitor.queue.add(new Node("*"));
        visitor.queue.add(new Node("+"));
        visitor.queue.add(new Node("9"));
        visitor.queue.add(new Node("3"));
        visitor.queue.add(new Node("4"));

        visitor.traverseTree(sb);
        System.out.println(sb.toString());
    }


}
