package com.company;

import java.util.Arrays;
import java.util.List;

/**
 * author:  Adrian Kuta
 * date:    12.04.2016
 */
abstract class LCGFinder {

    List<Long> input;

    LCGFinder(Long... input) {
        this.input = Arrays.asList(input);
    }

    public abstract Results solve();
}
