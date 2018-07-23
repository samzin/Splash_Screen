package cdac.lrhs.com.splash_screen;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class CollegeRegistration extends Fragment
{
    TextInputEditText editCollegeName,editCollegeContact,editCollegeDepartment,editCollegeAddress,editCollegeState,editCollegeGstin,
            editCollegeGuideName,editCollegeEmailId,editCollegeGuideEmailId,
            editCollegePassword,editCollegeRepassword,editCollege;
    Button btnLogin;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.college_layout,container,false);

        editCollegeName=view.findViewById(R.id.CollegeName);
        editCollegeContact=view.findViewById(R.id.CollegeContact);
        editCollegeDepartment=view.findViewById(R.id.CollegeDepartment);
        editCollegeAddress=view.findViewById(R.id.CollegeAddress);
        editCollegeState=view.findViewById(R.id.CollegeState);
        editCollegeGstin=view.findViewById(R.id.CollegeGstin);
        editCollegeGuideName=view.findViewById(R.id.CollegeGuideName);
        editCollegeEmailId=view.findViewById(R.id.CollegeEmailId);
        editCollegeGuideEmailId=view.findViewById(R.id.CollegeGuideEmailId);
        editCollegePassword=view.findViewById(R.id.CollegePassword);
        editCollegeRepassword=view.findViewById(R.id.CollegeRePassword);
        editCollege=view.findViewById(R.id.txtcollegename);
        btnLogin=view.findViewById(R.id.btnCollege_Login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundTask btask=new BackgroundTask(getActivity());
                btask.execute("register",editCollegeName.getText().toString(),
                        editCollegeContact.getText().toString(),
                        editCollegeAddress.getText().toString(),
                        editCollegeDepartment.getText().toString(),
                        editCollegeEmailId.getText().toString(),
                        editCollegeGuideName.getText().toString(),
                        editCollegeGuideEmailId.getText().toString()
                        ,editCollegeGstin.getText().toString()
                        ,"27",editCollegePassword.getText().toString(),"2",
                        editCollege.getText().toString());

                Toast.makeText(getActivity(), "Entered !!!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;

    }
}
