Here’s a demonstration of common `Scanner` read commands in Java:

```java
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        // Create a new Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // nextLine() - Reads a full line of input
        System.out.print("Enter a full sentence: ");
        String line = scanner.nextLine();
        System.out.println("You entered: " + line);

        // next() - Reads a single word (until space or newline)
        System.out.print("Enter a single word: ");
        String word = scanner.next();
        System.out.println("You entered: " + word);

        // nextInt() - Reads an integer
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        System.out.println("You entered: " + number);

        // nextDouble() - Reads a double (floating-point number)
        System.out.print("Enter a decimal number: ");
        double decimal = scanner.nextDouble();
        System.out.println("You entered: " + decimal);

        // nextBoolean() - Reads a boolean value (true/false)
        System.out.print("Enter true or false: ");
        boolean bool = scanner.nextBoolean();
        System.out.println("You entered: " + bool);

        // next().charAt(0) - Reads a single character
        System.out.print("Enter a single character: ");
        char character = scanner.next().charAt(0);
        System.out.println("You entered: " + character);

        // Close the scanner
        scanner.close();
    }
}
```

### Key `Scanner` methods used:
1. `scanner.nextLine()`: Reads a whole line of input.
2. `scanner.next()`: Reads the next word, stopping at spaces or newlines.
3. `scanner.nextInt()`: Reads the next integer input.
4. `scanner.nextDouble()`: Reads a floating-point number (decimal).
5. `scanner.nextBoolean()`: Reads a boolean (either `true` or `false`).
6. `scanner.next().charAt(0)`: Reads a single character from input.

Each method reads specific types of input, and this example shows how to use them to gather different types of data.