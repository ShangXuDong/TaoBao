package com.sxd.taobaocoupon.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sxd.taobaocoupon.R;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

public class TextFlowLayout extends ViewGroup{

    public static final float DEFAULT_SPACE = 10;
    private float mItemHorizontalSpace = DEFAULT_SPACE;
    private float mItemVerticalSpace = DEFAULT_SPACE;
    private int mSelfWidth;
    private int mItemHeight;

    private List<String> mTextList = new ArrayList<>();

    private ItemClickListener itemClickListener;

    public TextFlowLayout(Context context) {
        super(context, null);
    }

    public TextFlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public TextFlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //去拿到相关属性
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.TextFlowLayoutStyle);
        mItemHorizontalSpace = ta.getDimension(R.styleable.TextFlowLayoutStyle_horizontalSpace, DEFAULT_SPACE);
        mItemVerticalSpace = ta.getDimension(R.styleable.TextFlowLayoutStyle_verticalSpace, DEFAULT_SPACE);
        ta.recycle();
    }

    private List<List<View>> lines = new ArrayList<>();

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        mSelfWidth = MeasureSpec.getSize(widthMeasureSpec) - getPaddingLeft() - getRight();
        if (getChildCount() == 0) {
//            Log.e("sxd", "没有孩子");
            setMeasuredDimension(0, 0);;
            return;
        }

        List<View> line = null;
        lines.clear();
        // 为什么显示键盘的时候getRight()返回结果等于MeasureSpec.getSize(widthMeasureSpec) 导致控件无法显示
        mSelfWidth = MeasureSpec.getSize(widthMeasureSpec); //  - getPaddingLeft() - getRight()
        int childCount = getChildCount();
        for (int i = 0; i < childCount; ++i) {
            View itemView = getChildAt(i);
            if (itemView.getVisibility() == GONE)
                continue;
            measureChild(itemView,widthMeasureSpec,heightMeasureSpec);
            if (line == null)
                line = createNewLine(itemView);
            else {
                //判断是否可以再继续添加
                if(canBeAdd(itemView,line)) {
                    //可以添加，添加去
                    line.add(itemView);
                } else {
                    //新创建一行
                    line = createNewLine(itemView);
                }
            }
        }
        mItemHeight = getChildAt(0).getMeasuredHeight();
        int selfHeight = (int) (lines.size() * mItemHeight + mItemVerticalSpace * (lines.size() + 1));

        //测量自己
        setMeasuredDimension(mSelfWidth,selfHeight);
//        Log.e("sxd", "TextFlowLayout onMeasure " + mSelfWidth + "," + selfHeight);

    }

    private List<View> createNewLine(View itemView) {
        List<View> line = new ArrayList<>();
        line.add(itemView);
        lines.add(line);
        return line;
    }

    private boolean canBeAdd(View itemView,List<View> line) {
        //所有已经添加的子view宽度相加+(line.size()+1)*mItemHorizontalSpace + itemView.getMeasuredWidth()
        //条件：如果小于/等于当前控件的宽度，则可以添加，否则不能添加
        int totalWith = itemView.getMeasuredWidth();
        for(View view : line) {
            //叠加所有已经添加控件的宽度
            totalWith += view.getMeasuredWidth();
        }
        //水平间距的宽度
        totalWith += mItemHorizontalSpace * (line.size() + 1);
        //LogUtils.d(this,"totalWith -- > " + totalWith);
        //LogUtils.d(this,"mSelfWidth -- > " + mSelfWidth);
        //如果小于/等于当前控件的宽度，则可以添加，否则不能添加
        return totalWith <= mSelfWidth;
    }



    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int topOffset = (int) mItemHorizontalSpace;
        for(List<View> views : lines) {
            //views是每一行
            int leftOffset = (int) mItemHorizontalSpace;
            for(View view : views) {
                //每一行里的每个item
                view.layout(leftOffset,topOffset,leftOffset + view.getMeasuredWidth(),topOffset + view.getMeasuredHeight());
                //
                leftOffset += view.getMeasuredWidth() + mItemHorizontalSpace;
            }
            topOffset += mItemHeight + mItemHorizontalSpace;
        }

    }

    public void setTextList(List<String> textList) {
        // 这里必须要先清空之前的所有view
        // 不然 之前的view还会存在
        removeAllViews();
        if (textList != null) {
            invalidate();
            mTextList = textList;
            for (String s : textList) {
                TextView view = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.flow_text_view, this, false);
                view.setText(s);

                view.setTextColor(Color.BLACK);
                view.setBackground(getResources().getDrawable(R.drawable.shape_flow_text_bg));
                // 添加点击事件
                view.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (itemClickListener != null)
                            itemClickListener.onClick(s);
                    }
                });
                addView(view);
            }
        }
    }

    public interface ItemClickListener {
        void onClick(String key);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
