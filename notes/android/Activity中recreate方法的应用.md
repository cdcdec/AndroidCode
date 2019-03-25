# Activity中recreate方法的应用

利用此方法可以实现样式的切换



1. Activity中方法的调用:onCreate-->onStart-->onResume
2. 调用Activity中recreate()方法后，将调用onSaveInstanceState-->onCreate-->onStart-->onRestoreInstanceState-->onResume





