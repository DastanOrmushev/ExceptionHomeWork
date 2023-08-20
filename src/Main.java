import Exceptions.MyException;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    /*Написать:
    метод, который должен поймать ошибку и вернуть ошибку созданную вами. Словить ее и обработать в классе Main
    метод, который должен быть обработан try catch в реализации impl
    метод, который должен иметь Checked ошибку, которую нужно будет обработать при вызове в классе Main
    Создать свой exception checked и unchecked
    */
    public static void main(String[] args) {
       System.out.println(getNumber());
        showForExample();
        test();
       test2();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Login");
        String login = scanner.next();
        System.out.println("Enter Password");
        String password = scanner.next();
        try {
            auth(login, password);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Log");
        String log = sc.next();
        System.out.println("Enter word");
        String word = sc.next();

        try {
            auth2(log, word);
        }catch (MyException e){
            System.out.println(e.getMessage());
        }



    }

    static int getNumber(){
        try {
            return 1;
        }catch (Exception e){
            return 2;
        }finally {
            return 3;
        }
    }
    static void showForExample(){
        try {
            System.out.println("Example: TRY");
        }catch (Exception e){
            System.out.println("Example: CATCH");
        }finally {
            System.out.println("Example: FINALLY");
        }
    }

    static void test(){
        try {
            throw new RuntimeException("test: Here exception");
        }catch (Exception e){
            System.out.println("test: CATCH");
        }finally {
            System.out.println("test: FINALLY");
        }
    }

    static void test2(){
        try {
            throw new NumberFormatException(" test2: Here exception");
        }catch (RuntimeException exception){
            System.out.println("test2: CATCH"+exception.getMessage());
        }finally {
            System.out.println("test2: FINALLY");
        }
    }

    static void auth (String login, String password){
        if(!login.equals("admin")){
            throw new RuntimeException("Wrong LOGIN");
        }if (!password.equals("1234")){
            throw  new RuntimeException("Wrong PASSWORD");
        }
        System.out.println("Authorization was successful");
    }

    static void auth2 (String log, String word) throws RuntimeException, MyException {
        if(!log.equals("adm")){
            throw new MyException("Login is wrong");
        }if (!word.equals("123")){
            throw  new RuntimeException("Wrong WORD");
        }
        System.out.println("Authorization successful");
    }



}
