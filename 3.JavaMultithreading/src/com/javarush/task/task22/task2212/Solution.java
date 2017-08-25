package com.javarush.task.task22.task2212;

/*
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.

Критерии валидности:
1) если номер начинается с ‘+‘, то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков ‘—‘, которые не могут идти подряд
4) может содержать 1 пару скобок ‘(‘ и ‘)‘ , причем если она есть, то она расположена левее знаков ‘-‘
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true
+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {

        if (telNumber == null) {
            return false;
        }
        if (telNumber.isEmpty()) {
            return false;
        }

        if (telNumber.matches("[()0-9+-]+")) {
            if (telNumber.contains("(")) {
                if (telNumber.contains(")")) {
                    for (int i = 0; i < telNumber.length(); i++) {
                        if ((telNumber.charAt(i) == '(') && (telNumber.charAt(i + 4) != ')')) {
                            return false;
                        }
                    }

                } else return false;
            }

            if (telNumber.contains(")")) {
                if (telNumber.contains("(")) {

                } else {
                    return false;
                }
            }

            if (((telNumber.length() - telNumber.replaceAll("[(]", "").length()) > 1) ||
                    ((telNumber.length() - telNumber.replaceAll("[)]", "").length()) > 1) ||
                    ((telNumber.length() - telNumber.replaceAll("[+]", "").length()) > 1) ||
                    ((telNumber.length() - telNumber.replaceAll("[-]", "").length()) > 2)) {

                return false;
            }

            if ((telNumber.length() - telNumber.replace("-", "").length()) == 2) {
                for (int w = 0; w < telNumber.length(); w++) {
                    if ((telNumber.charAt(w) == 'w') && (telNumber.charAt(w + 1) == 'w')) {


                        return false;
                    }
                }
            }


            if ((telNumber.charAt(telNumber.length() - 1) + "").matches("[(+-]")) {

                return false;
            }

            if ((telNumber.charAt(telNumber.length() - 1) + "").matches("[)]") && !(telNumber.charAt(telNumber.length() - 5) + "").matches("[(]")) {


                return false;
            }

            if (telNumber.charAt(0) == '+') {
                if ((telNumber.replace("(", "").replace(")", "").replace("+", "").replace("-", "").length()) != 12) {

                    return false;
                }

            } else if ((telNumber.charAt(0) == '(') && (telNumber.charAt(4) == ')')) {
                if ((telNumber.replace("(", "").replace(")", "").replace("+", "").replace("-", "").length()) != 10) {
                    return false;
                }

            } else if ((telNumber.charAt(0) + "").matches("[0-9]+")) {
                if ((telNumber.replace("(", "").replace(")", "").replace("+", "").replace("-", "").length()) != 10) {
                    return false;
                }
            } else {

                return false;
            }

        } else return false;
        return true;

    }

    public static void main(String[] args) {
/*
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true
+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
 */
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123-4567"));
        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("(0)501234567"));


    }
}
