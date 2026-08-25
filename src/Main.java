import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class ExceptionPropagationDemo {
    public static void levelThree() {
        int result = 10 / 0;
    }

    public static void levelTwo() {
        levelThree();
    }

    public static void levelOne() {
        levelTwo();
    }

    public static void main(String[] args) {
        try {
            levelOne();
        } catch (ArithmeticException e) {
            System.out.println("Exception propagated up to main and was caught successfully!");
        }
    }
}

class SequelException extends Exception {
    public SequelException(String message) {
        super(message);
    }
}

class GameValidator {
    public static void validateGame(String gameTitle) throws SequelException {
        if (gameTitle.matches(".*\\d.*")) {
            throw new SequelException("Error: Sequels with numbers in the title are not allowed!");
        } else {
            System.out.println("Game accepted: " + gameTitle);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // 🧩 Task 1: Divide Two Numbers

        // AI example

        /*
        int numerator = 10;
        int denominator = 0; // This will trigger an error

        try {
            // Attempting the illegal operation
            int result = numerator / denominator;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            // This block wakes up ONLY if an ArithmeticException happens above
            System.out.println("Oops! You cannot divide by zero.");
        }

        System.out.println("Program continues running smoothly ins
         */

        /*


        What I Understood : We have 2 variables recieved from the user
        If num2 is zero , we throw Arthemtic Exception handled by the catch to inform
        the user of the situation
         */

        // My Solution
        Scanner s = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        while (true) {

            System.out.println("Please Enter First Number");
            num1 = s.nextInt();
            System.out.println("Please Enter Second Number");
            num2 = s.nextInt();

            try {
                int result = num1 / num2;
                System.out.println("Result of Division : " + result);
                break;
            } catch (ArithmeticException e) {
                System.out.println("Please make sure the second num is not Zero");
            }

        }

        //----------------------------------------------------------------------------------------------
        // 🧩 Task 2: Convert String to Integer

        /*
        AI Example :

        String badInput = "hello123";

        try {
            // Attempting to convert a non-numeric string into an integer
            int number = Integer.parseInt(badInput);
            System.out.println("Converted number: " + number);

        } catch (NumberFormatException e) {
            // This catches the error if the string isn't a valid integer
            System.out.println("Oops! That is not a valid integer format.");
        }
         */


        /*
        What I Understood : This program handles inputs that are not valid
        to convert to Int
         */
        //---------------------------------------------------------------------------------------------------------
        // My Solution :

        Scanner b = new Scanner(System.in);
        String input = "";
        while (true) {
            System.out.println("Please Enter String to convert ");
            input = b.nextLine();

            try {
                int converted = Integer.parseInt(input);
                System.out.println("String converted: " + converted);
                break;

            } catch (NumberFormatException e) {
                System.out.println("Invalid input to convert. Please try again.");
            }
        }

        //---------------------------------------------------------------------------------------------------


        // 🧩 Task 3: Null Pointer


            /* AI Example
                    String text = null; // The variable points to nothing

        try {
            // Attempting to call a method on a null object
            int length = text.length();
            System.out.println("Length: " + length);

        } catch (NullPointerException e) {
            // This catches the error when an object is null
            System.out.println("Oops! You tried to use an object that was null.");
        }
             */

        // My Understanding : Using NullPointer Exception confirms that the input is never NULL


        // My Solution:


        Scanner c = new Scanner(System.in);
        String Word = null;
        System.out.println("Please Enter String to measure length");
        try {
            Word = c.nextLine();
            int length = Word.length();
            System.out.println("Length :" + length);

        } catch (NullPointerException e) {
            System.out.println("Please enter a non Null value !");
        }

        //----------------------------------------------------------------------------------------------------
        // 🧩 Task 4: Access Array Element

            /*
            AI Example :

            public class ArrayDemo {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30}; // Valid indexes are 0, 1, and 2

        try {
            // Attempting to access an index that is out of bounds
            int invalidElement = numbers[5];
            System.out.println("Element: " + invalidElement);

        } catch (ArrayIndexOutOfBoundsException e) {
            // This catches the error when you look past the end of an array
            System.out.println("Oops! You tried to access an index outside the array bounds.");
        }
    }
}
             */



        // My Understanding : IndexOutofBound Expections are used when trying to add more than an arrays limit.



        // My Solution :
        String[] Personas = new String[3];
        Scanner d = new Scanner(System.in);
        String persona = "";
        try {
            for (int i = 0; i < 5; i++) {
                persona = d.nextLine();
                Personas[i] = persona;

            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Persona Limit Reached.");
        }

        //---------------------------------------------------------------------------------

//          🧩 Task 5: Read File

        /* AI Example

        import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileDemo {
    public static void main(String[] args) {
        try {
            // Attempting to open a file that may not exist on your computer
            File myFile = new File("notes.txt");
            Scanner fileReader = new Scanner(myFile);

            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                System.out.println(data);
            }
            fileReader.close();

        } catch (FileNotFoundException e) {
            // This catches the error if the file path is invalid or missing
            System.out.println("Oops! That file does not exist.");
        }
    }
}

         */

        // My Understanding : This exception is used if the file does not exist


        // My Solution :

        File rosterFile = new File("wwe_roster.txt");

        try {
            Scanner reader = new Scanner(rosterFile);
            System.out.println("Reading roster file...");

            while (reader.hasNextLine()) {
                String superstar = reader.nextLine();
                System.out.println("Superstar: " + superstar);
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: The wrestling roster file could not be found!");
        }

//                🧩 Task 6: Multiple Catch Blocks

        /*
        AI Example :
        public class MultipleCatchDemo {
    public static void main(String[] args) {
        String text = null; // Triggers NullPointerException
        int denominator = 0; // Triggers ArithmeticException

        try {
            // If this line runs, it throws a NullPointerException immediately
            int length = text.length();

            // If text wasn't null, this line could throw an ArithmeticException
            int result = 10 / denominator;

        } catch (NullPointerException e) {
            // This wakes up ONLY if a NullPointerException happens
            System.out.println("Error: You tried to use a null object!");

        } catch (ArithmeticException e) {
            // This wakes up ONLY if an ArithmeticException happens
            System.out.println("Error: Math error (like dividing by zero)!");
        }
    }
}

         */

        // My UnderStanding : We use more than one catch per specific Execption handled


        // My Solution :

        Scanner team = new Scanner(System.in);
        Scanner wins = new Scanner(System.in);
        Scanner matches = new Scanner(System.in);

        System.out.println("Please enter wins:");
        int Wins = wins.nextInt();
        System.out.println("Please Enter losses");
        int Matches = matches.nextInt();

        try {
            String Team = null;
            int nameLength = Team.length();
            int result = (Wins / Matches) * 100;
            System.out.println("Win Ratio : " + result);
        } catch (NullPointerException e) {
            System.out.println("Make sure team has a value");
        } catch (ArithmeticException e) {
            System.out.println("Please make sure matches is not zero");
        }

//-----------------------------------------------------------------------------------
        // 🧩 Task 7: Create a Custom Exception
        //Create a custom exception InvalidAgeException. If user age < 18, throw the exception.
        /*
        AI Example :
        // 1. Create your custom exception class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message); // Pass the error message up to the parent Exception class
    }
}

public class CustomExceptionDemo {
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            // Manually throw the custom exception
            throw new InvalidAgeException("Age must be at least 18.");
        } else {
            System.out.println("Access granted! Age is valid.");
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(15); // This will trigger the exception
        } catch (InvalidAgeException e) {
            // Catch and handle your custom exception
            System.out.println("Caught Custom Exception: " + e.getMessage());
        }
    }
}
         */

        // My Understanding : to create an Exception, it needs to extend from the Exception class.


        // My Solution :

        // check SequelException and GameValidator classes above.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a game title:");
        String title = scanner.nextLine();

        try {
            GameValidator.validateGame(title);
        } catch (SequelException e) {
            System.out.println(e.getMessage());
        }

        // 🧩 Task 9: Propagate Exception (check ExceptionPropagation Demo Above)



    }
}