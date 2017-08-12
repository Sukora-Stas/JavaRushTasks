package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

//    public boolean equals(Solution n) {
//        return n.first.equals(first) && n.last.equals(last);
//    }
//
//    public int hashCode() {
//        return 31 * first.hashCode() + last.hashCode();
//    }
//
//    public static void main(String[] args) {
//        Set<Solution> s = new HashSet<>();
//        s.add(new Solution("Donald", "Duck"));
//        System.out.println(s.contains(new Solution("Donald", "Duck")));
//    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null)
            return false;

        if (!(o instanceof Solution)){
            return false;
        }

        if (this == o) return true;

        Solution solution = (Solution) o;

        if (first != null ? !first.equals(solution.first) : solution.first != null) return false;
        if (last != null ? !last.equals(solution.last) : solution.last != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
