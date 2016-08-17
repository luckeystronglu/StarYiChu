package com.qf.luckey.util;

/**
 * Created by Administrator on 2016/8/11.
 */
public interface HttpURL {
    //根链接，以斜杠结尾
    String HTTP_ROOT = "http://api-v2.mall.hichao.com/";
    //搭配模块下 -- 搭配 -- 最新，不以斜杠开头
    String HTTP_FIT_NEWEST = "star/list?category=%E6%9C%80%E6%96%B0&pin=269476&ga=%2Fstar%2Flist&flag=&lts=1470666755";

    //搭配模块下 -- 专题
    String HTTP_SUBJECT = "mix_topics?category=&ga=%2Fmix_topics&flag=";



}
