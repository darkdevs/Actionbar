package example.pactionbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.dpouya.pactionbar.Model.PActionbarButton;
import com.dpouya.pactionbar.Ui.PActionbar;
import com.dpouya.pactionbar.helper.LayoutUtilities;

public class SearchActionbarActivity extends AppCompatActivity {

    private PActionbar pActionbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout frameLayout=new FrameLayout(this);
        pActionbar=new PActionbar(this);
        pActionbar.setBackgroundColor(0xff0d47a1);

        pActionbar.showBackButton(true);
        pActionbar.setOnIconClick(v -> finish());

        pActionbar.setSearchmode(true);
        pActionbar.setSearchhint("Search For Anything...");
        pActionbar.getSearchIcon().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Searching: " + pActionbar.getTxtSearch().getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        frameLayout.addView(pActionbar, LayoutUtilities.createFrame(LayoutUtilities.MATCH_PARENT,LayoutUtilities.WRAP_CONTENT, Gravity.TOP));
        setContentView(frameLayout);
    }
}