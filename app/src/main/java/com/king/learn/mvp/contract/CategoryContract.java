package com.king.learn.mvp.contract;

import com.jess.arms.base.DefaultAdapter;
import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;
import com.king.learn.mvp.model.entity.GankEntity;

import io.reactivex.Observable;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/9/20 17:55.
 */

public interface CategoryContract
{
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView
    {
        void startLoadMore();
        void endLoadMore();
        void setAdapter(DefaultAdapter mAdapter);
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel
    {
        Observable<GankEntity> gank(String type, String page);
    }
}
