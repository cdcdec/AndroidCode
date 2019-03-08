package com.cdc.androidcode.ui.toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import com.cdc.androidcode.R;
import java.util.ArrayList;

public class Toolbar2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_2);
        Toolbar toolbar1=findViewById(R.id.tb_toolbar1);
        setSupportActionBar(toolbar1);

        toolbar1.setNavigationOnClickListener((view)->{
            Toast.makeText(Toolbar2Activity.this, "Nav2", Toast.LENGTH_SHORT).show();
        });

        View logoView = getToolbarLogoIcon(toolbar1);

        logoView.setOnClickListener((view)->{
            Toast.makeText(Toolbar2Activity.this, "logoView", Toast.LENGTH_SHORT).show();
        });

        TextView tvCustomTitle=toolbar1.findViewById(R.id.customTitle);

        tvCustomTitle.setOnClickListener((view)->{
            Toast.makeText(Toolbar2Activity.this, "tvCustomTitle", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //调用toolbar1.setNavigationOnClickListener()时此方法不调用
            case android.R.id.home:
               Toast.makeText(Toolbar2Activity.this, "Nav1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_music:
                Toast.makeText(this,"action_music",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_password:
                Toast.makeText(this,"action_password",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_item1:
                Toast.makeText(this,"action_item1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_item2:
                Toast.makeText(this,"action_item2",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //获取ToolBar中的logo
    public  View getToolbarLogoIcon(Toolbar toolbar){
        //check if contentDescription previously was set
        boolean hadContentDescription = android.text.TextUtils.isEmpty(toolbar.getLogoDescription());
        String contentDescription = String.valueOf(!hadContentDescription ? toolbar.getLogoDescription() : "logoContentDescription");
        toolbar.setLogoDescription(contentDescription);
        ArrayList<View> potentialViews = new ArrayList<View>();
        //find the view based on it's content description, set programatically or with android:contentDescription
        toolbar.findViewsWithText(potentialViews,contentDescription, View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION);
        //Nav icon is always instantiated at this point because calling setLogoDescription ensures its existence
        View logoIcon = null;
        if(potentialViews.size() > 0){
            logoIcon = potentialViews.get(0);
        }
        //Clear content description if not previously present
        if(hadContentDescription)
            toolbar.setLogoDescription(null);
        return logoIcon;
    }
}
