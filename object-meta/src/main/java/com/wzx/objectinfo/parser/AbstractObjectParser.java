package com.wzx.objectinfo.parser;

import com.wzx.objectinfo.ObjectInfo;
import com.wzx.objectinfo.action.ObjectAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class AbstractObjectParser<T extends ObjectInfo> implements ObjectParser<T>{
    private static final Logger LOGGER= LoggerFactory.getLogger(AbstractObjectParser.class);
    @Override
    public T parseObject(Class clazz) {
        //objectInfo.setFullName("");
        initBaseInfo(clazz);
        return null;
    }
    public void parseBaseObjectInfo(Class clazz,ObjectInfo objectInfo){
      objectInfo.setClazz(clazz);
      objectInfo.setNickName(parseObjectName(clazz));
      objectInfo.setObjectActions(parseObjectActions(clazz));
    }

    private List<ObjectAction> parseObjectActions(Class clazz) {

    }

    ;
    public String parseObjectName(Class clazz){
        return ObjectParseUtil.parseObjectName(clazz);
    }
}
