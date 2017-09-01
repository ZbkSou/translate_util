package com.ihaveu.iuzuan.translate_tool.injection.components;

import com.ihaveu.iuzuan.translate_tool.injection.modules.ActivityModule;
import com.ihaveu.iuzuan.translate_tool.injection.modules.ActivityScope;
import com.ihaveu.iuzuan.translate_tool.main.MainActivity;

import dagger.Component;

/**
 * Created for Translate_tool
 * User: bkzhou
 * Date: 2017/9/1
 * Contact with zhoubk1451@163.com
 */
@ActivityScope
@Component(modules = {ActivityModule.class},dependencies = {AppComponent.class})
public interface ActivityComponent {
    void inject(MainActivity activity);
//    void inject(WordsBookActivity activity);
//    void inject(ProcessTextActivity activity);
//    void inject(ListenClipboardService service);
    //void inject(AcknowledgementsActivity activity);
}
