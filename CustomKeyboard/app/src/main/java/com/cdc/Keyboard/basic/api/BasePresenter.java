package com.cdc.keyboard.basic.api;

import com.cdc.keyboard.basic.BaseActivity;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscription;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public  class BasePresenter<V extends BaseView> implements IPresenter<V> {
    private ApiService apiService = Api.getInstance().getApiService();
    private CompositeDisposable apiManager = null;
    private ArrayList<Subscription> apiArrayList = new ArrayList<Subscription>();
    protected V mView;
    private WeakReference<V> mViewRef;
    private BaseActivity mContext;

    protected void add(Disposable subscription) {
        if (apiManager == null || apiManager.isDisposed()) {
            apiManager = new CompositeDisposable();
        }
        apiManager.add(subscription);
    }

    protected void add(Subscription subscription){
        apiArrayList.add(subscription);
    }

    public void attachView(Object v) {
        mView = (V) v;
        mViewRef = new WeakReference<V>(mView);
    }

    protected V getView() {
        return mViewRef.get();
    }

    public void setContext(BaseActivity activity) {
        mContext = activity;
    }

    public Boolean isViewAttached() {
        return mViewRef.get() != null;
    }

     public void  detachView() {
        cancel();
        mViewRef.clear();
    }

    private void cancel() {
        if(apiManager!=null){
            apiManager.clear();
        }
        for (Subscription in:apiArrayList) {
            in.cancel();
        }
    }


}
