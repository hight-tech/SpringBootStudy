package com.yang.controller.bak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author yang
 * @Date 2022/8/1
 */
public class BaseClss {
    private Class clazz;
    public static Logger log;
    public BaseClss(){
        clazz=this.getClass();
        log= LoggerFactory.getLogger(clazz);
    }
}
