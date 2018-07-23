package cdac.lrhs.com.splash_screen;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class CampusRegistration extends Fragment
{

    TextInputEditText editName,editContact,editDepartment,editState,editGstin,editGuideName,editEmailId,editGuideEmailId,editPassword,editRepassword;
    Button btnAdd;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.campus_layout,container,false);
        editName=view.findViewById(R.id.CampusName);
        editContact=view.findViewById(R.id.CampusContact);
        editDepartment=view.findViewById(R.id.CampusDepatmentName);
        editState=view.findViewById(R.id.CampusState);
        editGstin=view.findViewById(R.id.CampusGstin);
        editGuideName=view.findViewById(R.id.CampusGuideName);
        editEmailId=view.findViewById(R.id.CampusEmailId);
        editGuideEmailId=view.findViewById(R.id.CampusGuideEmail);
        editPassword=view.findViewById(R.id.CampusPassword);
        editRepassword=view.findViewById(R.id.CampusRePassword);
        btnAdd=view.findViewById(R.id.btnLogin);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundTask btask;
                btask = new BackgroundTask(getActivity());
                Log.d("contactin1",editContact.getText().toString());
                btask.execute("register",editName.getText().toString(), editContact.getText().toString(), "SPPU Campus",
                        editDepartment.getText().toString(), editEmailId.getText().toString(), editGuideName.getText().toString(),
                        editGuideEmailId.getText().toString(),"NA","27",editPassword.getText().toString(),"1","SPPU");


            }
        });
        return view;

    }


}
