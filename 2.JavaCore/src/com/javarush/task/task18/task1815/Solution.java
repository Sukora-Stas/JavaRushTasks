package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface {
        ATableInterface aTableInterface;


        public TableInterfaceWrapper(ATableInterface aTableInterface) {
            this.aTableInterface = aTableInterface;
        }


        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            aTableInterface.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return aTableInterface.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            aTableInterface.setHeaderText(newHeaderText);
        }
    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}