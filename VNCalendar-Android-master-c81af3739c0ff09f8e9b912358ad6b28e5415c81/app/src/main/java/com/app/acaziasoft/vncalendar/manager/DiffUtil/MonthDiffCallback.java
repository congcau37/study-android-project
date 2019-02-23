package com.app.acaziasoft.vncalendar.manager.DiffUtil;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import com.app.acaziasoft.vncalendar.model.MonthModel;

import java.util.ArrayList;

/**
 * Created by duyth on 12/11/2017.
 */

public class MonthDiffCallback extends DiffUtil.Callback {
    ArrayList<MonthModel> monthModels_old;
    ArrayList<MonthModel> monthModels_new;

    public MonthDiffCallback(ArrayList<MonthModel> monthModels_old, ArrayList<MonthModel> monthModels_new) {
        this.monthModels_old = monthModels_old;
        this.monthModels_new = monthModels_new;
    }

    @Override
    public int getOldListSize() {
        return monthModels_old == null ? 0 : monthModels_old.size();
    }

    @Override
    public int getNewListSize() {
        return monthModels_new == null ? 0 : monthModels_new.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return monthModels_old.get(oldItemPosition) == monthModels_new.get(newItemPosition);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return monthModels_old.get(oldItemPosition).equals(monthModels_new.get(newItemPosition));
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
