The errors you're encountering suggest that the `javac` compiler cannot find the `Person` class when compiling the `Main` class. This typically occurs when the `Person` class is not in the same classpath or package scope as the `Main` class, or when the files are compiled incorrectly.

### Here's what might be happening and how to fix it:

1. **Check Directory Structure**: 
   - The `Main.java` and `Person.java` files are in the `OOP` package, which means the directory structure should match the package declaration. Ensure that both files are located under `src/main/java/OOP` and not just directly under `src/main/java`.

2. **Compilation Command**: 
   - Since both `Main.java` and `Person.java` are in the same package (`OOP`), they need to be compiled together.
   - Instead of running `javac Main.java`, try compiling the entire package:
     ```bash
     javac OOP/*.java
     ```
     This command compiles both `Main.java` and `Person.java` at the same time.

3. **Running the Program**:
   - After compiling, run the `Main` class by including the package name:
     ```bash
     java OOP.Main
     ```

### Example Commands:
```bash
cd c:\Users\isles\Desktop\study\Revature\personal\selenium-continued\src\main\java\
javac OOP/*.java
java OOP.Main
```

### Explanation:
- **`javac OOP/*.java`**: Compiles all Java files in the `OOP` package.
- **`java OOP.Main`**: Runs the `Main` class, specifying the full package name.

By ensuring that both files are compiled together and specifying the correct package name when running the class, the compiler should be able to resolve the `Person` class, and the program should run without errors.