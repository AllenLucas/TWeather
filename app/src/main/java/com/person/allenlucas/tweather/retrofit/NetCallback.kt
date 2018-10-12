package com.person.allenlucas.tweather.retrofit

import io.reactivex.observers.DisposableObserver
import retrofit2.HttpException

abstract class NetCallback<M> : DisposableObserver<M>() {
    private val SIGNAL_BAD = 504
    private val SERVER_ERROR_1 = 504
    private val SERVER_ERROR_2 = 404
    private val SIGNAL_BAD_MESSAGE = "网络不给力"
    private val SERVER_ERROR_MESSAGE = "服务器异常，请稍后再试"
    abstract fun onSuccess(model: M)
    abstract fun onFailure(msg: String)
    abstract fun onFinish()

    override fun onError(e: Throwable?) {
        e?.printStackTrace()
        if (e is HttpException){
            val code = e.code()
            var msg = e.message()
            if (SIGNAL_BAD == code){
                msg = SIGNAL_BAD_MESSAGE
            }
            if (SERVER_ERROR_1 == code || SERVER_ERROR_2 == code){
                msg = SERVER_ERROR_MESSAGE
            }
            onFailure(msg)
        }else{
            onFailure(e?.message.toString())
        }
        onFinish()
    }

    override fun onNext(value: M) {
        onSuccess(value)
    }

    override fun onComplete() {
        onFinish()
    }
}