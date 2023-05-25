import java.util.Scanner;
import java.io.*;;

// Only using variables, conditionals, and loops. Arrays for storing the history of operations + advanced maths operations like mean. No methods. No OOP.

public class Calculator {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.println("[+] Welcome to this calcultor built only with var, conditionals and loops!");
        System.out.println("[+] You can type in the digits 0000 at any time to quit the program");

        // Main loop here
        while(true) {

            // Input 1st number
            System.out.println("[+] Enter a number: ");
            int num1 = input.nextInt();
            input.nextLine();
            if (num1 == 0000) System.exit(0);

            // Continual calculations
            double result = num1;
            boolean exit1 = false;

            while (true) {

                // Input operation
                System.out.println("[+] Here are all the operations you can perform:");
                // System.out.println();
                System.out.println("   +   -   *   /   ");
                // System.out.println();
                System.out.println("[+] Enter the symbol of operation that you want to use: ");
                String op = input.nextLine();
                if (op.equals("0000")) System.exit(0);

                // Input another number
                System.out.println("[+] Enter another number: ");
                int numX;
                while (true) {
                    numX = input.nextInt();
                    if (numX == 0000) System.exit(0);
                    if (numX == 0 && op.equals("/")) {
                        System.out.println("[-] A number cannot be divided by 0 - enter another number: ");
                    } else break;
                } 

                // calculate results + possible print
                if (op.equals("+")) {
                    result += numX;
                }
                if (op.equals("-")) {
                    result -= numX;
                }
                if (op.equals("*")) {
                    result *= numX;
                }
                if (op.equals("/")) {
                    result /= numX;
                }

                // Stop calculation or continue adding operation and numbers
                System.out.println("[?] Continue the operations y/n? ");
                while (true) {
                    String continueOrNo = input.nextLine();
                   
                    if (continueOrNo.equals("0000")) {
                        System.exit(0);
                    } else if (continueOrNo.equals("y")) {
                        break;
                    } else if (continueOrNo.equals("n")) {
                        System.out.println("[+] Result of calculation = " + result);

                        // Write to file
                        System.out.println("Append the result to a txt file? y/n");
                        while (true) {
                            String writeOrNo = input.nextLine();
                            try {
                                if (writeOrNo.equals("y")) {
                                    BufferedWriter writeResult = new BufferedWriter(new FileWriter("C:\\Users\\ycx-8\\Desktop\\Result.txt"));
                                    writeResult.write("Result = " + result + "\n\n\n\n");
                                    writeResult.write("Thank you for using Chenxi's calculator!");
                                    writeResult.close();
                                    break;
                                } else if (writeOrNo.equals("n")) break;
                            } catch (Exception e) {
                                return;
                            }
                        }

                        exit1 = true;
                        break;
                    } else {
                        System.out.println("[-] Invalid input: type 'y' to continue the operation or 'n' to stop and print out the results:");
                    }
                } 

                if (exit1) break;

            }
            

            // Restart or quit + file i/o
            System.out.println("[?] Enter 1 to perform a new calculation || Enter 2 to read last result || Enter 3 to quit ");
            while (true) {
                int redoOrQuit = input.nextInt();
                input.nextLine();
                if (redoOrQuit == 0000) System.exit(0);
                if (redoOrQuit == 1) {
                    break;
                } else if (redoOrQuit == 2) {
                    try {
                        BufferedReader readResult = new BufferedReader(new FileReader("C:\\Users\\ycx-8\\Desktop\\Result.txt"));
                        String fileResult = "";
                        while ( (fileResult = readResult.readLine()) != null) {
                            System.out.println(fileResult);
                        }
                        readResult.close();
                        System.out.println("[?] Enter 1 to perform a new calculation || Enter 2 to read last result || Enter 3 to quit ");
                        continue;
                        } catch (Exception e) {
                        return;
                    }

                } else if (redoOrQuit == 3) {
                    input.close();
                    System.exit(0);
                } else {
                    System.out.println("[-] Invalid input, try again.");
                }
    
            }
        }

    }
        
}