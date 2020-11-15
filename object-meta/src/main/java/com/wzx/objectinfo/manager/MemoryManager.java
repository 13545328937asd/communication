package com.wzx.objectinfo.manager;

import com.wzx.objectinfo.ability.Memory;

/**
 * the momery manager of objects,used to manage the memory of objects
 */
public class MemoryManager {
    private final static MemoryManager memoryManager=new MemoryManager();
    private MemoryManager(){}
    public MemoryManager getInstance(){
        return memoryManager;
    }
}
