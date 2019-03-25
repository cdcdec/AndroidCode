# 键盘上反引号与data class命名冲突

Android 实体类中命名与关键字冲突（java&kotlin）解决方法
1. java中的解决方法是在变量名上增加注解，指定序列化时的变量名称
```
public class DataBean {
        private String appid;
        private String noncestr;
        private String order_code;
        @SerializedName("package")
        private String packageX;
        private String partnerid;
        private String prepayid;
        private String sign;
        private int timestamp;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getNoncestr() {
            return noncestr;
        }

        public void setNoncestr(String noncestr) {
            this.noncestr = noncestr;
        }

        public String getOrder_code() {
            return order_code;
        }

        public void setOrder_code(String order_code) {
            this.order_code = order_code;
        }

        public String getPackageX() {
            return packageX;
        }

        public void setPackageX(String packageX) {
            this.packageX = packageX;
        }

        public String getPartnerid() {
            return partnerid;
        }

        public void setPartnerid(String partnerid) {
            this.partnerid = partnerid;
        }

        public String getPrepayid() {
            return prepayid;
        }

        public void setPrepayid(String prepayid) {
            this.prepayid = prepayid;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }
    }


```
2. Kotlin中的解决方法,只需要在变量名加上反引号’ '即可
```
data class LoveValueRecordBean(
        var id:String,
        var user_id:String,
        var order_id:String,
        var `val`:String,
        var title:String,
        var time:String,
        var num:String
)
```
3. 反引号
键盘上的反引号在esc键的下面，在数字键1的左边。一般计算机行业的才会用到反引号。
```
这是反引号 `a`
这是单引号 ‘a'

```

