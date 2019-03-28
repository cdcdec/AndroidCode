package com.cdc.androidcode.libraries.rxjava
import android.os.Bundle
import android.util.Log
import com.cdc.androidcode.BaseActivity
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import android.os.SystemClock
import android.view.View
import android.widget.Toast
import com.cdc.androidcode.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_rx_java_main.*
class RxJavaMainActivity : BaseActivity() {
    private val TAG:String = "RxJava"
    var disposables= CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("RxJava")
        setContentView(R.layout.activity_rx_java_main)
        initView()

        var ra=RxJava1()
        ra.test1()

        ra.test2()


    }

    private fun initView(){
        btnRxJava1.setOnClickListener(this)

    }

    private fun sampleObservable(): Observable<String> {
        return Observable.defer {
            // Do some long running operation
            SystemClock.sleep(5000)
            Observable.just("one", "two", "three", "four", "five")
        }
    }

    override fun onClick(view: View?) {
        super.onClick(view)
        when(view?.id){
            R.id.btnRxJava1->{
                Log.e(TAG, "onComplete()--click")
                Toast.makeText(this@RxJavaMainActivity,"点击了",Toast.LENGTH_SHORT).show()
                onRunSchedulerExampleButtonClicked()
            }
        }
    }

    private fun onRunSchedulerExampleButtonClicked(){
        disposables.add(sampleObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object:DisposableObserver<String>(){
                override fun onComplete() {
                    Log.e(TAG, "onComplete()")
                }

                override fun onNext(t: String) {
                    Log.e(TAG, "onNext($t)")
                    btnRxJava1.text=t
                }

                override fun onError(e: Throwable) {
                    Log.e(TAG, "onError()", e)
                }

            }))
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }

}
