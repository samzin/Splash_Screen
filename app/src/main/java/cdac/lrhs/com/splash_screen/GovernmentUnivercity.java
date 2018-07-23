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

public class GovernmentUnivercity extends Fragment
{
    TextInputEditText editGoverName,editGoverContact,editGoverInstituName,editGoverDepartmentName,editGoverState,
            editGoverGstin,editGoverGuideName,editGoverEmailId,editGoverGuideEmailId,
            editGoverPassword,editGoverRepassword,editGovAddress;
    Button btnGovSave;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.government_layout,container,false);

        editGoverName=view.findViewById(R.id.GovName);
        editGoverContact=view.findViewById(R.id.GovContact);
        editGoverInstituName=view.findViewById(R.id.GovInstituteName);
        editGoverDepartmentName=view.findViewById(R.id.GovDepartmentName);
        editGovAddress=view.findViewById(R.id.GovAddress);
        editGoverState=view.findViewById(R.id.GovState);
        editGoverGstin=view.findViewById(R.id.GovGstin);
        editGoverGuideName=view.findViewById(R.id.GovGuideName);
        editGoverEmailId=view.findViewById(R.id.GovEmailId);
        editGoverGuideEmailId=view.findViewById(R.id.GovGuideEmailId);
        editGoverPassword=view.findViewById(R.id.GovPassword);
        editGoverRepassword=view.findViewById(R.id.GovRePassword);
        btnGovSave=view.findViewById(R.id.btngovt_Login);


        btnGovSave.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                BackgroundTask btask=new BackgroundTask(getActivity());

                btask.execute("register",editGoverName.getText().toString(),
                        editGoverContact.getText().toString(),
                        editGovAddress.getText().toString(),
                        editGoverDepartmentName.getText().toString(),
                        editGoverEmailId.getText().toString(),
                        editGoverGuideName.getText().toString(),
                        editGoverGuideEmailId.getText().toString(),
                        editGoverGstin.getText().toString(),"27"
                        ,editGoverPassword.getText().toString(),"3",
                        editGoverInstituName.getText().toString());

                Toast.makeText(getActivity(), "Entered !!!", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }




}
