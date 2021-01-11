package com.example.commerce.adapter.bytes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.commerce.R;
import com.example.commerce.bean.ByteBean;

import java.util.ArrayList;


public class ByteTextAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private ColumnLayoutHelper columnLayoutHelper;
    private ArrayList<ByteBean.DataBeanX.DataBean> Special;


    public ByteTextAdapter(Context context, ColumnLayoutHelper columnLayoutHelper, ArrayList<ByteBean.DataBeanX.DataBean> special) {
        this.context = context;
        this.columnLayoutHelper = columnLayoutHelper;
        Special = special;
    }

    private OnClick onClick;

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return columnLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_bytetext, parent, false);
        return new Column1ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Column1ViewHolder holder1= (Column1ViewHolder) holder;

        holder1.button1Special.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onClick!=null)
                    onClick.itemOnClick(1);
            }
        });
        holder1.button2Special.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onClick!=null)
                    onClick.itemOnClick(2);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (Special.size() > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    class Column1ViewHolder extends RecyclerView.ViewHolder {
        private Button button1Special;
        private Button button2Special;
        public Column1ViewHolder(@NonNull View itemView) {
            super(itemView);
            button1Special = (Button) itemView.findViewById(R.id.tv_previous);
            button2Special = (Button) itemView.findViewById(R.id.tv_next);

        }
    }
    public interface OnClick{
        void itemOnClick(int poistion);
    }
}
