package com.hanaa.logintask.presentation.navigation;

import android.content.Context;
import android.content.Intent;

import com.hanaa.logintask.presentation.activity.LoginActivity;
import com.hanaa.logintask.presentation.activity.MainActivity;

public class NavigationManagement {

    public static class NavigationIntent {
        public static Intent getLoginIntent(Context context) {
            return LoginActivity.getStartIntent(context);
        }
        public static Intent getMainIntent(Context context,String name) {
            return MainActivity.getStartIntent(context,name);
        }
    }

    public static class Navigator {
        public static void goToLoginActivity(Context context) {
            context.startActivity(NavigationIntent.getLoginIntent(context));
        }
        public static void goToMAinActivity(Context context,String name) {
            context.startActivity(NavigationIntent.getMainIntent(context,name));
        }

    }
}
