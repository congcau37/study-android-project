package com.app.acaziasoft.vncalendar.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.app.acaziasoft.vncalendar.R;
import com.app.acaziasoft.vncalendar.manager.CalendarUtils;

import java.util.Stack;

/**
 * Created by duyth on 11/30/2017.
 */

public class BaseActivity extends AppCompatActivity {
    private Stack<Fragment> fragments;
    private String TAG = "123";
    private Activity activity;
    private boolean pressedOneMore;
    public boolean enbBackPressMore;

    public void initData(Activity activity, Stack<Fragment> fragments) {
        this.fragments = fragments;
        this.activity = activity;
    }

    public void pushFragment(int id, Fragment fragment, int animateIn, String position, boolean addbackstack) {
        fragments.push(fragment);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (animateIn != -1) {
            ft.setCustomAnimations(animateIn, 0);
        }
        try {
            ft.add(id, fragment, fragment.getClass().getName() + position);
            if(addbackstack)
                ft.addToBackStack(fragment.getClass().getSimpleName() + position);

            ft.commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public void popFragment(int animateOut, int depth) {
        if (this == null) {
            return;
        }
        if (depth < 1) {
            return;
        }
        Fragment currentFragment = fragments.isEmpty() ? null : fragments.peek();

        if (fragments.size() < 2) {
            finish();
            return;
        }

        while (depth > 0) {
            if (!fragments.empty())
                fragments.pop();
            depth--;
            if (fragments.size() < 2) {
                break;
            }
        }

        Fragment fragment = fragments.peek();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (currentFragment != null) {
            if (animateOut != -1) {
                ft.setCustomAnimations(0, animateOut);
            }
            ft.remove(currentFragment);
        }
        ft.replace(R.id.layout_main, fragment, fragment.getClass().getName())
                .addToBackStack(null).commitAllowingStateLoss();
        if (this == null) {
            return;
        }

        getSupportFragmentManager().executePendingTransactions();
    }

    public void showToast(String message, Context context) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        if (fragments != null) {
            if (fragments.size() > 1) {
                popFragment(-1, 1);
                return;
            } else
                checkBackstack();
        } else
            checkBackstack();

    }

    private void checkBackstack() {
        if (enbBackPressMore) {
            if (pressedOneMore) {
                finish();
            } else {
                pressedOneMore = true;
                showToast(getString(R.string.press_once_more_to_exit), this);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pressedOneMore = false;
                    }
                }, 2500);
            }
        } else {
            finish();
        }
    }
}
