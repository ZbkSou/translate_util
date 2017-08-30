package com.ihaveu.iuzuan.translate_tool.injection.modules;

import com.ihaveu.iuzuan.translate_tool.BuildConfig;
import com.ihaveu.iuzuan.translate_tool.base.BaseApplication;
import com.litesuits.orm.LiteOrm;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created with Android Studio.
 * Created for Translate_tool
 * User: bkzhou
 * Date: 2017/8/30
 * Contact with zhoubk1451@163.com
 */
@Module
public class AppModule {
  private static final String DB_NAME = "GdTranslate.db";
  private BaseApplication application;
  public AppModule(BaseApplication application){
    this.application=application;
  }

  @Provides
  @Singleton
  public BaseApplication provideApplication(){
    return application;
  }

  @Provides
  @Singleton
  public LiteOrm provideLiteOrm(){
    LiteOrm liteOrm = LiteOrm.newSingleInstance(application, DB_NAME);
    liteOrm.setDebugged(BuildConfig.DEBUG);
    return liteOrm;
  }
}
