package com.ihaveu.iuzuan.translate_tool.bean;

/**
 * Created with Android Studio.
 * Created for Translate_tool
 * User: bkzhou
 * Date: 2017/8/30
 * Contact with zhoubk1451@163.com
 */
public abstract class AbsResult implements IResult {
  public Result getResult(){
    return new Result(this);
  }
}