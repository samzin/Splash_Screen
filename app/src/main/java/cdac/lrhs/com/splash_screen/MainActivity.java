package cdac.lrhs.com.splash_screen;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    CampusRegistration campus;
    CollegeRegistration college;
    OtherUnivercity other;
    GovernmentUnivercity government;
    Industries industries;
    Spinner spinner;
    Button btnSave;
    String[] names = {"Campus", "Colleges", "Govt.", "Industry", "Other University"};
    String uname, ucontact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinnerUser);
        btnSave = findViewById(R.id.btnLogin);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1, names);

        spinner.setAdapter(adapter);
        //spinner on item select listner ...............................................................
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (spinner.getSelectedItem().toString()) {
                    case "Campus":
                        campus = new CampusRegistration();
                        loadFragment(campus, R.id.FrameLayout1);
                        break;
                    case "Colleges":

                        college = new CollegeRegistration();
                        loadFragment(college, R.id.FrameLayout1);
                        break;
                    case "Govt.":
                        government = new GovernmentUnivercity();
                        loadFragment(government, R.id.FrameLayout1);
                        break;
                    case "Other University":
                        other = new OtherUnivercity();
                        loadFragment(other, R.id.FrameLayout1);
                        break;
                    case "Industry":
                        industries = new Industries();
                        loadFragment(industries, R.id.FrameLayout1);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        }); // spinner item click slistner end ......................................................



    }

    private void loadFragment(Fragment fragment, int id) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }


}
