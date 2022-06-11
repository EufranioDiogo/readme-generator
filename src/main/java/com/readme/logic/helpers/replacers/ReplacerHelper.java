package com.readme.logic.helpers.replacers;

import com.readme.logic.interfaces.helpers.replacers.ReplacerInterface;

import java.util.HashMap;

public class ReplacerHelper implements ReplacerInterface {
    HashMap<String, String> paramValuesMapper;

    public ReplacerHelper(HashMap<String, String> paramValuesMapper) {
        this.paramValuesMapper = paramValuesMapper;
    }

    @Override
    public String replace(String line) {
        for (String key :
                this.paramValuesMapper.keySet()) {
            if (line.contains(key)) {
                line = line.replace(key, this.paramValuesMapper.get(key));
            }
        }
        return line;
    }
}
