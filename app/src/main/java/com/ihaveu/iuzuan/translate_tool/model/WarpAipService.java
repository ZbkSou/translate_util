package com.ihaveu.iuzuan.translate_tool.model;

import com.ihaveu.iuzuan.translate_tool.BuildConfig;
import com.ihaveu.iuzuan.translate_tool.bean.AbsResult;
import com.ihaveu.iuzuan.translate_tool.bean.BaiDuResult;
import com.ihaveu.iuzuan.translate_tool.model.type.ETranslateFrom;
import com.ihaveu.iuzuan.translate_tool.util.SignUtils;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created for Translate_tool
 * User: bkzhou
 * Date: 2017/8/30
 * Contact with zhoubk1451@163.com
 */
public class WarpAipService {
  private  ApiBaidu mApiBaidu;
  @Inject
  public WarpAipService(ApiBaidu mApiBaidu) {
    this.mApiBaidu = mApiBaidu;
//    this.mApiJinShan = mApiJinShan;
//    this.mApiYouDao = mApiYouDao;
//    this.mApiGoogle = mApiGoogle;
  }
  public Observable<AbsResult> translate(ETranslateFrom way, String query) {
    Observable<AbsResult> resultObservable = null;
    query = query.toLowerCase();
    switch (way){
//      case YOU_DAO:
//        resultObservable = mApiYouDao.translateYouDao(
//          query,
//          BuildConfig.YOUDAO_USERNAME,
//          BuildConfig.YOUDAO_KEY,
//          BuildConfig.YOUDAO_TYPE,
//          BuildConfig.RESULT_JSON,
//          BuildConfig.YOUDAO_VERSION)
//          .flatMap(new Func1<YouDaoResult, Observable<AbsResult>>() {
//            @Override
//            public Observable<AbsResult> call(YouDaoResult youDaoResult) {
//              return Observable.just(youDaoResult);
//            }
//          });
//        break;
//      case JIN_SHAN:
//        resultObservable = mApiJinShan.translateJinShan(
//          query,
//          //JINSHAN_FANYI_KEY
//          BuildConfig.ICIBA_KEY,
//          BuildConfig.RESULT_JSON)
//          .flatMap(new Func1<JinShanResult, Observable<AbsResult>>() {
//            @Override
//            public Observable<AbsResult> call(JinShanResult result) {
//              return Observable.just(result);
//            }
//          });
//        break;
      case BAI_DU:
        String salt = SignUtils.getRandomInt(10);
        String sign = SignUtils.getSign(BuildConfig.BAIDU_APP_ID, query, salt, BuildConfig.BAIDU_SCREAT_KEY);
        resultObservable = mApiBaidu.translateBaiDu(
          query,
          BuildConfig.LANGUAGE_AUTO,
          BuildConfig.LANGUAGE_AUTO,
          BuildConfig.BAIDU_APP_ID,
          salt,
          sign)
          .flatMap(new Func1<BaiDuResult, Observable<AbsResult>>() {
            @Override
            public Observable<AbsResult> call(BaiDuResult baiDuResult) {
              return  Observable.just((AbsResult)baiDuResult);
            }
          });
        break;
//      case GOOGLE:
//        String targetLanguage;
//        //String patternWords = "[a-zA-Z1-9 ]{1,}";
//        String patternWords = "[\u4e00-\u9fa5 ]{1,}";
//        Pattern r = Pattern.compile(patternWords);
//        Matcher m = r.matcher(query);
//        if(!m.matches()){
//          targetLanguage = BuildConfig.GOOGLE_LANGUAGE_CHINEASE;
//        }
//        else {
//          targetLanguage = BuildConfig.GOOGLE_LANGUAGE_ENGLISH;
//        }
//
//        resultObservable = mApiGoogle.translateGoogle(query, targetLanguage)
//          .flatMap(new Func1<ResponseBody, Observable<AbsResult>>() {
//            @Override
//            public Observable<AbsResult> call(ResponseBody result) {
//              GoogleResult googleResult = new GoogleResult();
//              try{
//                googleResult.setTranslationResult(result.string());
//              }catch (IOException e){
//                e.printStackTrace();
//              }
//              return Observable.just(googleResult);
//            }
//          });
//        break;
    }
    return resultObservable;
  }
}
