package com.cdc.okhttp.httputils.okhttp2;
import java.util.Map;
import java.util.Set;

public class HttpUtil{
    /**
     * 将Map集合转到Param数组中
     * @param params
     * @return
     */
    public Param[] mapToParams(Map<String, String> params) {
        if (params == null)
            return new Param[0];
        int size = params.size();
        Param[] res = new Param[size];
        Set<Map.Entry<String, String>> entries = params.entrySet();
        int i = 0;
        for (Map.Entry<String, String> entry : entries) {
            res[i++] = new Param(entry.getKey(), entry.getValue());
        }
        return res;
    }

}
