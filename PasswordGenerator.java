import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the desired length of the password: ");
        int passwordLength = scanner.nextInt();

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecial = scanner.next().equalsIgnoreCase("yes");

        scanner.close();

        String generatedPassword = generatePassword(passwordLength, includeUppercase, includeNumbers, includeSpecial);
        System.out.println("Generated Password: " + generatedPassword);
    }

    public static String generatePassword(int length, boolean includeUppercase, boolean includeNumbers, boolean includeSpecial) {
        String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
        String CHAR_UPPER = CHAR_LOWER.toUpperCase();
        String CHAR_DIGITS = "0123456789";
        String CHAR_SPECIAL = "!@#$%^&*()_+";
       
        StringBuilder charSetBuilder = new StringBuilder(CHAR_LOWER);

        if (includeUppercase) {
            charSetBuilder.append(CHAR_UPPER);
        }

        if (includeNumbers) {
            charSetBuilder.append(CHAR_DIGITS);
        }

        if (includeSpecial) {
            charSetBuilder.append(CHAR_SPECIAL);
        }

        String charSet = charSetBuilder.toString();

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(charSet.length());
            char randomChar = charSet.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
}