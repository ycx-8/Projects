package One_Day_Projects;
import java.util.Scanner;
import java.io.*;;

// Only using variables, conditionals, and loops. Arrays for storing the history of operations + advanced maths operations like mean. No methods. No OOP.

public class Calculator_1_Method {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.println("[+] Welcome to this calcultor built only with var, conditionals, loops and arrays!");
        System.out.println("[+] You can type in the digits 0000 at any time to quit the program");

        //Declare all messages as var
        String enter1stNum = "[+] Enter a number: ";
        String listAllOp = "[+] Here are all the operations you can perform:";
        String opList = "   +   -   *   /   ";
        String enterOp = "[+] Enter the symbol of operation that you want to use: ";
        String enterMoreNum = "[+] Enter another number: ";
        String cannotDivide0 = "[-] A number cannot be divided by 0 - enter another number: ";
        String continueOp = "[?] Continue the operations y/n? ";
        String writeToTxt = "[?] Append the result to a txt file? y/n";
        String invalidInput1 = "[-] Invalid input: type 'y' to continue the operation or 'n' to stop and print out the results:";
        String thankYou = "Thank you for using Chenxi's calculator!";
        String finalOptions = "[?] Enter 1 to perform a new calculation || Enter 2 to read last result || Enter 3 to see result history || Enter 4 to quit ";
        String invalidInput2 = "[-] Invalid input, try again.";

        // Storing history of the results 
        double[] history = new double[50];
        int x = 0;

        // Main loop here
        while(true) {

            // Input 1st number
            System.out.println(enter1stNum);
            int num1 = input.nextInt();
            input.nextLine();
            if (num1 == 0000) System.exit(0);

            // Continual calculations
            double result = num1;
            boolean exit1 = false;

            while (true) {

                // Input operation
                System.out.println(listAllOp);
                // System.out.println();
                System.out.println(opList);
                // System.out.println();
                System.out.println(enterOp);
                String op = input.nextLine();
                if (op.equals("0000")) System.exit(0);

                // Input another number
                System.out.println(enterMoreNum);
                int numX;
                while (true) {
                    numX = input.nextInt();
                    if (numX == 0000) System.exit(0);
                    if (numX == 0 && op.equals("/")) {
                        System.out.println(cannotDivide0);
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
                System.out.println(continueOp);
                while (true) {
                    String continueOrNo = input.nextLine();
                   
                    if (continueOrNo.equals("0000")) {
                        System.exit(0);
                    } else if (continueOrNo.equals("y")) {
                        break;
                    } else if (continueOrNo.equals("n")) {
                        System.out.println("[+] Result of calculation = " + result);
                        history[x] = result;
                        x++;

                        // Write to file
                        System.out.println(writeToTxt);
                        while (true) {
                            String writeOrNo = input.nextLine();
                            try {
                                if (writeOrNo.equals("y")) {
                                    BufferedWriter writeResult = new BufferedWriter(new FileWriter("C:\\Users\\ycx-8\\Desktop\\Result.txt"));
                                    writeResult.write("Result = " + result + "\n\n\n\n");
                                    writeResult.write(thankYou);
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
                        System.out.println(invalidInput1);
                    }
                } 

                if (exit1) break;

            }
            

            // Restart or quit + file i/o
            System.out.println(finalOptions);
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
                        System.out.println(finalOptions);
                        continue;
                        } catch (Exception e) {
                        return;
                    }

                } else if (redoOrQuit == 3) {
                    for (int i=0; i<history.length; i++) {
                        if (history[i] != 0) {
                            System.out.println("Result = " + history[i]);
                        }
                    }
                    System.out.println(finalOptions);
                    continue;
                } else if (redoOrQuit == 4) {
                    input.close();
                    System.exit(0);
                } else {
                    System.out.println(invalidInput2);
                }
    
            }
        }

    }      
}