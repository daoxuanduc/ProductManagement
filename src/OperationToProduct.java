import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OperationToProduct {
    String output="";
    public void outputMenu() {
        output+="\n";
        output+="Choose one of this options:\n";
        output+="Product list:\n";
        output+="1. Load data from file and display\n";
        output+="2. Input & add to the end.\n";
        output+="3. Display data\n";
        output+="4. Save product list to file.\n";
        output+="5. Search by ID\n";
        output+="6. Delete by ID\n";
        output+="7. Sort by ID.\n";
        output+="8. Convert to Binary\n";
        output+="9. Load to stack and display\n";
        output+="10. Load to queue and display.\n";
        output+="0. Exit\n";
        output+="\n";
        output+="Choice: ";
    }
    public int index(Product p, MyList<Product> list) {
        Node<Product> currentNode = list.head;
        int i = -1;
        while (currentNode.info!=p) {
            i++;
            currentNode = currentNode.next;
        }
        if (i==-1) return -1;
        else return i+1;
    }

    public Product createProduct() {
        Scanner sc = new Scanner(System.in);
        Product p = new Product();
        System.out.print("Insert product's code: ");
        p.bcode = sc.nextLine();
        output+="Insert product's code: "+p.bcode+"\n";
        System.out.print("Insert product's title: ");
        p.title = sc.nextLine();
        output+="Insert product's title: "+p.title+"\n";
        System.out.print("Insert product's quantity: ");
        p.quantity = sc.nextInt();
        output+="Insert product's quantity: "+p.quantity+"\n";
        System.out.print("Insert product's price: ");
        p.price = sc.nextDouble();
        output+="Insert product's price: "+p.price+"\n";
        return p;
    }

    public void getAllItemsFromFile(String fileName, MyList<Product> list) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        int i=0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            i++;
            if (i>2) {
                String[] s = new String[20];
                String d="";
                int k=0;
                for (int j=0;j<line.length();j++) {
                    if (line.charAt(j)=='|') {
                        s[k]=d;
                        k++;
                        d="";
                    }
                    else
                        d+=line.charAt(j);
                }
                s[k]=d;
                for (int j = 0;j<=k;j++) {
                    s[j] = s[j].trim();
                }
                Product p = new Product(s[0],s[1],Integer.parseInt(s[2]),Double.parseDouble(s[3]));
                list.insert(p);
            }
        }
    }

    public void getAllItemsFromFile(String fileName, MyStack<Product> stack) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        int i=0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            i++;
            if (i>2) {
                String[] s = new String[20];
                String d="";
                int k=0;
                for (int j=0;j<line.length();j++) {
                    if (line.charAt(j)=='|') {
                        s[k]=d;
                        k++;
                        d="";
                    }
                    else
                        d+=line.charAt(j);
                }
                s[k]=d;
                for (int j = 0;j<=k;j++) {
                    s[j] = s[j].trim();
                }
                Product p = new Product(s[0],s[1],Integer.parseInt(s[2]),Double.parseDouble(s[3]));
                stack.push(p);
            }
        }
    }

    public void getAllItemsFromFile(String fileName, MyQueue<Product> queue) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        int i=0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            i++;
            if (i>2) {
                String[] s = new String[20];
                String d="";
                int k=0;
                for (int j=0;j<line.length();j++) {
                    if (line.charAt(j)=='|') {
                        s[k]=d;
                        k++;
                        d="";
                    }
                    else
                        d+=line.charAt(j);
                }
                s[k]=d;
                for (int j = 0;j<=k;j++) {
                    s[j] = s[j].trim();
                }
                Product p = new Product(s[0],s[1],Integer.parseInt(s[2]),Double.parseDouble(s[3]));
                queue.enqueue(p);
            }
        }
    }

    public void addLast(MyList<Product> list) {
        Product p =createProduct();
        list.insert(p);
    }

    public void displayAll(MyList<Product> list) {
        System.out.println("ID |  Title   | Quantity | price");
        System.out.println("--------------------------------");
        output+="ID |  Title   | Quantity | price\n";
        output+="--------------------------------\n";
        Node<Product> currentNode = list.head;
        while (currentNode!=null) {
            System.out.println(currentNode.toString());
            output+=currentNode.toString()+"\n";
            currentNode = currentNode.next;
        }
    }

    public void displayAll(MyStack<Product> stack) {
        System.out.println("ID |  Title   | Quantity | price");
        System.out.println("--------------------------------");
        output+="ID |  Title   | Quantity | price\n";
        output+="--------------------------------\n";
        Node<Product> currentNode = stack.head;
        while (currentNode!=null) {
            System.out.println(currentNode.toString());
            output+=currentNode.toString()+"\n";
            currentNode = currentNode.next;
        }
        System.out.println();
        System.out.println("Successfully!");
        output+="\nSuccessfully!\n";
    }

    public void displayAll(MyQueue<Product> queue) {
        System.out.println("ID |  Title   | Quantity | price");
        System.out.println("--------------------------------");
        output+="ID |  Title   | Quantity | price\n";
        output+="--------------------------------\n";
        Node<Product> currentNode = queue.head;
        while (currentNode!=null) {
            System.out.println(currentNode.toString());
            output+=currentNode.toString()+"\n";
            currentNode = currentNode.next;
        }
        System.out.println();
        System.out.println("Successfully!");
        output+="\nSuccessfully!\n";
    }

    public void writeAllItemsToFile(String fileName, MyList<Product> list) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        String fileContent = "ID |  Title   | Quantity | price\n--------------------------------\n";
        Node<Product> currentNode = list.head;
        while (currentNode!=null) {
            fileContent+=currentNode.toString()+"\n";
            currentNode=currentNode.next;
        }
        writer.write(fileContent);
        writer.close();
        System.out.println("Successfully!");
        output+="Successfully!\n";
    }

    public void searchById(MyList<Product> list) {
        System.out.print("Input the ID to search: ");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        output+="Input the ID to search: "+id+"\n";
        Node<Product> currentNode = list.head;
        boolean isFound = false;
        while (currentNode!=null) {
            if (currentNode.info.bcode.equals(id)) {
                isFound=true;
                System.out.println("Result: "+currentNode.toString());
                output+="Result: "+currentNode.toString()+"\n";
                break;
            }
            else {
                currentNode = currentNode.next;
            }
        }
        if (isFound==false) {
            System.out.println("Result: Not found!");
            output+="Result: Not found!\n";
        }
    }

    public void deleteById(MyList<Product> list) {
        System.out.print("Input the bcode to delete: ");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        output+="Input the bcode to delete: "+id+"\n";
        Node<Product> currentNode = list.head;
        Node<Product> previousNode = list.head;
        boolean isFound = false;
        while (currentNode!=null) {
            if (currentNode == list.head) {
                if (currentNode.info.bcode.equals(id)) {
                    isFound=true;
                    list.head = list.head.next;
                    System.out.println("Deleted!");
                    output+="Deleted!\n";
                    break;
                }
            }
            if (currentNode.info.bcode.equals(id)) {
                isFound=true;
                previousNode.next = currentNode.next;
                currentNode.next=null;
                System.out.println("Deleted!");
                output+="Deleted!\n";
                break;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        if (isFound==false) {
            System.out.println("Not found!");
            output+="Not found!\n";
        }
    }

    int compare(String a,String b) {
        int i=0;
        int compare = 0;
        a+=" ";
        b+=" ";
        while (i<=a.length()&&i<=b.length()) {
            compare = Character.compare(a.charAt(i),b.charAt(i));
            if (compare!=0) return compare;
            i++;
        }
        return compare;
    }

    public void sortById(MyList<Product> list) {
        Node<Product> currentNode = list.head;
        while (currentNode!=null) {
            Node<Product> nextNode = currentNode.next;
            Node<Product> minNode = currentNode;
            while (nextNode!=null) {
                if (compare(minNode.info.bcode,nextNode.info.bcode)>0) {
                    minNode = nextNode;
                }
                nextNode = nextNode.next;
            }
            if (minNode!=null) {
                list.swap(currentNode,minNode);
            }
            currentNode = currentNode.next;
        }
        System.out.println("Successfully!");
        output+="Successfully!\n";
    }

    public void addFirst(MyList<Product> list) {
        //list.insert(createProduct());
    }

    public String convertToBinary(int i) {
        String s;
        if (i==0)
            return "";
        else
            return convertToBinary(i/2)+i%2;
    }


}
