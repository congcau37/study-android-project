package com.app.acaziasoft.vncalendar.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.acaziasoft.vncalendar.R;
import com.app.acaziasoft.vncalendar.manager.AppPreference;
import com.app.acaziasoft.vncalendar.manager.DataManager;
import com.app.acaziasoft.vncalendar.manager.DiffUtil.MonthDiffCallback;
import com.app.acaziasoft.vncalendar.model.MonthModel;
import com.app.acaziasoft.vncalendar.ui.interfaces.BaseEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by duyth on 12/04/2017.
 */

public class MonthAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<MonthModel> monthModels = new ArrayList<>();
    Context context;

    private final static int TYPE_EMPTY = 1,
            TYPE_TITLE = 2, TYPE_DAY = 3;

    public void updateList(final ArrayList<MonthModel> monthModels) {
        final ArrayList<MonthModel> old_item = new ArrayList<>(this.monthModels);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new MonthDiffCallback(old_item, monthModels));
        this.monthModels.clear();
        this.monthModels.addAll(monthModels);
        diffResult.dispatchUpdatesTo(this);
    }

    @Override
    public int getItemViewType(int position) {
        if (monthModels.get(position).getCalendar_lunar() == null && monthModels.get(position).getTextMonth() != "") {
            return TYPE_TITLE;
        } else if (monthModels.get(position).getCalendar_lunar() == null && monthModels.get(position).getTextMonth() == "") {
            return TYPE_EMPTY;
        }
        return TYPE_DAY;
    }

    public MonthAdapter(ArrayList<MonthModel> monthModels, Context context) {
        this.monthModels.addAll(monthModels);
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case TYPE_EMPTY:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_day_empty, parent, false);
                viewHolder = new MonthAdapter.EmptyDayViewHolder(view);
                break;
            case TYPE_TITLE:
                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_month_title, parent, false);
                viewHolder = new MonthAdapter.TitleMonthViewHolder(view1);
                break;
            default:
                View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_day, parent, false);
                viewHolder = new MonthAdapter.DayViewHolder(view2);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewtype = holder.getItemViewType();
        switch (viewtype) {
            case TYPE_EMPTY:
                ((EmptyDayViewHolder) holder).bind(monthModels.get(position));
                break;
            case TYPE_TITLE:
                ((TitleMonthViewHolder) holder).bind(monthModels.get(position));
                break;
            default:
                ((DayViewHolder) holder).bind(monthModels.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return monthModels == null ? 0 : monthModels.size();
    }

    public static class EmptyDayViewHolder extends RecyclerView.ViewHolder {

        public EmptyDayViewHolder(View itemView) {
            super(itemView);
        }

        public void bind(MonthModel monthModel) {
        }
    }

    public static class TitleMonthViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvMonth)
        TextView tvMonth;

        public TitleMonthViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(MonthModel monthModel) {
            tvMonth.setText(monthModel.getTextMonth());
        }
    }

    public class DayViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.tvCalendar)
        TextView tvCalendar;

        @BindView(R.id.tvLunar)
        TextView tvLunar;

        @BindView(R.id.imgFestival)
        ImageView imgFestival;

        public DayViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void bind(final MonthModel monthModel) {
            if (monthModel.getCalendar() != null) {
                tvCalendar.setText(String.valueOf(monthModel.getCalendar().get(Calendar.DATE)));
                tvLunar.setText(monthModel.getCalendar_lunar()[0] == 1
                        ? "1/" + String.valueOf(monthModel.getCalendar_lunar()[1] + 1)
                        : String.valueOf(monthModel.getCalendar_lunar()[0]));

                if (monthModel.isSelect()) {
                    tvCalendar.setBackground(itemView.getContext().getResources().getDrawable(R.drawable.bg_circle_red));
                    tvCalendar.setTextColor(itemView.getContext().getResources().getColor(R.color.color_white));
                } else if (monthModel.isToday()) {
                    tvCalendar.setBackground(itemView.getContext().getResources().getDrawable(R.drawable.bg_circle_green));
                    tvCalendar.setTextColor(itemView.getContext().getResources().getColor(R.color.color_white));
                } else if (monthModel.isDayoff()) {
                    tvCalendar.setTextColor(itemView.getContext().getResources().getColor(R.color.color_red));
                    tvCalendar.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.color_white));
                } else {
                    tvCalendar.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.color_white));
                    tvCalendar.setTextColor(monthModel.getDay_of_week() == 1 || monthModel.getDay_of_week() == 7
                            ? itemView.getContext().getResources().getColor(R.color.color_gray)
                            : itemView.getContext().getResources().getColor(R.color.color_blank));
                }
                imgFestival.setVisibility(monthModel.isFestival() ? View.VISIBLE : View.GONE);
            }
        }

        @Override
        public void onClick(View view) {
            changeFocus();
            if (monthModels.get(getAdapterPosition()).isFestival() || monthModels.get(getAdapterPosition()).isDayoff()) {
                EventBus.getDefault().post(new BaseEvent.ShowFestival(monthModels.get(getAdapterPosition())));
            }
        }

        private void changeFocus() {
            monthModels.get(getAdapterPosition()).setSelect(true);
            notifyItemChanged(getAdapterPosition());
            if (AppPreference.INSTANCE.model_select != null) {
                try {
                    int index_current = monthModels.indexOf(AppPreference.INSTANCE.model_select);
                    monthModels.get(index_current).setSelect(false);
                    notifyItemChanged(index_current);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            AppPreference.INSTANCE.model_select = monthModels.get(getAdapterPosition());
        }
    }
}
