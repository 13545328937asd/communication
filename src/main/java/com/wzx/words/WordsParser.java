package com.wzx.words;

import com.wzx.Voluble;
import com.wzx.message.MessageDetail;

public interface WordsParser {
    public Object parseWords(Voluble voluble, MessageDetail detail);
}
