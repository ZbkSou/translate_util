package com.ihaveu.iuzuan.translate_tool.base;

import android.content.Context;

import com.ihaveu.iuzuan.translate_tool.model.WarpAipService;
import com.litesuits.orm.LiteOrm;

/**
 * Created for Translate_tool
 * User: bkzhou
 * Date: 2017/8/30
 * Contact with zhoubk1451@163.com
 */
public class BasePresenter<V extends IBaseView> {
  protected V mView;
  protected WarpAipService mWarpApiService;
//  protected SingleRequestService mSingleRequestService;
  protected LiteOrm mLiteOrm;
  protected Context mContext;
//  protected FileManager mFileManager = new FileManager();
  public BasePresenter(LiteOrm liteOrm, WarpAipService apiService,Context context) {
    mLiteOrm = liteOrm;
    mWarpApiService = apiService;
    mContext = context;
  }
  /**
   * attach IBaseView to Presenter
   * @param view view
   */
  public void attachView(V view){
    this.mView = view;
  }

  public void onDestroy(){
    this.mView = null;
  }

  protected Context getContext(){
    return mContext;
  }

}
