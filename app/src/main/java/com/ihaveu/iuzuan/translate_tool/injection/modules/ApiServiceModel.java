package com.ihaveu.iuzuan.translate_tool.injection.modules;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.ihaveu.iuzuan.translate_tool.BuildConfig;
import com.ihaveu.iuzuan.translate_tool.base.BaseApplication;
import com.ihaveu.iuzuan.translate_tool.model.ApiBaidu;
import com.ihaveu.iuzuan.translate_tool.model.type.ETranslateFrom;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created with Android Studio.
 * Created for Translate_tool
 * User: bkzhou
 * Date: 2017/8/30
 * Contact with zhoubk1451@163.com
 */
@Module
public class ApiServiceModel {

  @Provides
  @Singleton
  ApiBaidu provideApiBaidu() {
    return createService(ETranslateFrom.BAI_DU);
  }

//  @Provides
//  @Singleton
//  ApiYouDao provideApiYouDao() {
//    return createService(ETranslateFrom.YOU_DAO);
//  }
//
//  @Provides
//  @Singleton
//  ApiJinShan provideApiJinShan() {
//    return createService(ETranslateFrom.JIN_SHAN);
//  }
//
//  @Provides
//  @Singleton
//  ApiGoogle provideApiGoogle(){return createService(ETranslateFrom.GOOGLE);}
  private <S> S createService(ETranslateFrom type) {
    Retrofit.Builder builder = new Retrofit.Builder()
      .baseUrl(HttpUrl.parse(type.getUrl()))
      .addConverterFactory(GsonConverterFactory.create())
      .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
    builder.client(provideOkHttpClient());
    return (S) builder.build().create(type.getAqiClass());
  }
  @Provides
  @Singleton
  OkHttpClient provideOkHttpClient() {
    Cache cache = new Cache(BaseApplication.get().getCacheDir(), 10240 * 1024);
    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    if (BuildConfig.DEBUG) {
      builder.addNetworkInterceptor(new StethoInterceptor());
    }
    builder.addNetworkInterceptor(new CacheInterceptor())
      .cache(cache)
      .connectTimeout(20, TimeUnit.SECONDS)
      .readTimeout(20, TimeUnit.SECONDS);
    return builder.build();
  }

  private class CacheInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
      Request request = chain.request();
      Response response = chain.proceed(request);
      return response.newBuilder()
        .removeHeader("Pragma")
        .removeHeader("Cache-Control")
        //cache for 30 days
        .header("Cache-Control", "max-age=" + 3600 * 24 * 30)
        .build();
    }
  }
}
