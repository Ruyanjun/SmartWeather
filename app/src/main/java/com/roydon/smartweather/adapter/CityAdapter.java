package com.roydon.smartweather.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.roydon.smartweather.R;
import com.roydon.smartweather.bean.CityBean;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder>{

    private Context mContext;
    private List<CityBean> mCityBeans;

    public CityAdapter(Context context, List<CityBean> cityBeans) {
        mContext = context;
        this.mCityBeans = cityBeans;
    }


    class CityViewHolder extends RecyclerView.ViewHolder {

        TextView cityWaitSearch;

        public CityViewHolder(@NonNull View itemView) {
            super(itemView);

            cityWaitSearch=itemView.findViewById(R.id.city_wait_search);
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
        public void onItemLongClick(View view,int position);

    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.city, parent, false);
        CityViewHolder cityViewHolder = new CityViewHolder(view);
        return cityViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {

        CityBean cityBean = mCityBeans.get(position);

        holder.cityWaitSearch.setText(cityBean.getName());
    }

    @Override
    public int getItemCount() {
        return (mCityBeans == null) ? 0 : mCityBeans.size();
    }



}
