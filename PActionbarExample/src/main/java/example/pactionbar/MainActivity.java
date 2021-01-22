package example.pactionbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.dpouya.pactionbar.Model.PActionbarButton;
import com.dpouya.pactionbar.Ui.PActionbar;
import com.dpouya.pactionbar.helper.LayoutUtilities;

public class MainActivity extends AppCompatActivity {

    private PActionbar pActionbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout frameLayout=new FrameLayout(this);
        pActionbar=new PActionbar(this);
        pActionbar.setBackgroundColor(0xff0d47a1);

        pActionbar.showDrawerMenuicon(true);
        pActionbar.setOnIconClick(v -> Toast.makeText(MainActivity.this,"Menu Button",Toast.LENGTH_SHORT).show());
        pActionbar.setTitle("PActionbar");

        pActionbar.addButton(new PActionbarButton("btn", null, v -> Toast.makeText(MainActivity.this,"Toast1 Button",Toast.LENGTH_SHORT).show()));

        pActionbar.addButton(new PActionbarButton(null, getResources().getDrawable(R.drawable.ic_search), v -> Toast.makeText(MainActivity.this,"Toast2 Button",Toast.LENGTH_SHORT).show()));

        frameLayout.addView(pActionbar, LayoutUtilities.createFrame(LayoutUtilities.MATCH_PARENT,LayoutUtilities.WRAP_CONTENT, Gravity.TOP));


        Button btnCenterText = new Button(this);
        btnCenterText.setText("Center Text Actionbar");
        btnCenterText.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,CenterActionbarTextActivity.class)));
        frameLayout.addView(btnCenterText, LayoutUtilities.createFrame(LayoutUtilities.MATCH_PARENT,60, Gravity.TOP,10,100,10,0));

        Button btnactionbartabs = new Button(this);
        btnactionbartabs.setText("Actionbar Tabs");
        btnactionbartabs.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,TabActionbarActivity.class)));
        frameLayout.addView(btnactionbartabs, LayoutUtilities.createFrame(LayoutUtilities.MATCH_PARENT,60, Gravity.TOP,10,160,10,0));

        Button btnactionbarsubtitle = new Button(this);
        btnactionbarsubtitle.setText("Actionbar Subtitle");
        btnactionbarsubtitle.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,SubtitleActionbarActivity.class)));
        frameLayout.addView(btnactionbarsubtitle, LayoutUtilities.createFrame(LayoutUtilities.MATCH_PARENT,60, Gravity.TOP,10,220,10,0));

        Button btnactionbarsearch = new Button(this);
        btnactionbarsearch.setText("Actionbar Search");
        btnactionbarsearch.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,SearchActionbarActivity.class)));
        frameLayout.addView(btnactionbarsearch, LayoutUtilities.createFrame(LayoutUtilities.MATCH_PARENT,60, Gravity.TOP,10,280,10,0));

        setContentView(frameLayout);
    }
}