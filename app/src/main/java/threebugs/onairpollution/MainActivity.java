package threebugs.onairpollution;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    Spinner selectCity;
    Button btnGoToContribution;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("main");
        databaseReference.setValue("Hello");

        btnGoToContribution = findViewById(R.id.btnContribution);

        btnGoToContribution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,YourContribution.class));
            }
        });

        selectCity = findViewById(R.id.select_city);

        List<String> cities = new ArrayList<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Pune");
        cities.add("Bengalore");

        ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,cities);
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectCity.setAdapter(cityAdapter);
    }
}
