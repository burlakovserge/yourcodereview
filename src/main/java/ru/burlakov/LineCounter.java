package ru.burlakov;

import java.util.BitSet;

public class LineCounter {
    private final BitSet bitSetPositive = new BitSet(Integer.MAX_VALUE);
    private final BitSet bitSetNegative = new BitSet(Integer.MAX_VALUE);
    private final IpToIntConverter ipToIntConverter;

    public LineCounter(IpToIntConverter ipToIntConverter) {
        this.ipToIntConverter = ipToIntConverter;
    }

    public void count(String line) {
        if (line.trim().isEmpty()) return;

        int hashedIp = ipToIntConverter.applyAsInt(line);
        if (hashedIp > 0) {
            bitSetPositive.set(hashedIp);
        } else {
            bitSetNegative.set(hashedIp * -1);
        }
    }

    public Integer getResult(){
        return  bitSetNegative.cardinality() + bitSetPositive.cardinality();
    }
}
