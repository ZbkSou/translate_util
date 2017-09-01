package com.ihaveu.iuzuan.translate_tool.main;

import android.content.Context;

import com.ihaveu.iuzuan.translate_tool.base.BasePresenter;
import com.ihaveu.iuzuan.translate_tool.model.WarpAipService;
import com.litesuits.orm.LiteOrm;

import javax.inject.Inject;

/**
 * Created for Translate_tool
 * User: bkzhou
 * Date: 2017/8/31
 * Contact with zhoubk1451@163.com
 */
public class MainPresenter extends BasePresenter<IMainView>{
  public static final String KEY_RESULT = "RESULT";
  public static final int KEY_REQUEST_CODE_FOR_NOTI = 100;
//  @Inject
//  ClipboardManagerCompat mClipboardWatcher;
  @Inject
  public MainPresenter(LiteOrm liteOrm, WarpAipService apiService, Context context) {
    super(liteOrm, apiService, context);
  }
  public  void executeSearch(String keyword){

  }
}
