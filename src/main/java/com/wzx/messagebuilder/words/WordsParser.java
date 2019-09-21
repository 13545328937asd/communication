package com.wzx.messagebuilder.words;

import com.wzx.messagebuilder.Voluble;
import com.wzx.messagebuilder.message.MessageDetail;

public interface WordsParser {
    public Object parseWords(Voluble voluble, MessageDetail detail);
}
