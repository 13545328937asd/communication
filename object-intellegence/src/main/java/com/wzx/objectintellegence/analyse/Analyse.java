package com.wzx.objectintellegence.analyse;

public interface Analyse {
    default Object analyse(String thing){
        return null;
    }
}
