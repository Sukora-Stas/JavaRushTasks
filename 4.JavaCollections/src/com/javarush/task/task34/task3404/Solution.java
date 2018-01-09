package com.javarush.task.task34.task3404;

import java.util.ArrayList;
import java.util.List;

/*
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
    }

    public void recursion(final String expression, int countOperation) {
        //сам не смог, решение заимствовано
        //implement
        try{
            System.out.println(Double.parseDouble(expression) + " " + countOperation);
            String test = "" + Double.parseDouble(expression);
        }catch (NumberFormatException e){

            String workExpression = expression;
            double x = 0d;
            double y = 0d;

            int a = 0;
            int b = expression.length();

            if(expression.contains("(")){ //если есть скобки - сначало решаем их
                workExpression = expression.substring(expression.lastIndexOf("(") + 1, expression.indexOf(")"));
                a = expression.lastIndexOf("(");
                b = expression.indexOf(")");
            }

            if(workExpression.contains("*") ||
                    workExpression.contains("/") ||
                    workExpression.contains("^") ||
                    workExpression.contains("+")){
                List<Character> characterList = new ArrayList<>();
                List<Integer> characterIndex = new ArrayList<>();
                for(int i = 0; i < workExpression.toCharArray().length; i++){
                    if(workExpression.toCharArray()[i] == '*'){
                        characterIndex.add(i);
                        characterList.add('*');
                    }
                    if(workExpression.toCharArray()[i] == '/'){
                        characterIndex.add(i);
                        characterList.add('/');
                    }
                    if(workExpression.toCharArray()[i] == '^'){
                        characterIndex.add(i);
                        characterList.add('^');
                    }
                    if(workExpression.toCharArray()[i] == '+'){
                        characterIndex.add(i);
                        characterList.add('+');
                    }
                    if(workExpression.toCharArray()[i] == '-'){
                        characterIndex.add(i);
                        characterList.add('-');
                    }
                }

                int aa = 0;
                int bb = 0;
                String tmpResult;

                if(characterList.get(0) == '*' || characterList.get(0) == '/' || characterList.get(0) == '^'){
                    x = Double.parseDouble(workExpression.substring(0, characterIndex.get(0)));
                    aa = 0;
                    if(characterIndex.size() >= 2){
                        y = Double.parseDouble(workExpression.substring(characterIndex.get(0) + 1, characterIndex.get(1)));
                        bb = characterIndex.get(1);
                    }else{
                        y = Double.parseDouble(workExpression.substring(characterIndex.get(0) + 1, workExpression.length()));
                        bb = workExpression.length();
                    }
                    tmpResult = "" + mathOperation(x, y, characterList.get(0));
                    workExpression = expression.replace(workExpression, workExpression.replace(workExpression.substring(aa, bb) , tmpResult));
                    recursion(workExpression, ++countOperation);
                    return;
                }else{
                    if(characterIndex.size() >= 2){
                        if(characterList.get(1) == '*' || characterList.get(1) == '/' || characterList.get(1) == '^'){
                            x = Double.parseDouble(workExpression.substring(characterIndex.get(0) + 1, characterIndex.get(1)));
                            aa = characterIndex.get(0) + 1;
                            if(characterIndex.size() >= 3){
                                y = Double.parseDouble(workExpression.substring(characterIndex.get(1) + 1, characterIndex.get(2)));
                                bb = characterIndex.get(1);
                            }else{
                                y = Double.parseDouble(workExpression.substring(characterIndex.get(1) + 1, workExpression.length()));
                                bb = workExpression.length();
                            }
                            tmpResult = "" + mathOperation(x, y, characterList.get(1));
                            workExpression = expression.replace(workExpression, workExpression.replace(workExpression.substring(aa, bb) , tmpResult));
                            recursion(workExpression, ++countOperation);
                            return;

                        }else{
                            x = Double.parseDouble(workExpression.substring(0, characterIndex.get(0)));
                            aa = 0;
                            y = Double.parseDouble(workExpression.substring(characterIndex.get(0) + 1, characterIndex.get(1)));
                            bb = characterIndex.get(1);
                            tmpResult = "" + mathOperation(x, y, characterList.get(0));
                            workExpression = expression.replace(workExpression, workExpression.replace(workExpression.substring(aa, bb) , tmpResult));
                            recursion(workExpression, ++countOperation);
                            return;
                        }
                    }else{
                        x = Double.parseDouble(workExpression.substring(0, characterIndex.get(0)));
                        aa = 0;
                        y = Double.parseDouble(workExpression.substring(characterIndex.get(0) + 1, workExpression.length()));
                        bb = workExpression.length();
                        tmpResult = "" + mathOperation(x, y, characterList.get(0));
                        workExpression = expression.replace(workExpression, workExpression.replace(workExpression.substring(aa, bb) , tmpResult));
                        recursion(workExpression, ++countOperation);
                        return;
                    }
                }
            }else{
                if(workExpression.contains("-")){
                    if(workExpression.indexOf("-") == 0){
                        workExpression = expression.replace(expression.substring(expression.lastIndexOf("("), expression.indexOf(")") + 1), workExpression);
                        recursion(workExpression, countOperation);
                        return;
                    }else{
                        int iTmp = workExpression.indexOf("-");
                        if(iTmp - 3 >= 0){
                            String trigo = workExpression.substring(iTmp - 3, iTmp);
                            if(trigo.equals("sin")){
                                x = Double.parseDouble(workExpression.substring(iTmp, workExpression.length()));
                                workExpression = expression.replace(expression.substring(iTmp - 3, b + 1), String.format("%.2f", calculTrigo(x, "sin")));
                                recursion(workExpression, ++countOperation);
                                return;
                            }
                            if(trigo.equals("cos")){
                                x = Double.parseDouble(workExpression.substring(iTmp, workExpression.length()));
                                workExpression = expression.replace(expression.substring(iTmp - 3, b + 1), String.format("%.2f", calculTrigo(x, "cos")));
                                recursion(workExpression, ++countOperation);
                                return;
                            }
                            if(trigo.equals("tan")){
                                x = Double.parseDouble(workExpression.substring(iTmp, workExpression.length()));
                                workExpression = expression.replace(expression.substring(iTmp - 3, b + 1), String.format("%.2f", calculTrigo(x, "tan")));
                                recursion(workExpression, ++countOperation);
                                return;
                            }
                        }
                        x = Double.parseDouble(workExpression.substring(0, workExpression.indexOf("-")));
                        y = Double.parseDouble(workExpression.substring(workExpression.indexOf("-") + 1, workExpression.length()));
                        workExpression = expression.replace(expression.substring(a + 1, b), String.format("%.2f", (x - y)));
                        recursion(workExpression, ++countOperation);
                        return;
                    }
                }else{
                    int iTmp = expression.indexOf("(");
                    if(iTmp - 3 >= 0){
                        String trigo = expression.substring(iTmp - 3, iTmp);
                        if(trigo.equals("sin")){
                            x = Double.parseDouble(expression.substring(iTmp + 1, expression.indexOf(")")));
                            workExpression = expression.replace(expression.substring(iTmp - 3, b + 1), String.format("%.2f", calculTrigo(x, "sin")));
                            recursion(workExpression, ++countOperation);
                            return;
                        }
                        if(trigo.equals("cos")){
                            x = Double.parseDouble(expression.substring(iTmp + 1, expression.indexOf(")")));
                            workExpression = expression.replace(expression.substring(iTmp - 3, b + 1), String.format("%.2f", calculTrigo(x, "cos")));
                            recursion(workExpression, ++countOperation);
                            return;
                        }
                        if(trigo.equals("tan")){
                            x = Double.parseDouble(expression.substring(iTmp + 1, expression.indexOf(")")));
                            workExpression = expression.replace(expression.substring(iTmp - 3, b + 1), String.format("%.2f", calculTrigo(x, "tan")));
                            recursion(workExpression, ++countOperation);
                            return;
                        }
                    }

                    workExpression = expression.replace(expression.substring(expression.lastIndexOf("("), expression.indexOf(")") + 1), workExpression);
                    recursion(workExpression, countOperation);
                    return;
                }
            }
        }
    }

    private double calculTrigo(double x, String method){
        if(method.equals("sin")) {
            return Math.sin(Math.toRadians(x));
        }
        else if(method.equals("cos")){
            return Math.cos(Math.toRadians(x));
        }
        else{
            return Math.sin(Math.toRadians(x));
        }

    }

    private double mathOperation(double a, double b, Character character) {
        if(character == '*'){
            return a * b;
        } else if(character == '/'){
            return a / b;
        }else if(character == '^') {
            double result = a;
            for(int i = 0; i < b; i++){
                result = result * a;
            }
            return result;
        }else if(character == '+'){
            return a + b;
        }else{
            return a - b;
        }
    }

    public Solution() {
        //don't delete
    }
}
