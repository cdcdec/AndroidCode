package com.cdc.keyboard.basic.api;

public interface IPresenter<V>{
   void  attachView(Object view);
   void detachView();
}
