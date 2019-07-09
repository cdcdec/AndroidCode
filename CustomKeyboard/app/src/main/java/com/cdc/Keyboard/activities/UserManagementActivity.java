package com.cdc.keyboard.activities;
import android.os.Bundle;
import com.cdc.keyboard.R;
import com.cdc.keyboard.basic.RootActivity;

public class UserManagementActivity extends RootActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentViewSetCustomTitle(R.layout.activity_user_management);
        setTitleTextView("员工管理");
        setTitleTextViewRight("保存");



    }
}
