package com.ihaveu.iuzuan.translate_tool.model.type;

import com.ihaveu.iuzuan.translate_tool.model.ApiBaidu;

/**
 * Created with Android Studio.
 * Created for Translate_tool
 * User: bkzhou
 * Date: 2017/8/30
 * Contact with zhoubk1451@163.com
 */
public enum ETranslateFrom {
  BAI_DU(0,"百度","http://api.fanyi.baidu.com/", ApiBaidu.class);
//  YOU_DAO(1,"有道","http://fanyi.youdao.com/",ApiYouDao.class),
//  JIN_SHAN(2,"金山","http://dict-co.iciba.com/",ApiJinShan.class),
//  GOOGLE(3, "谷歌", "http://translate.google.cn/",ApiGoogle.class);
  private int index;
  private String name;
  private String url;
  private Class aqiClass;
  ETranslateFrom(int index,String name,String url, Class aqiClass) {
    this.index = index;
    this.name = name;
    this.url = url;
    this.aqiClass = aqiClass;
  }

  public int getIndex() {
    return index;
  }

  public String getName() {
    return name;
  }

  public String getUrl() {
    return url;
  }

  public Class getAqiClass() {
    return aqiClass;
  }
}
