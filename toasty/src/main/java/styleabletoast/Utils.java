package styleabletoast;

import android.content.Context;
import androidx.core.text.TextUtilsCompat;
import androidx.core.view.ViewCompat;
import android.util.TypedValue;

import java.util.Locale;



/**
 * Created by Muddz on 07-03-2018.
 */

class Utils {

    static int toDp(Context context, int value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.getResources().getDisplayMetrics());
    }

    static boolean isRTL() {
        return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == ViewCompat.LAYOUT_DIRECTION_RTL;
    }

}
