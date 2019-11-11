package com.wzx.objectintellegence;

import com.wzx.objectintellegence.Listen.Listen;
import com.wzx.objectintellegence.analyse.Analyse;
import com.wzx.objectintellegence.comprehension.Comprehend;
import com.wzx.objectintellegence.memory.Memory;
import com.wzx.objectintellegence.speak.Speak;

/**
 *  this interface is designed to make the obj as intelligent as possible,to enable the obj
 *  differrent kinds of abilities.
 */
public interface Intelligent extends Listen, Speak, Comprehend, Memory, Analyse {
}
