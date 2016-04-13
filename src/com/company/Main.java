package com.company;

public class Main {

    public static void main(String[] args) {
        LCG lcg = new LCG(6546, 123, 5555, 295075153);
        for (int i = 0; i < 5; i++)
            System.out.println(lcg.nextLong());

        LCGFinder weakLcgFinder = new NewLCGFinder(6546L, 810713L, 99723254L, 167884524L);
        Results results = weakLcgFinder.solve();
        System.out.print(results);
    }
}
