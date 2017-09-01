package com.ihaveu.iuzuan.translate_tool.main;

import com.ihaveu.iuzuan.translate_tool.base.IBaseView;
import com.ihaveu.iuzuan.translate_tool.bean.Result;
import com.ihaveu.iuzuan.translate_tool.model.type.ETranslateFrom;

/**
 * Created for Translate_tool
 * User: bkzhou
 * Date: 2017/8/31
 * Contact with zhoubk1451@163.com
 */
public interface IMainView extends IBaseView{

    void onInitSearchText(String text);

    void onPrepareTranslate();

    void onError(Throwable e);

    void addExplainItem(String explain);

    void initTranslateEngineSetting(ETranslateFrom way);

    void onTranslateComplete();

    /**
     * 关闭软键盘
     */
    void closeKeyboard();

    void showPlaySound();

    void hidePlaySound();

    void addTagForView(Result result);

    void initWithFavorite();

    void initWithNotFavorite();

//    void fillDayline(IDayLine entity);

}
