package com.cdc.androidcode.ui.toolbar;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import com.cdc.androidcode.R;

public class ToolBar1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar1);

        Toolbar toolbar1=findViewById(R.id.tb_toolbar1);

        //设置右上角的填充菜单
        toolbar1.inflateMenu(R.menu.toolbar_menu1);
        toolbar1.setOnMenuItemClickListener(item -> {
            int menuItemId = item.getItemId();
            if (menuItemId == R.id.action_music) {
                Toast.makeText(ToolBar1Activity.this , "menu_search", Toast.LENGTH_SHORT).show();

            } else if (menuItemId == R.id.action_password) {
                Toast.makeText(ToolBar1Activity.this ,"menu_notifications", Toast.LENGTH_SHORT).show();

            } else if (menuItemId == R.id.action_item1) {
                Toast.makeText(ToolBar1Activity.this , "item_01", Toast.LENGTH_SHORT).show();

            } else if (menuItemId == R.id.action_item2) {
                Toast.makeText(ToolBar1Activity.this , "item_02", Toast.LENGTH_SHORT).show();

            }
            return true;
        });


    }
}
