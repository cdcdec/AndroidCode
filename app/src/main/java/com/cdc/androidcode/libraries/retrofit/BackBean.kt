package com.cdc.androidcode.libraries.retrofit

data class Content(var from:String,var to:String,var vendor:String,var out:String,var errNo:Int)
data class Translation(var status:Int,var content:Content)




data class YouDaoTranslateResultBean(var src:String,var tgt:String)
data class YouDaoTranslation(var type:String,var errorCode:Int,var elapsedTime:Int,var translateResult:List<List<YouDaoTranslateResultBean>>)

