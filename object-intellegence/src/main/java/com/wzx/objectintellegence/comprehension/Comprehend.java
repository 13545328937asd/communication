package com.wzx.objectintellegence.comprehension;

public interface Comprehend<T,K> {
    default K comprehend(T message){

        return null;
    }
}
