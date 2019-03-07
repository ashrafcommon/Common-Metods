package m.app.methodshelper;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class AllFunctions {
    private static Context context;

    public static void initialize(Context context) {
        AllFunctions.context = context.getApplicationContext();
    }

    /*
     * Color must be in hexadecimal format
     * Works only above lollipop
     * */
    public static void changeStatusBarColor(Activity activity, String color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor(color));
        }
    }

    public static void showMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void showMessage(String msg, int length) {
        Toast.makeText(context, msg, length).show();
    }

    private static Context getContext() {
        return AllFunctions.context;
    }

    public static float dpFromPx(final float px) {
        return px / getContext().getResources().getDisplayMetrics().density;
    }

    public static float pxFromDp(final float dp) {
        return dp * getContext().getResources().getDisplayMetrics().density;
    }

    static public String firstLetterCaps(String data) {
        if (data.length() == 0) {
            return data;
        } else {
            data = Character.toUpperCase(data.charAt(0)) + data.substring(1);
        }
        return data;
    }
}
