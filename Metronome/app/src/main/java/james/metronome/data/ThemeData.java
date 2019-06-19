package james.metronome.data;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import james.metronome.utils.ColorUtils;

public class ThemeData {

    private int nameRes;
    private int colorPrimaryRes;
    private int colorAccentRes;
    private int colorBackgroundRes;

    public ThemeData(@StringRes int nameRes, @ColorRes int colorPrimaryRes, @ColorRes int colorAccentRes, @ColorRes int colorBackgroundRes) {
        this.nameRes = nameRes;
        this.colorPrimaryRes = colorPrimaryRes;
        this.colorAccentRes = colorAccentRes;
        this.colorBackgroundRes = colorBackgroundRes;
    }

    public String getName(Context context) {
        return context.getString(nameRes);
    }

    public void apply(Context context) {
        int backgroundColor = ContextCompat.getColor(context, colorBackgroundRes);
        boolean isBackgroundDark = ColorUtils.isColorDark(backgroundColor);


    }

}
