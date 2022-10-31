package com.yang.service;


public interface MsgService {
    String get(String tele);
    Boolean check(String tele,String code);
}
