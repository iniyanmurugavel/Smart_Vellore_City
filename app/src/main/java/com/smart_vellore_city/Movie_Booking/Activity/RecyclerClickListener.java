package com.smart_vellore_city.Movie_Booking.Activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by admin on 12-06-2017.
 */

public class RecyclerClickListener implements RecyclerView.OnItemTouchListener {
    private OnItemTouchListener mlistener;
    GestureDetector detector;

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View childView = rv.findChildViewUnder(e.getX(),e.getY());
        if (childView != null && mlistener != null && detector.onTouchEvent(e)){
            mlistener.OnItemCLikc(childView,rv.getChildAdapterPosition(childView));
            return true;
        }return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public interface OnItemTouchListener{
        public void OnItemCLikc(View view, int position);
    }

    public RecyclerClickListener(Context context, OnItemTouchListener listener){
        mlistener = listener;
        detector = new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }
}
