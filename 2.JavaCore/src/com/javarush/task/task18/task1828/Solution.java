package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        ArrayList<String> products = new ArrayList<>();
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        while (fileReader.ready())
            products.add(fileReader.readLine());
        fileReader.close();

        switch (args[0]) {
            case "-u": {
                if (args.length < 5)
                    return;

                float price;
                int qty;
                int idFromCommand = 0;

                //Если что-то передали не то
                try {
                    price = Float.parseFloat(args[args.length - 2]);
                    qty = Integer.parseInt(args[args.length - 1]);
                    idFromCommand = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    return;
                }

                //Если у нас аргументов больше 4, из-за пробелов в строке productName
                String productName;
                if (args.length > 5) {
                    StringBuffer buf = new StringBuffer();
                    for (int i = 2; i < args.length - 2; i++)
                        buf.append(args[i]).append(" ");
                    productName = buf.substring(0, buf.length() - 1);
                } else
                    productName = args[2];

                //Get ID from line and update
                Pattern p = Pattern.compile("([0-9]{1,8})");
                for (int i = 0; i < products.size(); i++) {
                    String s = products.get(i);
                    Matcher m = p.matcher(s);
                    if (m.lookingAt()) {
                        try {
                            int id = Integer.parseInt(s.substring(m.start(), m.end()));
                            if (id == idFromCommand) {
                                products.set(i, String.format(Locale.ROOT, "%-8d%-30s%-8.2f%-4d", id, productName, price, qty));
                                break;
                            }
                        } catch (NumberFormatException e) {
                            continue;
                        }
                    }
                }
                break;
            }

            case "-d": {
                Iterator<String> iter = products.iterator();
                while (iter.hasNext()) {
                    String product = iter.next();
                    if (product.startsWith(args[1]))
                        iter.remove();
                }
                break;
            }
        }

        PrintWriter fileWriter = new PrintWriter(fileName);
        for (String s : products)
            fileWriter.println(s);
        fileWriter.close();
    }
}
