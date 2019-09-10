
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Dictionary d = new Dictionary();
        Scanner scan = new Scanner(System.in);
        System.out.print("==================Dictionary =================\r\n" + 
                        "Enter 'I' to Insert a definition in the dictionary\r\n" + 
                        "Enter 'L' to Lookup a definition in the dictionary\r\n" + 
                        "Enter 'A' to print All the words in the dictionary\r\n" + 
                        "Enter 'C' to print the Count of all words in the dictionary\r\n" + 
                        "Enter 'Q' to quit the program\r\n" + 
                        "===========================================\r\n" +
                        "Please enter your command: ");
        String input = scan.next();
        while (!input.equalsIgnoreCase("q")) {
            if (!input.equalsIgnoreCase("i") && !input.equalsIgnoreCase("l") && !input.equalsIgnoreCase("a") 
                            && !input.equalsIgnoreCase("a") && !input.equalsIgnoreCase("c")) {
                System.out.println();
                System.out.println("WARNING: Unrecognized command.");
                System.out.println();
                System.out.print("==================Dictionary =================\r\n" + 
                                "Enter 'I' to Insert a definition in the dictionary\r\n" + 
                                "Enter 'L' to Lookup a definition in the dictionary\r\n" + 
                                "Enter 'A' to print All the words in the dictionary\r\n" + 
                                "Enter 'C' to print the Count of all words in the dictionary\r\n" + 
                                "Enter 'Q' to quit the program\r\n" + 
                                "===========================================\r\n" +
                                "Please enter your command: ");
                input = scan.next();
            }
            if (input.equalsIgnoreCase("i")) {
                String word = scan.next();
                try {
                    d.insert(word, scan.nextLine());
                }
                catch (IllegalArgumentException e) {
                    System.out.println();
                    System.out.println("WARNING: failed to insert duplicate word: " + word + ".");
                    System.out.println();
                }
                System.out.println();
                System.out.print("==================Dictionary =================\r\n" + 
                               "Enter 'I' to Insert a definition in the dictionary\r\n" + 
                               "Enter 'L' to Lookup a definition in the dictionary\r\n" + 
                               "Enter 'A' to print All the words in the dictionary\r\n" + 
                               "Enter 'C' to print the Count of all words in the dictionary\r\n" + 
                               "Enter 'Q' to quit the program\r\n" + 
                               "===========================================\r\n" +
                               "Please enter your command: ");
                input = scan.next();
            }
            if (input.equalsIgnoreCase("l")) {
                String word = scan.next();
                if (d.getWordCount() == 0) {
                    System.out.println();
                    System.out.println("There are no definitions in this empty dictionary.");
                    System.out.println();
                }
                else if (d.lookup(word) == null) {
                    System.out.println();
                    System.out.println("No definition found for the word " + word + ".");
                    System.out.println();
                }
                else {
                    System.out.println();
                    System.out.println(word + " - " + d.lookup(word));
                    System.out.println();
                }
                System.out.print("==================Dictionary =================\r\n" + 
                                "Enter 'I' to Insert a definition in the dictionary\r\n" + 
                                "Enter 'L' to Lookup a definition in the dictionary\r\n" + 
                                "Enter 'A' to print All the words in the dictionary\r\n" + 
                                "Enter 'C' to print the Count of all words in the dictionary\r\n" + 
                                "Enter 'Q' to quit the program\r\n" + 
                                "===========================================\r\n" +
                                "Please enter your command: ");
                input = scan.next();
                }
            if (input.equalsIgnoreCase("a")) {
                if (d.getWordCount() == 0) {
                    System.out.println();
                    System.out.println("Dictionary is empty.");
                    System.out.println();
                }
                else {
                    StringBuilder builder = new StringBuilder();
                    int count = 0;
                    for (String value : d.getAllWords()) {
                        if (count != 0) {
                            builder.append(", "); 
                        }
                        builder.append(value);
                        count += 1;
                    }
                    String text = builder.toString();
                    System.out.println();
                    System.out.println(text);
                    System.out.println();
                } 
                System.out.print("==================Dictionary =================\r\n" + 
                                "Enter 'I' to Insert a definition in the dictionary\r\n" + 
                                "Enter 'L' to Lookup a definition in the dictionary\r\n" + 
                                "Enter 'A' to print All the words in the dictionary\r\n" + 
                                "Enter 'C' to print the Count of all words in the dictionary\r\n" + 
                                "Enter 'Q' to quit the program\r\n" + 
                                "===========================================\r\n" +
                                "Please enter your command: ");
                input = scan.next();
            }
            if (input.equalsIgnoreCase("c")) {
                System.out.println();
                System.out.println(d.getWordCount());
                System.out.println();
                System.out.print("==================Dictionary =================\r\n" + 
                                "Enter 'I' to Insert a definition in the dictionary\r\n" + 
                                "Enter 'L' to Lookup a definition in the dictionary\r\n" + 
                                "Enter 'A' to print All the words in the dictionary\r\n" + 
                                "Enter 'C' to print the Count of all words in the dictionary\r\n" + 
                                "Enter 'Q' to quit the program\r\n" + 
                                "===========================================\r\n" +
                                "Please enter your command: ");
                input = scan.next();
            }
        }
        scan.close();
    }
}
