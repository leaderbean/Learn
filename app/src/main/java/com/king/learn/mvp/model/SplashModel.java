package com.king.learn.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.king.learn.mvp.contract.SplashContract;

import javax.inject.Inject;

/**
 * <请描述这个类是干什么的>
 * Created by adou on 2017/9/21:22:19.
 *
 * @Email:634051075@qq.com
 */
@ActivityScope
public class SplashModel extends BaseModel implements SplashContract.Model
{
    private Gson mGson;
    private Application mApplication;

    @Inject
    public SplashModel(IRepositoryManager repositoryManager, Gson gson, Application application)
    {
        super(repositoryManager);
        this.mGson = gson;
        this.mApplication = application;
    }

    @Override
    public void getSplash(String deviceId)
    {

    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }
}
