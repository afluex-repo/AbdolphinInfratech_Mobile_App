package com.abdolphininfratech.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import com.abdolphininfratech.R;


public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.create_new) {
            Toast.makeText(this, "Create New clicked", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.open) {
            Toast.makeText(this, "Open clicked", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.create_new2) {
            Toast.makeText(this, "Create New 2 clicked", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.open2) {
            Toast.makeText(this, "Open 2 clicked", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
