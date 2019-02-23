package com.app.acaziasoft.vncalendar.ui.fragment;

import android.animation.Animator;
import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.app.acaziasoft.vncalendar.R;
import com.app.acaziasoft.vncalendar.adapter.MonthAdapter;
import com.app.acaziasoft.vncalendar.manager.AppPreference;
import com.app.acaziasoft.vncalendar.manager.CalendarUtils;
import com.app.acaziasoft.vncalendar.manager.ControlManager;
import com.app.acaziasoft.vncalendar.manager.DataManager;
import com.app.acaziasoft.vncalendar.manager.InterfacesManager;
import com.app.acaziasoft.vncalendar.model.MonthModel;
import com.app.acaziasoft.vncalendar.ui.activity.BaseActivity;
import com.app.acaziasoft.vncalendar.ui.interfaces.BaseEvent;
import com.app.acaziasoft.vncalendar.ui.interfaces.BaseInterfaces;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by duyth on 11/30/2017.
 */

public class CalendarMonthFragment extends BaseFragment implements View.OnClickListener, BaseInterfaces.loadData, BaseInterfaces.loadMoreData, BaseInterfaces.loadDataFestival {

    @BindView(R.id.recyclerViewMonth)
    RecyclerView recyclerViewMonth;

    @BindView(R.id.tvYear)
    TextView tvYear;

    @BindView(R.id.tvToday)
    TextView tvToday;

    @BindView(R.id.viewLoading)
    View viewLoading;

    ArrayList<MonthModel> monthModels;
    MonthAdapter monthAdapter;
    GridLayoutManager layoutManager;
    Dialog dialog;
    TextView tvSolar, tvLunar, tvDong, tvFestivalSolar, tvFestivalLunar, tvDayOff, tvDay_off;
    boolean loading = false;
    String text = "";

    ControlManager controlManager;

    public static CalendarMonthFragment newInstance() {
        return new CalendarMonthFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_month_calendar, container, false);
        ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        initView();
        return view;
    }

    private void initView() {
        viewLoading.setVisibility(View.VISIBLE);
        //lay du lieu trong manager va bind vao rv
        if (controlManager == null)
            controlManager = new ControlManager(this, this, this);
        controlManager.getData(Calendar.getInstance(), true);
    }

    private void getData(ArrayList<MonthModel> monthModels) {
        if (this.monthModels == null)
            this.monthModels = new ArrayList<>();
        this.monthModels.clear();
        this.monthModels.addAll(monthModels);
    }

    @OnClick(R.id.tvToday)
    public void onClickToday() {
        recyclerViewMonth.stopScroll();
        loading = true;
        controlManager.getData(Calendar.getInstance(), false);
    }

    @OnClick(R.id.tvYear)
    public void onClickYear() {

    }

    private void scrollToIndex() {
        layoutManager.scrollToPositionWithOffset(DataManager.index, 0);
    }

    @Subscribe
    public void onEvent(BaseEvent.ShowFestival showFestival) {
        showDialogFestival(showFestival.monthModel);
    }

    private void showDialogFestival(MonthModel monthModel) {
        if (dialog == null) {
            initDiaLog();
        }
        controlManager.getDataFestival(monthModel);
        dialog.show();
    }

    private void initDiaLog() {
        dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_festival);
        dialog.getWindow().getAttributes().width = ViewGroup.LayoutParams.MATCH_PARENT;
        dialog.getWindow().getAttributes().height = ViewGroup.LayoutParams.WRAP_CONTENT;
        dialog.setCancelable(false);
        tvSolar = dialog.findViewById(R.id.tvSolar);
        tvLunar = dialog.findViewById(R.id.tvLunar);
        tvDong = dialog.findViewById(R.id.tvDong);
        tvFestivalSolar = dialog.findViewById(R.id.tvFestivalSolar);
        tvFestivalLunar = dialog.findViewById(R.id.tvFestivalLunar);
        tvDayOff = dialog.findViewById(R.id.tvDayOff);
        tvDay_off = dialog.findViewById(R.id.tvDay_off);
        tvDong.setOnClickListener(this);
    }

    private void bindTextDialog(String[] strings, TextView tvTitle, TextView tvMain) {
        if (strings != null && strings.length > 0) {
            tvTitle.setVisibility(View.VISIBLE);
            tvMain.setVisibility(View.VISIBLE);
            text = "";
            for (int i = 0; i < strings.length; i++) {
                text = text + "- " + strings[i] + "\n";
            }
            tvMain.setText(text);
        } else {
            tvTitle.setVisibility(View.GONE);
            tvMain.setVisibility(View.GONE);
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View view) {
        if (dialog.isShowing())
            dialog.dismiss();
    }

    @Override
    public void loadData(final ArrayList<MonthModel> monthModels) {
        new AsyncTask<Void, Void, Boolean>() {

            @Override
            protected Boolean doInBackground(Void... voids) {
                getData(monthModels);
                return true;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
                if (aBoolean) {
                    bindRV();
                    scrollRVLister();
                    scrollToIndex();
                    hideScreen();
                }
            }
        }.execute();
    }

    @Override
    public void goToIndex(ArrayList<MonthModel> monthModels) {
        this.monthModels.clear();
        this.monthModels.addAll(monthModels);
        monthAdapter.updateList(monthModels);
        scrollToIndex();
        loading = false;
    }

    private void bindRV() {
        if (recyclerViewMonth != null) {
            layoutManager = new GridLayoutManager(getContext(), 7);
            recyclerViewMonth.setLayoutManager(layoutManager);
            recyclerViewMonth.setHasFixedSize(true);
            if (monthAdapter == null) {
                monthAdapter = new MonthAdapter(monthModels, getContext());
            }
            recyclerViewMonth.setAdapter(monthAdapter);
            recyclerViewMonth.setNestedScrollingEnabled(false);
        }
    }

    private void scrollRVLister() {
        recyclerViewMonth.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int index_item_visible = layoutManager.findFirstVisibleItemPosition();
                int index_item_last = layoutManager.findLastVisibleItemPosition();
                if (monthModels.get(index_item_visible).getCalendar() != null)
                    tvYear.setText(String.valueOf(monthModels.get(index_item_visible).getCalendar().get(Calendar.YEAR)));
                if (!loading && index_item_last + 250 > monthModels.size()) {
                    loading = true;
                    controlManager.getDataBottom();
                } else if (!loading && index_item_visible < 60) {
                    loading = true;
                    controlManager.getDataTop();
                }
            }
        });
    }

    private void hideScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                viewLoading.animate().alpha(0.0f).setDuration(800).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        viewLoading.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            }
        }, 2000);
    }

    @Override
    public void loadDataTop(ArrayList<MonthModel> monthModels) {
        this.monthModels.addAll(0, monthModels);
        monthAdapter.updateList(this.monthModels);
        loading = false;
    }

    @Override
    public void loadDataBottom(ArrayList<MonthModel> monthModels) {
        this.monthModels.addAll(monthModels);
        monthAdapter.updateList(this.monthModels);
        loading = false;
    }

    @Override
    public void loadDataFestivalSolar(String[] strings) {
        bindTextDialog(strings, tvSolar, tvFestivalSolar);
    }

    @Override
    public void loadDataFestivalLunar(String[] strings) {
        bindTextDialog(strings, tvLunar, tvFestivalLunar);
    }

    @Override
    public void loadDataDayOff(String[] strings) {
        bindTextDialog(strings, tvDayOff, tvDay_off);
    }
}
