package com.king.learn.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.king.learn.R;
import com.king.learn.mvp.model.entity.DaoGankEntity;
import com.king.learn.mvp.ui.holder.BaseHolder;

import java.util.List;

/**
 * <收藏页面妹子福利>
 * Created by wwb on 2017/9/27 16:43.
 */

public class MeiziAdapter extends BaseQuickAdapter<DaoGankEntity,BaseHolder>
{
    public MeiziAdapter(@Nullable List<DaoGankEntity> data)
    {
        super(R.layout.item_collection_girls,data);
    }

    @Override
    protected void convert(BaseHolder helper, DaoGankEntity item)
    {
        ImageView view = helper.getView(R.id.network_imageview);
        Glide.with(helper.getContext())
                .load(item.url)
                .into(view);
    }
}
