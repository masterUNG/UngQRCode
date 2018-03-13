package masterung.androidthai.in.th.ungqrcode;

import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import masterung.androidthai.in.th.ungqrcode.fragment.DisplayQRfragment;
import masterung.androidthai.in.th.ungqrcode.fragment.QRscanFragment;
import masterung.androidthai.in.th.ungqrcode.fragment.ShowAllFragment;

public class ServiceActivity extends AppCompatActivity {

    //    Explicit
    private String tag = "12MarchV1";
    private String[] loginStrings;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private boolean aBoolean = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

//        Get Value From Intent
        getValueFromIntent();

//        Create Toolbar
        createToolbar();

//        Add Fragment to Activity
        addFragment(savedInstanceState);

//        Show ReadAll
        showReadAll();

//        QR Scan
        qrController();

//        Extit Contrller
        exitController();



    }   // Main Method

    @Override
    public void onBackPressed() {

    }

    private void showReadAll() {
        TextView textView = findViewById(R.id.txtShowAll);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentServiceFragment, new ShowAllFragment())
                        .commit();
                drawerLayout.closeDrawers();

            }
        });

    }

    private void qrController() {
        TextView textView = findViewById(R.id.txtQRscan);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentServiceFragment, QRscanFragment.qRscanInstance(loginStrings))
                        .commit();
                drawerLayout.closeDrawers();

            }
        });

    }

    private void exitController() {
        TextView textView = findViewById(R.id.txtExit);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void addFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {

            if (aBoolean) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.contentServiceFragment, new ShowAllFragment())
                        .commit();
            } else {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.contentServiceFragment,
                                DisplayQRfragment.displayQRInstance(getIntent().getStringExtra("QRcode"), loginStrings))
                        .commit();
            }

        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        actionBarDrawerToggle.onConfigurationChanged(newConfig);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        actionBarDrawerToggle.syncState();

    }

    private void createToolbar() {

        Toolbar toolbar = findViewById(R.id.toolbarService);
        setSupportActionBar(toolbar);

//        Setup Title
        getSupportActionBar().setTitle("My Service");
        getSupportActionBar().setSubtitle(loginStrings[1]);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        Create Hamberger Icon
        drawerLayout = findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(ServiceActivity.this,
                drawerLayout, R.string.open, R.string.close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

    }

    private void getValueFromIntent() {
        loginStrings = getIntent().getStringArrayExtra("Login");
        aBoolean = getIntent().getBooleanExtra("Status", true);
        Log.d(tag, "NameLogin ==> " + loginStrings[1]);
    }


}   // Main Class
