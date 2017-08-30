package com.ihaveu.iuzuan.translate_tool.base;

import android.support.v7.app.AppCompatActivity;

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
}
