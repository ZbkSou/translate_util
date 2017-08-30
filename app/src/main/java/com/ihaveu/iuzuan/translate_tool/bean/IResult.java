package com.ihaveu.iuzuan.translate_tool.bean;

import java.util.List;

/**
 * Created with Android Studio.
 * Created for Translate_tool
 * User: bkzhou
 * Date: 2017/8/30
 * Contact with zhoubk1451@163.com
 */
public interface IResult {
  /**
   * 长句翻译结果
   * @return
   */
  List<String> wrapTranslation();

  /**
   * 单词解释
   * @return
   */
  List<String> wrapExplains();

  /**
   * 查询关键字
   * @return
   */
  String wrapQuery();

  /**
   * 查询结果错误码
   * @return
   */
  int wrapErrorCode();

  /**
   * 英式音标
   * @return
   */
  String wrapEnPhonetic();

  /**
   * 美式音标
   * @return
   */
  String wrapAmPhonetic();

  /**
   * 英式发音 MP3
   * @return
   */
  String wrapEnMp3();

  /**
   * 美式发音 MP3
   * @return
   */
  String wrapAmMp3();

  /**
   * 翻译来源
   * @return
   */
  String translateFrom();

  /**
   * 英式音标
   * @return
   */
  String wrapPhEn();

  /**
   * 美式音标
   * @return
   */
  String wrapPhAm();

  /**
   * mp3 本地存储文件名称
   * @return
   */
  String wrapMp3Name();
}

