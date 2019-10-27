package lesson4.regEx;

import java.util.regex.*;

public class PassValidation {
    /*
    1.Должна быть заглавная буква.
    2.Должна быть цифра.
    3.Минимум 8 символов
    4.Латиница
    5.Спец.символы
     */
    boolean validation(String password){
        Pattern pattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\p{Punct}).{8,})");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
