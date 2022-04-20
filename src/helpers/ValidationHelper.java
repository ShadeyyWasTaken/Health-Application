package helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationHelper {

    public static boolean passwordChecker(String password)
    {
        // 1 Capital Letter
        // 1 Small Letter
        // 1 Special symbol
        // 1 Digit
        // At least 6 characters
        // Maximum 16 characters
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{6,16}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    public static boolean emailChecker(String email)
    {
        //Small Letters, Capital Letters, Numbers, Symbols (._%+-)
        //@
        //Small Letters, Capital Letters, Numbers, Symbols (.-) at least 2

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public static String dateChecker(String date)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate todayDate = LocalDate.parse(date, formatter);
            return formatter.format(todayDate);

        }
        catch (DateTimeParseException ex)
        {
            return null;
        }

    }
}
