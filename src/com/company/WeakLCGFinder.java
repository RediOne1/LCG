package com.company;

/**
 * author:  Adrian Kuta
 * date:    08.03.2016
 */
class WeakLCGFinder<R extends Results> extends LCGFinder {

    private long modulus;
    final long x0;
    final long x1;
    final long x2;
    final long x3;

    WeakLCGFinder(long x0, long x1, long x2, long x3) {
        this.x0 = x0;
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
    }

    @Override
    public Results solve() {
        long nwd = nwd(x2 - x1, x1 - x0);
        long nww = Math.abs((x2 - x1) * (x1 - x0) / nwd);
        modulus = calcModulus(nww);

        long temp1 = (x3 - x2) - (x2 - x1);
        long temp2 = (x2 - x1) - (x1 - x0);
        if (temp1 < 0)
            temp1 += modulus;
        if (temp2 < 0)
            temp2 += modulus;

        long a = calcA(temp1, temp2);
        long b = (x0 * a + modulus) % modulus;

        Results results = new Results();
        results.modulus = modulus;
        results.multiplier = a;
        results.increment = b;
        return results;
    }

    private long calcModulus(long nww) {
        long tempMod = Math.abs(((x2 - x1) * nww / (x1 - x0) - (x3 - x2) * nww / (x2 - x1)));
        long max = x0;
        if (x1 > max)
            max = x1;
        if (x2 > max)
            max = x2;
        if (x3 > max)
            max = x3;
        long mod = max;
        while (tempMod % mod != 0)
            mod++;
        return mod;
    }

    private long calcA(long temp1, long temp2) {
        float k = 0;
        float wynik = ((float) modulus * k + (float) temp1) / (float) temp2;
        while (wynik != (long) wynik) {
            k += 1;
            wynik = ((float) modulus * k + (float) temp1) / (float) temp2;
        }
        return (long) wynik;
    }

    private long nwd(long a, long b) {
        long c;                    // Tworzymy zmienną c o typie int
        while (b != 0)             // Tworzymy pętlę działającą gdy b ≠ 0
        {
            c = a % b;              // Zmienna c przyjmuje wartość a modulo b
            a = b;                // Przypisujemy b do a
            b = c;                // Przypisujemy c do b
        }
        return a;                 // Zwracamy a, czyli żądane NWD(a,b)
    }
}
