package com.app.acaziasoft.vncalendar.ui.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.app.acaziasoft.vncalendar.R;
import com.app.acaziasoft.vncalendar.ui.fragment.CalendarMonthFragment;

import java.util.Stack;

public class MainActivity extends BaseActivity {

    private Stack<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        pushFragment(R.id.layout_main, CalendarMonthFragment.newInstance(), -1, "", true);
        enbBackPressMore = true;
    }

    private void init() {
        if (fragments == null)
            fragments = new Stack<>();
        initData(this, fragments);
    }
}
