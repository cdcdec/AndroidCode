package com.cdc.androidcode.ui.toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import com.cdc.androidcode.R;

public class ToolbarMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_main);

        Toolbar toolbar1=findViewById(R.id.tb_toolbar1);

        Toolbar toolbar3=findViewById(R.id.tb_toolbar3);
        //设置右上角的填充菜单
        toolbar1.inflateMenu(R.menu.toolbar_menu1);
        toolbar3.inflateMenu(R.menu.toolbar_menu1);
        toolbar1.setOnMenuItemClickListener(item -> {
            int menuItemId = item.getItemId();
            if (menuItemId == R.id.action_music) {
                Toast.makeText(ToolbarMainActivity.this , "menu_search", Toast.LENGTH_SHORT).show();

            } else if (menuItemId == R.id.action_password) {
                Toast.makeText(ToolbarMainActivity.this ,"menu_notifications", Toast.LENGTH_SHORT).show();

            } else if (menuItemId == R.id.action_item1) {
                Toast.makeText(ToolbarMainActivity.this , "item_01", Toast.LENGTH_SHORT).show();

            } else if (menuItemId == R.id.action_item2) {
                Toast.makeText(ToolbarMainActivity.this , "item_02", Toast.LENGTH_SHORT).show();

            }
            return true;
        });


        TitleToolBar titleToolBar=findViewById(R.id.tb_toolbar6);
        titleToolBar.setOnOptionItemClickListener((view)->{
            switch (view.getId()) {
                case R.id.back:
                    finish();
                    break;
                case R.id.close:
                    Toast.makeText(this, "关闭", Toast.LENGTH_SHORT).show();
                    break;
            }
        });

        setSupportActionBar(titleToolBar);
         ActionBar mActionBar=getSupportActionBar();
        mActionBar.setDisplayOptions(mActionBar.getDisplayOptions() | ActionBar.DISPLAY_HOME_AS_UP);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.menu_add:
                supportInvalidateOptionsMenu();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
