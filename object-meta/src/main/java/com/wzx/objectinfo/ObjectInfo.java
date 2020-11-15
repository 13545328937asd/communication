package com.wzx.objectinfo;

import com.wzx.objectinfo.ability.*;
import com.wzx.objectinfo.action.ObjectAction;

import java.util.ArrayList;
import java.util.List;

public class ObjectInfo {
    private Class   clazz;
    private String  nickName;
    private List<ObjectAction> objectActions=new ArrayList<>(8);
    /*//分析器，赋予对象分析能力
    private Map<String, Analyse> analyseMap=new HashMap<>(8);
    //理解器，赋予对象理解能力
    private List<Comprehend> comprehenders=new ArrayList<>(2);*/
    //协调器，赋予对象协调能力
    private Coordinate coordinator;
    //存储器，记忆器，赋予对象记忆能力
    private Memory memorizer;
    //读写器，赋予对象读写能力
    private ReadeAndWrite readeAndWrite;
    //社交，赋予对象社交能力
    private Social socialer;


    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<ObjectAction> getObjectActions() {
        return objectActions;
    }

    public void setObjectActions(List<ObjectAction> objectActions) {
        this.objectActions = objectActions;
    }

    public Coordinate getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Coordinate coordinator) {
        this.coordinator = coordinator;
    }

    public Memory getMemorizer() {
        return memorizer;
    }

    public void setMemorizer(Memory memorizer) {
        this.memorizer = memorizer;
    }

    public ReadeAndWrite getReadeAndWrite() {
        return readeAndWrite;
    }

    public void setReadeAndWrite(ReadeAndWrite readeAndWrite) {
        this.readeAndWrite = readeAndWrite;
    }

    public Social getSocialer() {
        return socialer;
    }

    public void setSocialer(Social socialer) {
        this.socialer = socialer;
    }
}
