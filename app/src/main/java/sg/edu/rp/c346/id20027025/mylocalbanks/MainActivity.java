package sg.edu.rp.c346.id20027025.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView title;
    Button dbs;
    Button ocbc;
    Button uob;
    TextView info;

    String bankType = "";
    String url = "";
    String number = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title);
        dbs = findViewById(R.id.dbs);
        ocbc = findViewById(R.id.ocbc);
        uob = findViewById(R.id.uob);
        info = findViewById(R.id.info);

        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);
    }

    //language
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_2, menu);
        return true;
    }

    //directory
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_1, menu);

        if (v == dbs) {
            bankType = "DBS";
        } else if (v == ocbc) {
            bankType = "OCBC";
        } else if (v == uob) {
            bankType = "UOB";
        } else {
            bankType = "";
        }
    }

    //directory
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (bankType.equalsIgnoreCase("DBS")) {
            url = "https://www.dbs.com.sg";
            number = "18001111111";

        } else if (bankType.equalsIgnoreCase("OCBC")) {
            url = "https://www.ocbc.com";
            number = "18003633333";

        } else if (bankType.equalsIgnoreCase("UOB")) {
            url = "https://www.uob.com.sg";
            number = "18002222121";

        } else {
            url = "";
            number = "";
        }

        if (id == R.id.website) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        } else if (id == R.id.bankCall) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(number));
            startActivity(intent);
        }

        if (id == R.id.toggleFav) {
            if (bankType.equalsIgnoreCase("DBS")) {
                dbs.setTextColor(Color.RED);
            }
            if (bankType.equalsIgnoreCase("OCBC")) {
                dbs.setTextColor(Color.RED);
            }
            if (bankType.equalsIgnoreCase("UOB")) {
                dbs.setTextColor(Color.RED);
            }
        } else if (id == R.id.toggleUnFav) {
            if (bankType.equalsIgnoreCase("DBS")) {
                dbs.setTextColor(Color.WHITE);
            }
            if (bankType.equalsIgnoreCase("OCBC")) {
                dbs.setTextColor(Color.WHITE);
            }
            if (bankType.equalsIgnoreCase("UOB")) {
                dbs.setTextColor(Color.WHITE);
            }
        }
        return super.onContextItemSelected(item);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.english) {
            dbs.setText(getString(R.string.dbs_english));
            ocbc.setText(getString(R.string.ocbc_english));
            uob.setText(getString(R.string.uob_english));
            title.setText(getString(R.string.title_english));
            info.setText(getString(R.string.info_english));

            Toast.makeText(MainActivity.this, "English Selected", Toast.LENGTH_SHORT).show();

            return true;
        } else if ((id == R.id.chinese)) {
            dbs.setText(getString(R.string.dbs_chinese));
            ocbc.setText(getString(R.string.ocbc_chinese));
            uob.setText(getString(R.string.uob_chinese));
            title.setText(getString(R.string.title_chinese));
            info.setText(getString(R.string.info_chinese));

            Toast.makeText(MainActivity.this, "中文选中", Toast.LENGTH_SHORT).show();

            return true;
        } else {
            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}



