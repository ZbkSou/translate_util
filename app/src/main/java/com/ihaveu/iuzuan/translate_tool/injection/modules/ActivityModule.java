package com.ihaveu.iuzuan.translate_tool.injection.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created for Translate_tool
 * User: bkzhou
 * Date: 2017/8/31
 * Contact with zhoubk1451@163.com
 */
@Module
public class ActivityModule {
  private Context mContext;

  public ActivityModule(Context context) {
    mContext = context;
  }
  @Provides
  @ActivityScope
  public Context provideContext(){
    return mContext;
  }

//  @Provides
//  public ClipboardManagerCompat provideClipboardManage(){
//    return ClipboardManagerCompat.create(mContext);
//  }
//
//  @Provides
//  @ActivityScope
//  public TipViewController provideTipViewControl(){
//    return new TipViewController(mContext);
//  }
}
