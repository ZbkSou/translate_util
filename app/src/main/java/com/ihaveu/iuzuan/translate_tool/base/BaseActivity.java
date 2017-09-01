package com.ihaveu.iuzuan.translate_tool.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.ihaveu.iuzuan.translate_tool.injection.components.AppComponent;
import com.ihaveu.iuzuan.translate_tool.injection.modules.ActivityModule;

import javax.inject.Inject;

/**
 * Created for Translate_tool
 * User: bkzhou
 * Date: 2017/8/30
 * Contact with zhoubk1451@163.com
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView{
  @Inject
  protected  P mPresenter;
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setupActivityComponent(BaseApplication.getAppComponent(),new ActivityModule(this));
    mPresenter.attachView(this);
  }
  /**
   * 依赖注入的入口
   * @param appComponent appComponent
   */
  protected abstract void setupActivityComponent(AppComponent appComponent, ActivityModule activityModule);
  protected void initActionBar(boolean homeButtonEnable,String title){
    getSupportActionBar().setHomeButtonEnabled(homeButtonEnable);
    getSupportActionBar().setDisplayHomeAsUpEnabled(homeButtonEnable);
    getSupportActionBar().setTitle(title);
  }
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()){
      case android.R.id.home:
        onBackPressed();
        break;
    }
    return super.onOptionsItemSelected(item);
  }
}
