// Question Explanation:

// writing a Java program to calculate the sum of a list of integers using autoboxing and unboxing, along with methods to parse strings into their respective wrapper classes (e.g., Integer.parseInt()).

// Steps to implement:
// 1. Create a List of Integers: Initialize a List<Integer> to hold the integers.
// 2. Autoboxing: Use autoboxing to convert primitive int values to Integer objects automatically when adding to the list.
// 3. Unboxing: Use unboxing to convert Integer objects back to int for sum calculation.
// 4. Parse Strings: Create a utility method to parse strings to integers using Integer.parseInt().
// 5. Calculate the Sum: Use a loop or Java 8 streams to calculate the sum of the list.

  
// Java Program:
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutoboxingUnboxingSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        
        System.out.println("Enter numbers (type 'done' to finish):");
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                numbers.add(parseInteger(input)); 
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format: " + input);
            }
        }
        
        scanner.close();
        
        // Calculate the sum
        int sum = calculateSum(numbers);
        
        // Display the result
        System.out.println("The sum of the numbers is: " + sum);
    }
    
    // Method to parse string into Integer
    public static Integer parseInteger(String str) {
        return Integer.parseInt(str); 
    }
    
    // Method to calculate the sum
    public static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer num : numbers) {
            sum += num; 
        }
        return sum;
    }
}







// Test Cases:

// Test Case 1:
// Input: 10, 20, 30, "40", "50"
// Expected Output: The sum of the list is: 150
// Description: The list contains a mix of primitive integers and integers parsed from strings.

// Test Case 2:
// Input: "100", "200", "300"
// Expected Output: The sum of the list is: 600
// Description: All values are parsed from strings, and the sum is calculated.

// Test Case 3:
// Input: "50", "invalid", "70"
// Expected Output:
// Invalid number format: invalid
// The sum of the list is: 120
// Description: One of the inputs is not a valid integer, so it's skipped, and the sum of valid values is calculated.
