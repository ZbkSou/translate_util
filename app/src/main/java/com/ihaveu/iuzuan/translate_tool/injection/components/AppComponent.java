package com.ihaveu.iuzuan.translate_tool.injection.components;

import com.ihaveu.iuzuan.translate_tool.base.BaseApplication;
import com.ihaveu.iuzuan.translate_tool.injection.modules.ApiServiceModel;
import com.ihaveu.iuzuan.translate_tool.injection.modules.AppModule;
import com.ihaveu.iuzuan.translate_tool.model.ApiBaidu;
import com.ihaveu.iuzuan.translate_tool.model.WarpAipService;
import com.litesuits.orm.LiteOrm;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created with Android Studio.
 * Created for Translate_tool
 * User: bkzhou
 * Date: 2017/8/30
 * Contact with zhoubk1451@163.com
 */
@Singleton
@Component(modules = {AppModule.class,ApiServiceModel.class})
public interface AppComponent {
  BaseApplication getApplication();

  LiteOrm getLiteOrm();

  WarpAipService getWarpService();

//  ApiJinShan getApiJinShan();
//
//  ApiYouDao getApiYoudao();

  ApiBaidu getApiBaidu();

//  ApiGoogle getApiGoogle();

//  SingleRequestService getDwnloadService();
}
