package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст: ");
        String message = scanner.nextLine();
        System.out.println("Введите шаг дешифровки: ");
        int step = scanner.nextInt();
        System.out.println("Введите язык (EN или RU: ");
        String lang = scanner.next();

        System.out.println("Результат шифровки: " + Caesar(message, step, lang));
    }

    public static String Caesar(String mssg, int step, String lang) {
        String alphabet_RU = "АаБбВвГгДдЕеЁёЖжЗзИиЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЪъЫыЬьЭэЮюЯя";
        String alphabet_EN = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
        String result = "";
        char symbol_mssg;
        char symbol_found;
        int number;
        int index;

        for (int i=0; i<mssg.length(); i++) { //повторяем, пока в слове есть символы
            //при каждой слдующей итерации переходим на следующий символ

            symbol_mssg = mssg.charAt(i); //берем символ под номером i

            //определяем используемый алфавит
            if (lang.equals("RU")) {
                while (step>33) { //условие, если было передан шаг шифрования больший,
                    // чем размер алфавита
                    step = step - 33;
                }
                while (step<-33) { //условие, если было передан шаг шифрования меньший,
                    // чем размер алфавита
                    step = step + 33;
                }
                number = alphabet_RU.indexOf(symbol_mssg); //определяем номер символа в нашем
                //алфавите
                index = number + step*2; //к номеру прибавляем шаг*2 т.к. в алфавите есть и строчные
                //и заглавные буквы
                if (step<0 && index<0) {
                    index = 66 + index; //исключение для отрицательного шага
                }
                symbol_found = alphabet_RU.charAt(index);
            }
            if (lang.equals("EN")) {
                while (step>26) { //условие, если было передан шаг шифрования больший,
                    // чем размер алфавита
                    step = step - 26;
                }
                while (step<-26) { //условие, если было передан шаг шифрования меньший,
                    // чем размер алфавита
                    step = step + 26;
                }
                number = alphabet_EN.indexOf(symbol_mssg);
                index = number + step*2; //к номеру прибавляем шаг*2 т.к. в алфавите есть и строчные
                //и заглавные буквы
                if (step<0 && index<0) {
                    index = 52 + index;
                }
                symbol_found = alphabet_EN.charAt(index);
            }

            result += symbol_found; //прибавляем к результату замененный символ
        }
        return result;
    }
}
