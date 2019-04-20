# kotlin AsyncTask

```

private fun getBackgroundImage(str:String){
        Thread(Runnable {
            DownImgAsyncTask().execute(str)
        }).start()
    }
    

inner class DownImgAsyncTask: AsyncTask<String, Void, Bitmap>() {
        override fun doInBackground(vararg params: String?): Bitmap {
            return ImageUtil.getImageBitmap(params[0])
        }
        override fun onPostExecute(result: Bitmap?) {
            super.onPostExecute(result)
            if(result!=null){
                luoFuMain!!.background=bitmap2Drawable(result)
            }
        }
         private fun  bitmap2Drawable(bitmap:Bitmap): Drawable {
             return BitmapDrawable(this@MainActivity.resources,bitmap)
        }
    }
    
    
/**
     *
     * 图片加载
     * @param url
     * @return
     */
    public static Bitmap getImageBitmap(String url) {
        URL imgUrl = null;
        Bitmap bitmap = null;
        try {
            imgUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) imgUrl
                    .openConnection();
            conn.setDoInput(true);
            conn.connect();
            InputStream is = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

```

