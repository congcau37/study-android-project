package com.app.acaziasoft.vncalendar.manager;

import android.content.Context;
import android.util.Log;

import com.app.acaziasoft.vncalendar.R;
import com.app.acaziasoft.vncalendar.model.MonthModel;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by duyth on 12/13/2017.
 */

public enum AppPreference {
    INSTANCE;

    public Map<String, String[]> festivalCalendar;
    public Map<String, String[]> festivalLunar;
    public Map<String, String[]> dayoff;
    public String[] array;
    public String[] array_full;

    public final int RANGE_CALENDAR = 10;
    public MonthModel model_select;
    public Calendar today = Calendar.getInstance();

    Context context;

    public void init(Context context) {
        this.context = context;
        if (festivalCalendar == null)
            festivalCalendar = new HashMap<>();
        if (festivalLunar == null)
            festivalLunar = new HashMap<>();
        if (dayoff == null)
            dayoff = new HashMap<>();
        array = context.getResources().getStringArray(R.array.array_month);
        array_full = context.getResources().getStringArray(R.array.array_month_full);
        loadFestival();
        loadDayOff();
    }

    private void loadFestival() {
        //thang 1
        addFestivalSolar(1, 0, new String[]{context.getString(R.string.tet_duong_lich)});
        addFestivalSolar(9, 0, new String[]{context.getString(R.string.sinh_vien_vn)});

        addFestivalLunar(1, 0, new String[]{context.getString(R.string.tet_nguyen_dan)});
        addFestivalLunar(15, 0, new String[]{context.getString(R.string.tet_nguyen_tieu)});

        //thang 2
        addFestivalSolar(3, 1, new String[]{context.getString(R.string.thanh_lap_dcsvn)});

        //thang 3
        addFestivalSolar(8, 2, new String[]{context.getString(R.string.quoc_te_phu_nu)});
        addFestivalSolar(20, 2, new String[]{context.getString(R.string.quoc_te_hp)});
        addFestivalSolar(22, 2, new String[]{context.getString(R.string.nuoc_sach_tg)});
        addFestivalSolar(26, 2, new String[]{context.getString(R.string.thanh_lap_tncshcm)});
        addFestivalSolar(27, 2, new String[]{context.getString(R.string.the_thao_vn)});

        addFestivalLunar(3, 2, new String[]{context.getString(R.string.tet_han_thuc)});
        addFestivalLunar(10, 2, new String[]{context.getString(R.string.gio_to_hung_vuong)});

        //thang 4
        addFestivalSolar(21, 3, new String[]{context.getString(R.string.sach_vn)});
        addFestivalSolar(22, 3, new String[]{context.getString(R.string.ngay_trai_dat)});
        addFestivalSolar(30, 3, new String[]{context.getString(R.string.giai_phong_mien_nam)});

        addFestivalLunar(14, 3, new String[]{context.getString(R.string.tet_khmer)});
        addFestivalLunar(15, 3, new String[]{context.getString(R.string.tet_phat_dan)});

        //thang 5
        addFestivalSolar(1, 4, new String[]{context.getString(R.string.quoc_te_ld)});
        addFestivalSolar(7, 4, new String[]{context.getString(R.string.chien_thang_dbp)});
        addFestivalSolar(15, 4, new String[]{context.getString(R.string.thanh_lap_tntphcb)});
        addFestivalSolar(19, 4, new String[]{context.getString(R.string.ngay_sinh_hcm)});

        addFestivalLunar(5, 4, new String[]{context.getString(R.string.tet_doan_ngo)});

        //thang 6
        addFestivalSolar(1, 5, new String[]{context.getString(R.string.quoc_te_thieu_nhi)});
        addFestivalSolar(5, 5, new String[]{context.getString(R.string.bac_ho_tim_duong), context.getString(R.string.moi_truong_tg)});
        addFestivalSolar(28, 5, new String[]{context.getString(R.string.gia_dinh_viet_nam)});

        //thang 7
        addFestivalSolar(27, 6, new String[]{context.getString(R.string.thuong_binh_liet_si)});

        addFestivalLunar(15, 6, new String[]{context.getString(R.string.vu_lan)});

        //thang 8
        addFestivalSolar(19, 7, new String[]{context.getString(R.string.cach_mang_t8)});

        addFestivalLunar(1, 7, new String[]{context.getString(R.string.tet_kate)});
        addFestivalLunar(15, 7, new String[]{context.getString(R.string.trung_thu)});

        //thang 9
        addFestivalSolar(2, 8, new String[]{context.getString(R.string.quoc_khanh)});

        addFestivalLunar(9, 8, new String[]{context.getString(R.string.tet_trung_cuu)});

        //thang 10
        addFestivalSolar(13, 9, new String[]{context.getString(R.string.doanh_nhan_vn)});
        addFestivalSolar(20, 9, new String[]{context.getString(R.string.hoi_pn_vn)});

        addFestivalLunar(10, 9, new String[]{context.getString(R.string.tet_trung_thap)});

        //thang 11
        addFestivalSolar(20, 10, new String[]{context.getString(R.string.nha_giao_vn)});

        //thang 12
        addFestivalSolar(22, 11, new String[]{context.getString(R.string.qd_nd_vn)});
        addFestivalSolar(25, 11, new String[]{context.getString(R.string.giang_sinh)});

        addFestivalLunar(12, 11, new String[]{context.getString(R.string.ong_tao)});
    }

    private void loadDayOff() {
        //lich nghi nam 2018
        //tet duong lich
        setCalendarDayOff(30, 11, 2017, 1, 0, 2018, new String[]{context.getResources().getString(R.string.new_year_date)});

        //tet nguyen dan
        setCalendarDayOff(14, 1, 2018, 20, 1, 2018, new String[]{context.getResources().getString(R.string.am_lich_date)});

        //gio to Hung Vuong
        setCalendarDayOff(25, 3, 2018, 25, 3, 2018, new String[]{context.getResources().getString(R.string.gio_to_hung_vuong)});

        //giai phong mien nam va quoc te lao dong
        setCalendarDayOff(28, 3, 2018, 1, 4, 2018, new String[]{context.getResources().getString(R.string.giai_phong_mien_nam), context.getResources().getString(R.string.quoc_te_ld)});

        //quoc khanh
        setCalendarDayOff(1, 8, 2018, 3, 8, 2018, new String[]{context.getResources().getString(R.string.quoc_khanh)});
    }

    private void addFestivalSolar(int day, int month, String[] festival) {
        festivalCalendar.put(String.valueOf(day) + "/" + String.valueOf(month), festival);
    }

    private void addFestivalLunar(int day, int month, String[] festival) {
        festivalLunar.put(String.valueOf(day) + "/" + String.valueOf(month), festival);
    }

    private void setCalendarDayOff(int day, int month, int year, int dayend, int monthend, int yearend, String[] text) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(year, month, day);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(yearend, monthend, dayend + 1);
        while (calendar1.before(calendar2)) {
            addDayOff(calendar1.get(Calendar.DATE), calendar1.get(Calendar.MONTH), calendar1.get(Calendar.YEAR),
                    text);
            calendar1.add(Calendar.DATE, 1);
        }
    }

    private void addDayOff(int day, int month, int year, String[] text) {
        dayoff.put(String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year), text);
    }
}
