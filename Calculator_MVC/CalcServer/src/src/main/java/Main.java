package src.main.java;

import src.main.java.extraCredit.Node;
import src.main.java.extraCredit.PrintVisitor;

import java.util.ArrayList;

public class Main {
    private static ArrayList<Character> operations = new ArrayList<>(){{
        add('+');
        add('-');
        add('*');
        add('/');
    }};

    public static Node equationConverter(String equation){
        String[] tmp = equation.split("=");
        equation = tmp[0];

        Integer start = 0;
        Node root = null;
        for (int i=0; i<equation.length();i++){
            if (operations.contains(equation.charAt(i))){
                Node op = new Node(String.valueOf(equation.charAt(i)));

                if (root == null) root = op;
                else op.left = root;

                String n = equation.substring(start, i);
                Node num = new Node(n);

                if (root.left == null) root.left = num;
                else root.right = num;

                start = i+1;
                root = op;
            }
        }

        // collect remaining one
        if (root != null) {
            String n = equation.substring(start);
            root.right = new Node(n);
        }
        return root;
    }

    public static String prettyPrintEquation(String equation){
        Node root = Main.equationConverter(equation);
        StringBuilder sb = new StringBuilder();

        PrintVisitor printVisitor = new PrintVisitor();
        printVisitor.queue.add(root);
        printVisitor.visit(root);
        printVisitor.traverseTree(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        CalcServer server = new CalcServer(8081);
        server.startServer();
    }
}

