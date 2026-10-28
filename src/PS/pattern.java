
package PS;

import java.util.regex.Pattern;

class pattern {

    static boolean matches(String PASSWORD_REGEX, String pass) {
        return Pattern.matches(PASSWORD_REGEX, pass);
    }
}
