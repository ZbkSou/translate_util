package com.ihaveu.iuzuan.translate_tool.util;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.widget.EditText;

/**
 * Created for Translate_tool
 * User: bkzhou
 * Date: 2017/9/1
 * Contact with zhoubk1451@163.com
 */
public class ViewUtil {
    /**
     * 设置输入框的光标到末尾
     */
    public static final void setEditTextSelectionToEnd(EditText editText) {
        Editable editable = editText.getEditableText();
        Selection.setSelection((Spannable) editable,
            editable.toString().length());
    }
}
