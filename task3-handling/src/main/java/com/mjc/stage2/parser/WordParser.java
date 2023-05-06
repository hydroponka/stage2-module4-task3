package com.mjc.stage2.parser;


import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

public class WordParser extends AbstractTextParser {
    private static final String SYMBOL_REGEX = "\\p{Punct}";

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        char[] symbols = string.toCharArray();
        for (char symbol : symbols) {
            if (String.valueOf(symbol).matches(SYMBOL_REGEX)) {
                abstractTextComponent.add(new SymbolLeaf(TextComponentType.SYMBOL, symbol));
            } else {
                abstractTextComponent.add(new SymbolLeaf(TextComponentType.WORD, symbol));
            }
        }
    }
}
