package com.mjc.stage2.parser;

import java.util.ArrayList;
import java.util.List;

public class ChainParserBuilder {
    private List<AbstractTextParser> parsers = new ArrayList<>();

    public ChainParserBuilder() {
    }

    public ChainParserBuilder setParser(AbstractTextParser abstractTextParser) {
        parsers.add(abstractTextParser);
        return this;
    }

    public AbstractTextParser build() {
        for (int i = 0; i < parsers.size() - 1; i++) {
            AbstractTextParser currentParser = parsers.get(i);
            AbstractTextParser nextParser = parsers.get(i + 1);
            currentParser.setNextParser(nextParser);
        }
        return parsers.get(0);
    }
}