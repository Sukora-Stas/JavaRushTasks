//package com.javarush.task.task19.task1916;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
///*
//Отслеживаем изменения
//Считать с консоли 2 имени файла — file1, file2.
//Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
//Нужно создать объединенную версию строк, записать их в список lines.
//Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
//В оригинальном и редактируемом файлах пустых строк нет.
//Пример:
//оригинальный    редактированный    общий
//file1:          file2:             результат:(lines)
//строка1         строка1            SAME строка1
//строка2         REMOVED            строка2
//строка3         строка3            SAME строка3
//строка4         REMOVED            строка4
//строка5         строка5            SAME строка5
//строка0         ADDED              строка0
//строка1         строка1            SAME строка1
//строка2         REMOVED            строка2
//строка3         строка3            SAME строка3
//строка5         ADDED              строка5
//строка4         строка4            SAME строка4
//строка5         REMOVED            строка5
//*/
//
//// Валидатор не принял это решение. На данных из задания работает, на других не совсем.
//public class Solution {
//    public static List<LineItem> lines = new ArrayList<LineItem>();
//    public static ArrayList<String> fc1 = new ArrayList<String>(50);
//    public static ArrayList<String> fc2 = new ArrayList<String>(50);
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));
//        String file1 = conReader.readLine();
//        String file2 = conReader.readLine();
//        conReader.close();
//
//        BufferedReader f1 = new BufferedReader(new FileReader(file1));
//        BufferedReader f2 = new BufferedReader(new FileReader(file2));
//
//        while (f1.ready())
//            fc1.add(f1.readLine());
//        f1.close();
//
//        while (f2.ready())
//            fc2.add(f2.readLine());
//        f2.close();
//
//
//        String chk, s1, s2, s3;
//        for (int i = 0; i < fc1.size(); i++) {
//            chk = fc1.get(i);
//
//            if (i > 0)
//                s1 = fc2.get(i - 1);
//            else
//                s1 = null;
//
//            if (i < fc2.size())
//                s2 = fc2.get(i);
//            else
//                s2 = null;
//
//            if (i+1 < fc2.size())
//                s3 = fc2.get(i + 1);
//            else
//                s3 = null;
//
//
//            if (!chk.equals(s1) && !chk.equals(s2) && !chk.equals(s3)) {
//                lines.add(new LineItem(Type.REMOVED, chk));
//                fc2.add(i, chk);
//            }
//
//            if (!chk.equals(s1) && !chk.equals(s2) && chk.equals(s3)) {
//                lines.add(new LineItem(Type.ADDED, s2));
//                fc1.add(i, s2);
//            }
//
//            if (chk.equals(s1) && !chk.equals(s2) && !chk.equals(s3)) {
//                lines.add(new LineItem(Type.SAME, chk));
//            }
//        }
//
//        //Show
////        Z
//    }
//
//
//    public static enum Type {
//        ADDED,        //добавлена новая строка
//        REMOVED,      //удалена строка
//        SAME          //без изменений
//    }
//
//    public static class LineItem {
//        public Type type;
//        public String line;
//
//        public LineItem(Type type, String line) {
//            this.type = type;
//            this.line = line;
//        }
//    }
//}

package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Считать с консоли 2 имени файла — file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
В оригинальном и редактируемом файлах пустых строк нет.

Пример:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
строка4                            REMOVED строка4
строка5         строка5            SAME строка5
                строка0            ADDED строка0
строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
                строка5            ADDED строка5
строка4         строка4            SAME строка4
строка5                            REMOVED строка5

1. Класс Solution должен содержать класс LineItem.
2. Класс Solution должен содержать enum Type.
3. Класс Solution должен содержать публичное статическое поле lines типа List, которое сразу проинициализировано.
4. В методе main(String[] args) программа должна считывать имена файлов с консоли (используй BufferedReader).
5. В методе main(String[] args) BufferedReader для считывания данных с консоли должен быть закрыт.
6. Программа должна считывать содержимое первого и второго файла (используй FileReader).
7. Потоки чтения из файлов (FileReader) должны быть закрыты.
8. Список lines должен содержать объединенную версию строк из файлов, где для каждой строки указана одна из операций ADDED, REMOVED, SAME.
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception {

        List<String> fileOne = new ArrayList<>();
        List<String> fileTwo = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(file1));
        while (reader.ready()){
            fileOne.add(reader.readLine());
        }
        reader.close();
        reader = new BufferedReader(new FileReader(file2));
        while(reader.ready()){
            fileTwo.add(reader.readLine());
        }
        reader.close();


        while (fileOne.size() > 0 && fileTwo.size() > 0){

            if(fileOne.get(0).equals(fileTwo.get(0))){
                lines.add(new LineItem(Type.SAME, fileOne.get(0)));
                fileOne.remove(0);
                fileTwo.remove(0);
            } else if (fileOne.get(0).equals(fileTwo.get(1))){
                lines.add(new LineItem(Type.ADDED, fileTwo.get(0)));
                fileTwo.remove(0);
            } else if (fileTwo.get(0).equals(fileOne.get(1))) {
                lines.add(new LineItem(Type.REMOVED, fileOne.get(0)));
                fileOne.remove(0);
            }
        }

        if(fileOne.size() == 0 && fileTwo.size() == 1){
            lines.add(new LineItem(Type.ADDED, fileTwo.get(0)));
            fileTwo.remove(0);
        }
        if(fileOne.size() == 1 && fileTwo.size() == 0){
            lines.add(new LineItem(Type.REMOVED, fileTwo.get(0)));
            fileTwo.remove(0);
        }



    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}