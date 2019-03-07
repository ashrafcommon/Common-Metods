package m.app.methodshelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class Helper {
    private static Context context;

    public static void initialize(Context context) {
        Helper.context = context.getApplicationContext();
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

    /*
    * Display a message using Toast
    * */
    public static void showMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    /*
     * Display a message using Toast, also need the Toast duration
     * */
    public static void showMessage(String msg, int length) {
        Toast.makeText(context, msg, length).show();
    }


    private static Context getContext() {
        return Helper.context;
    }

    /*
    * This methods convert px to dp
    * */
    public static float pxToDp(final float px) {
        return px / getContext().getResources().getDisplayMetrics().density;
    }

    /*
    * This method convert dp to px
    * */
    public static float dpToPx(final float dp) {
        return dp * getContext().getResources().getDisplayMetrics().density;
    }

    /*
    * Changes the first letter to caps of any String
    * */
    static public String firstLetterCaps(String data) {
        if (data.length() == 0) {
            return data;
        } else {
            data = Character.toUpperCase(data.charAt(0)) + data.substring(1);
        }
        return data;
    }

    /*
    * Validate the email, it only validate the format.
    * */
    public static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    /*
    * Validate the name, assuming that name only contain A-Z, a-z and dot
    * */
    public static boolean isValidName(String name) {
        return !TextUtils.isEmpty(name) &&name.matches("[a-zA-Z .]+");
    }

    /*
    * Hide the soft keyboard if open
    * */
    public static void hideSoftKeyboard(Activity activity) {
        if (activity == null) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (activity.getCurrentFocus() != null)
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    /*
    * Show the soft keyboard if hidden
    * */
    public static void hideSoftKeyboard(Activity activity, View view) {
        if (activity == null) {
            return;
        }
        if(view == null)
            return;
        try {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch (Exception e) {
            //do nothing
        }

    }

    /*
    * Open dialer with a number
    * */
    public static void openDialer(String number) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + number));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getContext().startActivity(intent);
    }

    /*
    * Open the settings of an app
    * */
    public static void openAppSettings() {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromParts("package", getContext().getPackageName(), null);
        intent.setData(uri);
        getContext().startActivity(intent);
    }
}
