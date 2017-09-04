package com.ihaveu.iuzuan.translate_tool.base;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

import com.facebook.stetho.Stetho;
import com.ihaveu.iuzuan.translate_tool.BuildConfig;
import com.ihaveu.iuzuan.translate_tool.injection.components.AppComponent;
import com.ihaveu.iuzuan.translate_tool.injection.components.DaggerAppComponent;
import com.ihaveu.iuzuan.translate_tool.injection.modules.ApiServiceModel;
import com.ihaveu.iuzuan.translate_tool.injection.modules.AppModule;
import com.ihaveu.iuzuan.translate_tool.util.LogUtil;

/**
 * Created with Android Studio.
 * User: bkzhou
 * Date: 2017/8/29
 * Time: 下午4:21
 */
public class BaseApplication extends Application{
  private static AppComponent mAppComponent;
  public static Context mContext;
  @Override
  public void onCreate() {
    super.onCreate();
    AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    mContext = this;
    setUpSomethingsByDevMode(BuildConfig.DEBUG);
    mAppComponent = DaggerAppComponent.builder()
      .appModule(new AppModule(this))
      .apiServiceModel(new ApiServiceModel())
      .build();
      LogUtil.d(mAppComponent.toString());
    Stetho.initializeWithDefaults(this);
  }

  /**
   * 设置编译环境需要配置的内容
   * @param isDebug
   */
  private void setUpSomethingsByDevMode(boolean isDebug) {
    LogUtil.setDebug(isDebug);
    if(isDebug){
    }else{
    }
  }
  public static BaseApplication get(){
    return (BaseApplication)mContext.getApplicationContext();
  }

  public static AppComponent getAppComponent() {
    return mAppComponent;
  }

}
