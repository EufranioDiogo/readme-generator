package com.readme.logic.helpers.replacers;

import com.readme.logic.interfaces.helpers.replacers.ReplacerInterface;

import java.util.HashMap;
import java.util.Map;

public class ReplacerHelper implements ReplacerInterface {
    Map<String, String> paramValuesMapper;

    public ReplacerHelper(Map<String, String> paramValuesMapper) {
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
