package com.ihaveu.iuzuan.translate_tool.main;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatSpinner;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ihaveu.iuzuan.translate_tool.R;
import com.ihaveu.iuzuan.translate_tool.base.BaseActivity;
import com.ihaveu.iuzuan.translate_tool.bean.Result;
import com.ihaveu.iuzuan.translate_tool.injection.components.AppComponent;
import com.ihaveu.iuzuan.translate_tool.injection.components.DaggerActivityComponent;
import com.ihaveu.iuzuan.translate_tool.injection.modules.ActivityModule;
import com.ihaveu.iuzuan.translate_tool.model.type.ETranslateFrom;
import com.ihaveu.iuzuan.translate_tool.util.InputMethodUtils;
import com.ihaveu.iuzuan.translate_tool.util.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created for Translate_tool
 * User: bkzhou
 * Date: 2017/8/30
 * Contact with zhoubk1451@163.com
 */
public class MainActivity extends BaseActivity<MainPresenter> implements IMainView {
    @BindView(android.R.id.input)
    EditText mInput;
    @BindView(R.id.list_result)
    LinearLayout mList;
    @BindView(R.id.sp_translate_way)
    AppCompatSpinner mSpTranslateWay;

    @BindView(R.id.iv_favorite)
    ImageView mIvFavorite;
    @BindView(R.id.iv_sound)
    ImageView mIvSound;
    @BindView(R.id.iv_paste)
    ImageView mIvPaste;
    @BindView(R.id.tv_clear)
    TextView mTvClear;
    @BindView(R.id.rl_action)
    RelativeLayout mRlAction;
    @BindView(R.id.bt_translate)
    Button mBtTranslate;

    //  @BindView(R.id.tv_dayline)
//  TextView mTvDayline;
//  @BindView(R.id.tv_dayline_note)
//  TextView mTvDaylineNote;
//  @BindView(R.id.iv_sound_dayline)
//  AppCompatImageView mIvSoundDayline;
    @BindView(R.id.main_content)
    CoordinatorLayout coordinatorLayout;
    Menu mMenu;

    private boolean isFavorite;

    private BottomSheetBehavior mBottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("sd","sdf");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        addListener();
        Log.d("sd","sdf");
        LogUtil.d("addListener");

    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent, ActivityModule activityModule) {
        DaggerActivityComponent.builder()
            .appComponent(appComponent)
            .activityModule(activityModule)
            .build()
            .inject(this);
    }

    @Override
    public void onInitSearchText(String text) {

    }

    @Override
    public void onPrepareTranslate() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void addExplainItem(String explain) {

    }

    @Override
    public void initTranslateEngineSetting(ETranslateFrom way) {

    }

    @Override
    public void onTranslateComplete() {

    }

    @Override
    public void closeKeyboard() {
        InputMethodUtils.closeSoftKeyboard(mInput);
    }

    @Override
    public void showPlaySound() {

    }

    @Override
    public void hidePlaySound() {

    }

    @Override
    public void addTagForView(Result result) {

    }

    @Override
    public void initWithFavorite() {

    }

    @Override
    public void initWithNotFavorite() {

    }

    private void addListener() {
        LogUtil.d("addListener");
        mInput.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                LogUtil.d(keyEvent.getAction()+"");
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (i == KeyEvent.KEYCODE_ENTER)) {
                    translate();
                    return true;
                }
                return false;
            }
        });

        mInput.addTextChangedListener(new TextWatcher() {
            private String mTemp;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mTemp = s.toString();
                LogUtil.d(mTemp);
                mTvClear.setVisibility(mTemp.isEmpty() ? View.INVISIBLE : View.VISIBLE);
            }
        });
    }

    private void translate() {
        LogUtil.d("execute translate");
        closeKeyboard();
        final String input = mInput.getText().toString().trim();
        if (checkInput(input)) {
            mPresenter.executeSearch(input);
        }
    }
    private boolean checkInput(String input) {
        if (isEmptyWord(input, true)) return false;
        //不检查输入的字符串是不是超过两个
//        if (StringUtils.isMoreThanOneWord(input)){
//            String msg = getString(R.string.msg_not_support_sentence);
//            DialogUtil.showSingleMessage(this, msg, getString(R.string.action_know));
//            return false;
//        }
        return true;
    }
    private boolean isEmptyWord(String input, boolean withEmptyPoint) {
        if (TextUtils.isEmpty(input)) {
            if (withEmptyPoint) {
                Toast.makeText(MainActivity.this,"请输入要查询的关键字", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return false;
    }
    @OnClick(R.id.bt_translate)
    public void onClickTranslate(View view) {
//        MobclickAgent.onEvent(getApplicationContext(), "action_translate");
        LogUtil.d("execute bt_translate");
        translate();
    }
}
