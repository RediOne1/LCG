package com.company;

/**
 * author:  Adrian Kuta
 * date:    08.03.2016
 */
public class LCG {

    private long modulus;
    private long multiplier;
    private long increment;

    private long seed;

    public LCG(long seed, long multiplier, long increment, long modulus) {
        this.seed = seed;
        this.multiplier = multiplier;
        this.increment = increment;
        this.modulus = modulus;
    }

    public long nextLong() {
        System.out.print("(" + multiplier + " * " + seed + " + " + increment + ") % " + modulus+" = ");
        seed = (multiplier * seed + increment) % modulus;
        return seed;
    }
}
