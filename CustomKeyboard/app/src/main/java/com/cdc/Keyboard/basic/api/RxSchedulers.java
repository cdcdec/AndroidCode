package com.cdc.keyboard.basic.api;


import io.reactivex.*;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public class RxSchedulers{
    public static <T> ObservableTransformer<T, T> compose(BasePresenter basePresenter) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                Observable observable = upstream.subscribeOn(Schedulers.io()).doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        basePresenter.add(disposable);
                    }
                }).observeOn(AndroidSchedulers.mainThread());
                return observable;
            }
        };
    }


    public static <T> ObservableTransformer<T, T> compose() {

        return new ObservableTransformer<T, T>() {

            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                Observable observable = upstream.subscribeOn(Schedulers.io()).doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) {

                    }
                }).observeOn(AndroidSchedulers.mainThread());
                return observable;
            }
        };
    }

    public static <T> FlowableTransformer<T, T> transform(BasePresenter basePresenter) {
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(Flowable<T> upstream) {
                Flowable flowable=upstream.subscribeOn(Schedulers.io()).doOnSubscribe(new Consumer<Subscription>() {
                    @Override
                    public void accept(Subscription subscription) throws Exception {
                        basePresenter.add(subscription);
                    }
                }).observeOn(AndroidSchedulers.mainThread());
                return flowable;
            }
        };
    }

    public static <T> FlowableTransformer<T, T> transform() {
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(Flowable<T> upstream) {
                Flowable flowable=upstream.subscribeOn(Schedulers.io()).doOnSubscribe(new Consumer<Subscription>() {
                    @Override
                    public void accept(Subscription subscription) throws Exception {

                    }
                }).observeOn(AndroidSchedulers.mainThread());
                return flowable;
            }
        };
    }
}
