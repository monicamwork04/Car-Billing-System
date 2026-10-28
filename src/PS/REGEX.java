
package PS;
import java.util.regex.Pattern;


public class REGEX {
    
    private static final String Phone_regex
            ="^[6-9]\\d{9}$";
    
    private static final String EMAIL_REGEX
         ="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$";
    
private static final String PASSWORD_REGEX
="^(?=.*[0-9])(?=.[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{4,}$";


public static boolean is_phone_valid(String phone)
{
    return pattern.matches(Phone_regex,phone);
}

public static boolean is_email_valid(String email)
{
    return pattern.matches(EMAIL_REGEX,email);
}

public static boolean is_pass_valid(String pass)
{
    return pattern.matches(PASSWORD_REGEX,pass);
}
}