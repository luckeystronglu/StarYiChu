package fragment;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2016/8/12.
 */
public class ForbidViewPager extends ViewPager{
    private boolean isScrollable = true;
    public ForbidViewPager(Context context) {
        this(context,null);
    }

    public ForbidViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (isScrollable){
            return false;
        }else {
            return super.onTouchEvent(ev);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (isScrollable){
            return false;
        }else {
            return super.onInterceptTouchEvent(ev);
        }
    }
}
