import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в приложение 'Калькулятор счета'.");
        Scanner sc = new Scanner(System.in);
        System.out.println("На сколько человек необходимо разделить счёт?");
        int numberOfPeople;
        while (true) {
            System.out.println("Введите целое число, больше единицы:");
            if (sc.hasNextInt()) {
                numberOfPeople = sc.nextInt();
                if (numberOfPeople > 1) {
                    System.out.println("Счет будет разделен на "+numberOfPeople);
                    break;
                } else if (numberOfPeople == 1) {
                    System.out.println("На одного счет делить не будем :)");
                }
                System.out.println("Пожалуйста введите корректное значение.");
            }
            sc.nextLine();
        }
             System.out.println("Теперь введите название товара и его стоимость");
        Calculator.dobavimImyaProducta();
        Calculator.dobavimStoimist ();
        String answer = null;
        while (true){
            System.out.println("хотите добавить еще продукты введите любой символ? Если нет, напишите Завершить");
            Scanner sca = new Scanner(System.in);
            answer=sca.nextLine();
            if (answer.equalsIgnoreCase("Завершить")) {
                System.out.println("Добавленные товары:");
                Iterator<String> iterator = Calculator.spisocImen.iterator();
                        while (iterator.hasNext()) {
                String element = iterator.next();
                           System.out.println(element);
                            }
                                  break;
           }else {
            Calculator.dobavimImyaProducta();
            Calculator.dobavimStoimist ();}
       }
        Calculator.sumFinish(numberOfPeople);
            }
          }

class Calculator {
    static ArrayList<String> spisocImen = new ArrayList<>();

    public static void dobavimImyaProducta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите наименование товара: ");
        String X1 = sc.nextLine();
        spisocImen.add(X1);
        System.out.printf("Товар %s добавлен в список.", X1);
    }

    static ArrayList<Float> spisocCen = new ArrayList<>();

    public static void dobavimStoimist() {
        Scanner sc = new Scanner(System.in);
        float cost;
        while (true) {
            System.out.println("\nВведите цену товара: ");
            while (!sc.hasNextFloat()) {
                System.out.println("Ошибка!");
                sc.next();
            }
            cost = sc.nextFloat();
            while (cost <= 0) {
                System.out.println("Ошибка! Введено отрицательное значение или 0.");
                cost = Float.parseFloat(sc.next());
            }
            spisocCen.add(cost);
            System.out.println("Цена товара добавлена в список.");
            break;
        }
    }

    public static void sumFinish(int numberOfPeople) {
        float sum = 0;
        for (int i = 0; i < spisocCen.size(); i++) {
            sum = sum + spisocCen.get(i);
        }
        float sumFinal = sum / numberOfPeople;
        System.out.printf("Каждый должен заплатить %.2f %s",sumFinal,rubl(sumFinal));
    }

    static Object rubl(float sumFinal) {
            int lastDigit = (int) (sumFinal % 10);
            int lastTwoDigits = (int) (sumFinal % 100);
            if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
                return "рублей";
            }
            if (lastDigit == 1) {
                return "рубль";
            }
            if (lastDigit >= 2 && lastDigit <= 4) {
                return "рубля";
            }
            return "рублей";
            }
}
