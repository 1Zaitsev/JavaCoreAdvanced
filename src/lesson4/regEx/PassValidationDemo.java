package lesson4.regEx;

import java.util.Scanner;

public class PassValidationDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PassValidation pv = new PassValidation();

        System.out.println("Требования к надежности пароля \n " +
                "1.Использовать буквы латинского алфавита \n " +
                "2.Должна быть хотя бы одна заглавная буква. \n " +
                "3.Должна быть хотя бы одна строчная буква. \n " +
                "4.Должна быть хотя бы одна цифра. \n " +
                "5.Должн быть хотябы один спец.символ. \n " +
                "6.Минимальная длинна пароля - 8 символов. \n" +
                "Введите пароль: ");

        String password = scanner.nextLine();

        while (!pv.validation(password)){
            password = scanner.nextLine();
            System.err.println("Условия не выполнены, повторите попытку");
        }
        System.out.println(" Пароль принят.");
    }
}
