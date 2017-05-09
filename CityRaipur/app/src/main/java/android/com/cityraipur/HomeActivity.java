package android.com.cityraipur;

import android.com.cityraipur.adapter.HomeActivityAdapter;
import android.com.cityraipur.modal.HomeActivityModal;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    HomeActivityAdapter homeActivityAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        List<HomeActivityModal> list=new ArrayList<>();
        list.add(new HomeActivityModal("Interior Designing",R.drawable.inerior1));
        list.add(new HomeActivityModal("Buy And Sell",R.drawable.buy_and_sell1));
        list.add(new HomeActivityModal("Civil Contractors",R.drawable.civil_constructor1));
        list.add(new HomeActivityModal("Architect",R.drawable.architecture1));
        list.add(new HomeActivityModal("Civil Engineer",R.drawable.civil_engineering1));

       homeActivityAdapter=new HomeActivityAdapter(list,this);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
         recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(homeActivityAdapter);

        Toolbar mToolBar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.notification:
                Toast.makeText(this,R.id.notification+"wefew",Toast.LENGTH_SHORT).show();
             //   Intent intent=new Intent(this,WriteActivity.class);
               // startActivity(intent);
                return true;
            case R.id.search:
                Toast.makeText(this,R.id.search+"efef",Toast.LENGTH_SHORT).show();
                return  true;
            default:
                super.onOptionsItemSelected(item);
        }
        return true;
    }
}
