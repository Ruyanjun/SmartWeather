package com.roydon.smartweather.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.roydon.smartweather.R;
import com.roydon.smartweather.bean.ProvinceBean;

import java.util.List;

public class ProvinceAdapter extends RecyclerView.Adapter<ProvinceAdapter.ProvinceViewHolder> {

    private Context mContext;
    private List<ProvinceBean> mProvinceBeans;

    public ProvinceAdapter(Context context, List<ProvinceBean> provinceBeans) {
        mContext = context;
        this.mProvinceBeans = provinceBeans;
    }

    class ProvinceViewHolder extends RecyclerView.ViewHolder {

        TextView tvProvince;

        public ProvinceViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProvince = itemView.findViewById(R.id.tv_province_list);
            //绑定点击事件
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

//                    ToastUtil.showShotToast(mContext, "data==" + mProvinceBeans.get(getLayoutPosition()));
                    if (onItemClickListener!=null) {
                        onItemClickListener.onItemClick(view,getLayoutPosition());
                    }

                }
            });

        }

    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ProvinceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.province, parent, false);
        ProvinceViewHolder provinceViewHolder = new ProvinceViewHolder(view);
        return provinceViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProvinceViewHolder holder, int position) {
        ProvinceBean provinceBean = mProvinceBeans.get(position);

        holder.tvProvince.setText(provinceBean.getPname());

    }

    @Override
    public int getItemCount() {
        return (mProvinceBeans == null) ? 0 : mProvinceBeans.size();
    }


}
