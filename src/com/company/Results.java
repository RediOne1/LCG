package com.company;

/**
 * author:  Adrian Kuta
 * date:    12.04.2016
 */
public class Results {

    long modulus;
    long multiplier;
    long increment;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("modulus = ").append(modulus);
        sb.append("\n");
        sb.append("multiplier = ").append(multiplier);
        sb.append("\n");
        sb.append("increment = ").append(increment);
        return sb.toString();
    }
}
