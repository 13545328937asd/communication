package com.wzx.objectintellegence;

import com.wzx.objectinfo.ability.Listen;
import com.wzx.objectinfo.ability.Analyse;
import com.wzx.objectinfo.ability.Comprehend;
import com.wzx.objectinfo.ability.Memory;
import com.wzx.objectinfo.ability.Speak;

/**
 *  this interface is designed to make the obj as intelligent as possible,to enable the obj
 *  differrent kinds of abilities.
 */
public interface Intelligent extends Listen, Speak, Comprehend, Memory, Analyse {
}
