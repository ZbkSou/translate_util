package com.ihaveu.iuzuan.translate_tool.model;

import com.ihaveu.iuzuan.translate_tool.bean.BaiDuResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created with Android Studio.
 * Created for Translate_tool
 * User: bkzhou
 * Date: 2017/8/30
 * Contact with zhoubk1451@163.com
 */
public interface ApiBaidu {
  //http://api.fanyi.baidu.com/api/trans/vip/translate?q=apple&from=en&to=zh&appid=2015063000000001&salt=1435660288&sign=f89f9594663708c1605f3d736d01d2d4
  @GET("api/trans/vip/translate?")
  Observable<BaiDuResult> translateBaiDu(
    @Query("q") String q,
    @Query("from")String from,
    @Query("to")String to,
    @Query("appid")String appid,
    @Query("salt")String salt,
    @Query("sign")String sign
  );
}
