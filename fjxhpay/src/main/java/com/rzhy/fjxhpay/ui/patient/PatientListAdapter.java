package com.rzhy.fjxhpay.ui.patient;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.rzhy.fjxhpay.R;
import com.rzhy.fjxhpay.mvp.patient.PatientListModel;
import com.rzhy.fjxhpay.ui.base.BasicAdapter;

import java.util.List;

/**
 */

public class PatientListAdapter extends BasicAdapter<PatientListModel.BindUserEntity> {

    private int checked = -1;

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public int getChecked() {
        return checked;
    }

    public PatientListAdapter(Context context) {
        super(context);
    }

    public PatientListAdapter(Context context, List<PatientListModel.BindUserEntity> data) {
        super(context, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_patient, null);
            holder = new Holder();
            holder.radio = (RadioButton) convertView.findViewById(R.id.radio);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.cardNo = (TextView) convertView.findViewById(R.id.card_no);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        if (getData() != null) {
            holder.radio.setChecked(position == checked);
            holder.name.setText(getData().get(position).getName());
            String type = getData().get(position).getBindType() == 1 ? "(门诊)" : "(住院)";
            holder.cardNo.setText(getData().get(position).getBindNum() + type);
        }
        return convertView;
    }

    class Holder {
        RadioButton radio;
        TextView name;
        TextView cardNo;
    }
}
