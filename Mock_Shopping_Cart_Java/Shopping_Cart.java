package Mock_Shopping_Cart_Java;
// Challenge: only using variables, conditionals, loops and arrays, and nothing else!
// Create a console-based program that simulates a simple shopping cart in a grocery store. You can use an array to represent the shopping cart. Each slot in the array can contain the name of an item (like "Apple", "Bread", etc.).
import java.util.Scanner;

public class Shopping_Cart {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] cart = new String[10];

        //Main program
        boolean userIn = true;
        while (userIn) {

            System.out.println("[+] Welcome to your shopping cart");
            System.out.println("[1] Add item ----- [2] Remove item ----- [3] View Cart ----- [4] Checkout");
            System.out.println("Please select an option by typing in the corresponding number: ");

            int userDecision = input.nextInt();
            
            // Add item
            if (userDecision == 1) {
                int i = 0;
                while (cart.length < 10) {
                    
                    cart[i] = input.nextLine();
                    i++;

                    if (i == 9) {
                    System.out.println("[-] Your cart is full!");
                    } 
                }
            }

            // Remove item
            if (userDecision == 2) {
                boolean goBack = false;

                while (goBack) {
                    System.out.println("Which item do you want to remove?");
                    String item2Remove = input.nextLine();
                    
                    // find the item and "remove" it
                    for (int i=0; i<cart.length; i++) {
                        if (cart[i].equals(item2Remove)) {
                            cart[i] = "Empty";
                        }
                    }
                    
                    // Remove more or back to main menu
                    System.out.println("[1] Remove more items ----- [2] Back to main menu");
                    
                    while (true) {
                        int removeOrBack = input.nextInt();
                        if (removeOrBack != 1 || removeOrBack != 2) {
                            System.out.println("Invalid input: please enter 1 or 2");
                        } else if (removeOrBack == 1) {


                        }
                    } 

                }

            }
        }
            
          


        


        




    }
}