package ru.burlakov;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        String path = args[0];
        IpToIntConverter ipToIntConverter = new IpToIntConverter();
        LineCounter lineCounter = new LineCounter(ipToIntConverter);
        CustomFileReader reader = new LineReader(path, lineCounter);
        reader.read();
        logger.info("\nCount of unique ip addresses is - " + lineCounter.getResult());
    }
}
