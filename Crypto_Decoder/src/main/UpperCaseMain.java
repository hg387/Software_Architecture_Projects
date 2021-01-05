package main;

public class UpperCaseMain {

    public static void main(String[] args) {
        System.out.println("--- Welcome to Lab 1 ---");

        //Creat a pipe between a Generator and Filter
        Pipe fakeInputPipe = new PipeImpl();
        Pipe pipe = new PipeImpl();
        Pipe fakeOutputPipe = new PipeImpl();

        //create the Generator and Filter
        Generator generator = new Generator(fakeInputPipe, pipe);
        Filter filter = new UpperCaseConverter(pipe, fakeOutputPipe, "output.txt");

        //start the generator and the filter
        generator.start();
        filter.start();

        generator.stop();
        filter.stop();
    }
}
