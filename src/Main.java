
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение в формате [a + b]/[V + VII], вместо знака \"+\" может быть любой другой знак (Программа принимает числа только от 1 до 10): ");
        Scanner sc = new Scanner(System.in);
        String mathline = sc.nextLine();
        mathline = calc(mathline);
        System.out.println(mathline);
    }

    private static int a = 0, b = 0, result = 0;
    private static String finalresult;
    private static Roman[] romandar = Roman.values();
    public static String calc(String input) throws Exception {
        String[] numbers = input.split(" ");
        if (numbers.length!=3){
            throw new Exception("Программа может принять только два числа для решения.");
        }

        try{
            if ((Roman.contains(numbers[0])&&Roman.contains(numbers[2]))){
                for (Roman r:romandar){
                    if (r.name().equals(numbers[0])){
                        a = r.ordinal();
                    }
                    else if(r.name().equals(numbers[2])){
                        b = r.ordinal();
                    }
                }
                result = resultint(a,b,numbers[1]);
                if (result<1){
                    throw new Exception("В римской системе нет отрицательных чисел.");
                }
                else {
                    finalresult = Roman.romnum(result);
                }
            }
            else if ((Roman.contains(numbers[0])&&Roman.contains(numbers[2]))==false) {
                a = Integer.parseInt(numbers[0]);
                b = Integer.parseInt(numbers[2]);
                result = resultint(a,b,numbers[1]);
                finalresult = String.valueOf(result);
            }
        }catch(Exception e){
            System.out.println("Используются разные системы счисления.");
        }
        return finalresult;
    }
    public static int resultint(int num1, int num2, String op){ //получить инт результат
        int result=0;
        switch (op) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                try {
                    result = num1 / num2;
                } catch (Exception e) {
                    System.out.println("Не делится :(");
                    break;
                }
                break;
        }
        return result;
    }


}