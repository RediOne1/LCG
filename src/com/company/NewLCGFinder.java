package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * author:  Adrian Kuta
 * date:    12.04.2016
 */
class NewLCGFinder extends LCGFinder {

    NewLCGFinder(Long... input) {
        super(input);
    }

    @Override
    public Results solve() {
        if (input.size() < 4)
            return new Results();

        Results results = new Results();

        long x3x2 = input.get(3) - input.get(2);
        long x2x1 = input.get(2) - input.get(1);
        long x1x0 = input.get(1) - input.get(0);

        long maxM = Math.abs(x3x2 * x1x0 - x2x1 * x2x1);

        List<Long> dividers = dividers(maxM);
        Collections.sort(dividers);

        Long maximum = Collections.max(input);

        for (Long divider : dividers) {
            if (divider > maximum) {
                results.modulus = divider;   //modulus
                break;
            }
        }

        long modulus = results.modulus;

        long gcd = gcd(x1x0, x2x1);
        x1x0 /= gcd;
        x2x1 /= gcd;
        modulus /= gcd;

        long extendEuclidean = inverse(x1x0, modulus);


        results.multiplier = x2x1 * extendEuclidean % modulus;  // multiplier
        long increment = (input.get(1) - input.get(0) * results.multiplier) % results.modulus;
        if (increment < 0)
            increment += results.modulus;

        results.increment = increment;

        return results;
    }

    private List<Long> dividers(long m) {

        List<Long> dividers = new ArrayList<>();

        for (long k = 1; k < Math.sqrt(m); k++) {
            if (m % k == 0) {
                dividers.add(k);
                dividers.add(m / k);
            }
        }

        return dividers;

    }

    private long gcd(long a, long b) {
        long c = 0;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    private long inverse(long a, long b) {
        long t = 0, r = b, newt = 1, newr = a, quot = 0, tmp;

        while (newr != 0) {
            quot = r / newr;

            tmp = newt;
            newt = t - quot * tmp;
            t = tmp;

            tmp = newr;
            newr = r - quot * tmp;
            r = tmp;
            if (t < 0)
                t = t + b;

        }
        return t;
    }
}
