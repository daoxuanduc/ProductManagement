import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void showMenu() {
        System.out.println();
        System.out.println("Choose one of this options:");
        System.out.println("Product list:");
        System.out.println("1. Load data from file and display");
        System.out.println("2. Input & add to the end.");
        System.out.println("3. Display data");
        System.out.println("4. Save product list to file.");
        System.out.println("5. Search by ID");
        System.out.println("6. Delete by ID");
        System.out.println("7. Sort by ID.");
        System.out.println("8. Convert to Binary");
        System.out.println("9. Load to stack and display");
        System.out.println("10. Load to queue and display.");
        System.out.println("0. Exit");
        System.out.println();
        System.out.print("Choice: ");
    }
    public static void main(String[] args) throws IOException {
        int choice;
        Scanner sc = new Scanner(System.in);
        MyList<Product> list = new MyList<>();
        MyStack<Product> stack = new MyStack<>();
        MyQueue<Product> queue = new MyQueue<>();
        OperationToProduct p = new OperationToProduct();
        while (true) {
            showMenu();
            p.outputMenu();
            choice = sc.nextInt();
            System.out.println();
            p.output+=choice+"\n\n";
            if (choice==0) {
                File output = new File("src/output.txt");
                FileWriter writer = new FileWriter(output);
                writer.write(p.output);
                writer.close();
                break;
            }
            switch (choice) {
                case (1):
                    list = new MyList<>();
                    p.getAllItemsFromFile("src/data.txt",list);
                    p.displayAll(list);
                    //System.out.println(p.output);
                    break;
                case (2):
                    p.addLast(list);
                    break;
                case (3):
                    p.displayAll(list);
                    break;
                case (4):
                    p.writeAllItemsToFile("src/data.txt",list);
                    break;
                case (5):
                    p.searchById(list);
                    break;
                case (6):
                    p.deleteById(list);
                    break;
                case (7):
                    p.sortById(list);
                    break;
                case (8):
                    System.out.println("Quantity = "+list.head.info.quantity+" => ("+p.convertToBinary(list.head.info.quantity)+")");
                    p.output+="Quantity = "+list.head.info.quantity+" => ("+p.convertToBinary(list.head.info.quantity)+")\n";
                    break;
                case (9):
                    stack = new MyStack<>();
                    p.getAllItemsFromFile("src/data.txt",stack);
                    p.displayAll(stack);
                    break;
                case (10):
                    queue = new MyQueue<>();
                    p.getAllItemsFromFile("src/data.txt",queue);
                    p.displayAll(queue);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    p.output+="Invalid choice. Please try again.\n";
                    break;
            }
        }
    }
}
