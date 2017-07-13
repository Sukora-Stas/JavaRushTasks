package com.javarush.task.task15.task1504;

import java.util.LinkedList;
import java.util.List;

/* 
ООП - книги
*/

public class Solution {
    public static void main(String[] args) {
        List<Book> books = new LinkedList<Book>();
        books.add(new MarkTwainBook("Tom Sawyer"));
        books.add(new AgathaChristieBook("Hercule Poirot"));
        System.out.println(books);
    }

    abstract static class Book {
        private String author;

        public Book(String author) {
            this.author = author;
        }

        public abstract Book getBook();

        public abstract String getTitle();

        private String getOutputByBookType() {
            String agathaChristieOutput = author + ", " + getBook().getTitle() + " is a detective";
            String markTwainOutput = getBook().getTitle() + " book was written by " + author;

            String output = "output";
            //Add your code here
            if (this instanceof MarkTwainBook)
                output = markTwainOutput;
            if (this instanceof AgathaChristieBook)
                output = agathaChristieOutput;


            return output;
        }

        public String toString() {
            return getOutputByBookType();
        }
    }

    public static class MarkTwainBook extends Book {
        private String title;
        private String name;

        public MarkTwainBook(String name) {
            super("Mark Twain");
            this.title = name;
            this.name = name;
        }

        @Override
        public MarkTwainBook getBook() {
            return this;
        }

        @Override
        public String getTitle() {
            return this.title;
        }
    }

    public static class AgathaChristieBook extends Book {
        private String title;
        private String name;

        public AgathaChristieBook(String name) {
            super("Agatha Christie");
            this.title = name;
            this.name = name;
        }

        @Override
        public AgathaChristieBook getBook() {
            return this;
        }

        @Override
        public String getTitle() {
            return this.title;
        }
    }

}
