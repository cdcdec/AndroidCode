package com.laiqian.login.view;

import com.laiqian.basic.LQKVersion;
import com.laiqian.network.k;
import com.laiqian.pos.hardware.RootUrlParameter;
import io.reactivex.i;
import io.reactivex.j;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata
final class ay<T> extends Object implements j<T> {
  ay(ax paramax) {}
  
  public final void a(@NotNull i<String> parami) {
    f.m(parami, "it");
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("phone", this.ban.bal);
    jSONObject.put("password", this.ban.bam);
    jSONObject.put("industry", String.valueOf(LQKVersion.zj()));
    jSONObject.put("version", 1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(RootUrlParameter.cmB);
    stringBuilder.append("?laiqian_encrypt=");
    stringBuilder.append(URLEncoder.encode((new k()).k(jSONObject.toString(), 1), "utf-8"));
    parami.am(stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */