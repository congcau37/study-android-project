package demo.utt37.congcau.appquanlychitieu.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import demo.utt37.congcau.appquanlychitieu.R;
import demo.utt37.congcau.appquanlychitieu.database.quanlychitieuDTO;

/**
 * Created by cong on 12/30/2017.
 */

public class ListQLCTAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<quanlychitieuDTO> quanlychitieuDTOS;

    public ListQLCTAdapter(Context context, int layout, List<quanlychitieuDTO> quanlychitieuDTOS) {
        this.context = context;
        this.layout = layout;
        this.quanlychitieuDTOS = quanlychitieuDTOS;
    }
    public class ViewHolder{
        TextView itemNgay,itemThang,itemLiDo,itemSoTien,itemSoDu,itemLoaiGiaoDich;
    }

    @Override
    public int getCount() {
        return quanlychitieuDTOS.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){

            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            inflater.inflate(layout,null);
            viewHolder.itemNgay = (TextView) view.findViewById(R.id.itemNgay);
            viewHolder.itemLiDo = (TextView) view.findViewById(R.id.itemNoiDung);
            viewHolder.itemLoaiGiaoDich = (TextView) view.findViewById(R.id.itemLoaiGiaooDich);
            viewHolder.itemSoDu = (TextView) view.findViewById(R.id.itemSoDu);
            viewHolder.itemThang = (TextView) view.findViewById(R.id.itemThang);
            viewHolder.itemSoTien = (TextView) view.findViewById(R.id.itemSoTien);
            view.setTag(viewHolder);
        }else {

            viewHolder= (ViewHolder) view.getTag();
        }
        quanlychitieuDTO dto = quanlychitieuDTOS.get(i);

        viewHolder.itemSoTien.setText(String.valueOf(dto.getSotien()));
        viewHolder.itemThang.setText(String.valueOf(dto.getThang()));
        viewHolder.itemSoDu.setText(String.valueOf(dto.getSodu()));
        viewHolder.itemLoaiGiaoDich.setText(String.valueOf(dto.getLoaigiaodich()));
        viewHolder.itemLiDo.setText(dto.getNoidung());
        viewHolder.itemNgay.setText(dto.getNgay());
        return view;

    }


}
