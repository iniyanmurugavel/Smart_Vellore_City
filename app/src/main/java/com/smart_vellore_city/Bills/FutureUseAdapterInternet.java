package com.smart_vellore_city.Bills;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smart_vellore_city.R;

import java.util.ArrayList;
import java.util.List;

public class FutureUseAdapterInternet extends RecyclerView.Adapter<FutureUseAdapterInternet.ViewHolder>{
    Context context;
    LinearLayout linear_lay;
    private List<FutureListBean> futureListBean;
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView c_id,c_board,brd_name,tvNumberTitle;
        LinearLayout mylist;
        Context context;
        public ViewHolder(View itemView) {
            super(itemView);
            c_id = (TextView)itemView.findViewById(R.id.row_id);
            c_board =(TextView)itemView.findViewById(R.id.row_board);
            tvNumberTitle =(TextView)itemView.findViewById(R.id.number_title);
            brd_name =(TextView)itemView.findViewById(R.id.boardName);
            linear_lay= (LinearLayout) itemView.findViewById(R.id.linear_lay_add);

            mylist = (LinearLayout)itemView.findViewById(R.id.mylist_future);


            context = itemView.getContext();

        }
    }

    public FutureUseAdapterInternet(Context context, ArrayList<FutureListBean> futureListBean){
        this.futureListBean=futureListBean;
        this.context = context;

    }

    @Override
    public FutureUseAdapterInternet.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.future_row_recycler_internet,parent,false);
        return new FutureUseAdapterInternet.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final FutureUseAdapterInternet.ViewHolder holder, final int position) {
        holder.c_id.setText(futureListBean.get(position).getConsumerId());
        holder.c_board.setText(futureListBean.get(position).getConsumerBoard());


        if (futureListBean.get(position).getType().equalsIgnoreCase("landline")){

            holder.tvNumberTitle.setText("Landline Number");

            holder.brd_name.setText("Landline Operator");

            holder.mylist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Landline landline = (Landline) context;
                    landline.etOperator.setText(futureListBean.get(position).getConsumerBoard());
                    landline.etMobileNo.setText(futureListBean.get(position).getConsumerId());
                }
            });

        }else{
            holder.tvNumberTitle.setText("Mobile Number");

            holder.brd_name.setText("Mobile Operator");
            holder.mylist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Internet internet = (Internet) context;
                    internet.etOperator.setText(futureListBean.get(position).getConsumerBoard());
                    internet.etMobileNo.setText(futureListBean.get(position).getConsumerId());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return futureListBean.size();
    }

    public void change(List<FutureListBean> futureListBean, int po) {
        this.futureListBean = remove(futureListBean,po);
        notifyDataSetChanged();
    }
    public List<FutureListBean> remove(List<FutureListBean> getList,int i)
    {
        List<FutureListBean> array = getList;
        Log.e("size","--be--"+array.size());
        array.remove(i);
        Log.e("size","--af--"+array.size());
        return array;
    }
}

