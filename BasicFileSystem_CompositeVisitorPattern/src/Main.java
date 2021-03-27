import java.time.LocalDateTime;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public strictfp static void main (String... args) {
        //calls file system function
        fileSystem();
    }

    //function to create folder
    static void createFolder(Folder folder, String name, int hours) {
        folder.setName(name);
        folder.setDate(LocalDateTime.now ( ).plusHours ( hours ));
    }

    //function to create file
    static void createFile(File file, String name, String size, int hours) {
        file.setName(name);
        file.setSize(size);
        file.setDate(LocalDateTime.now ( ).plusHours ( hours ));
    }

    //function to list files
    static void listFiles(Folder folder)
    {
        FileSystemVisitor v = new FileSystemVisitor ( );
        v.visit ( folder );
        System.out.println ( "List of files in " + folder.getName() + ": " );
        System.out.println ( v.output );
    }

    //function to count files
    static void countFiles(Folder folder)
    {
        FileCountVisitor v = new FileCountVisitor ( );
        v.visit ( folder );
        System.out.println ( "File count of " + folder.getName() + ": " + v.count );
    }

    static void fileSystem ()
    {
        //initialize a file system with 2 layers, 2 folders and 2 files in each folder
        Folder folder1 = new Folder ( );
        createFolder( folder1, "folder1", 1);

        Folder folder2 = new Folder ( );
        createFolder( folder2, "folder2", 2);
        folder1.add ( folder2 );

        File file1 = new File ( );
        createFile( file1, "file1","10", 1);
        folder1.add ( file1 );

        File file2 = new File ( );
        createFile( file2, "file2","20", 2);
        folder1.add ( file2 );

        File file3 = new File ( );
        createFile( file3, "file3","30",3);
        folder2.add ( file3 );

        File file4 = new File ( );
        createFile( file4, "file4","40", 4);
        folder2.add ( file4 );

        System.out.println ( "** Default files and folders created **" );

        countFiles(folder1);
        countFiles(folder2);

        System.out.println ( "***************************************" );

        //list files in folder1
        listFiles(folder1);

        //list files in folder2
        listFiles(folder2);

        System.out.println ( "***************************************" );

        //earliest file in folder 1
        EarliestFileVisitor v = new EarliestFileVisitor( );
        v.visit ( folder1 );
        System.out.println ( "Earliest file '" + v.earliest.name + "' was created on: " + v.earliest.date );

        System.out.println ( "***************************************" );

        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to create a file? (y or n)");
        String option = input.next();
        if(option.equals("y")||option.equals("yes")||option.equals("Y")||option.equals("Yes"))
        {
            System.out.println("How many files do you want to create in folder1(example - 1,2,etc) (type 0 to exit)?");
            int n = input.nextInt();
            for(int i = 1; i <= n; i++) {
                File file = new File ( );
                System.out.println ( "Create a file (type file name): " );
                String filename = input.next();
                createFile( file, filename, "50",5);
                folder1.add ( file );
            }

            System.out.println ( "***************************************" );

            //list files in folder1
            listFiles(folder1);

            System.out.println ( "***************************************" );

        }
        else {
            exit(0);
        }
    }
}
