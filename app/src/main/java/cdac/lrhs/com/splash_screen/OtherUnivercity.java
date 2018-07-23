package cdac.lrhs.com.splash_screen;

import android.app.Fragment;
import android.app.VoiceInteractor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class OtherUnivercity extends Fragment
{
    TextInputEditText editOtherName,editOtherContact,editOtherDepartment,editOtherState,
            editOtherGstin,editOtherUnivercity,
            editOtherGuideName,editOtherEmailId,editOtherGuideEmailId,editOtherPassword,
            editOtherRepassword,editOtherAdress;
    Button btnOtherSave;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.otherunivercity_layout,container,false);
        editOtherName=view.findViewById(R.id.OtherName);
        editOtherContact=view.findViewById(R.id.OtherContact);
        editOtherDepartment=view.findViewById(R.id.OtherDepartmentName);
        editOtherState=view.findViewById(R.id.OtherState);
        editOtherGstin=view.findViewById(R.id.otherGstin);
        editOtherGuideName=view.findViewById(R.id.OhterGuideName);
        editOtherEmailId=view.findViewById(R.id.OtherEmailId);
        editOtherGuideEmailId=view.findViewById(R.id.OtherGuideEmailid);
        editOtherPassword= view.findViewById(R.id.OtherPassword);
        editOtherRepassword=view.findViewById(R.id.OtherRePassword);
        editOtherAdress=view.findViewById(R.id.OtherAddress);
        editOtherUnivercity=view.findViewById(R.id.OterUnivercityName);
        btnOtherSave=view.findViewById(R.id.btnOther);

        if(editOtherPassword.getText().toString().equals(editOtherRepassword.getText().toString()))
        {

            btnOtherSave.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    BackgroundTask btask = new BackgroundTask(getActivity());

                    btask.execute("register", editOtherName.getText().toString(),
                            editOtherContact.getText().toString(),
                            editOtherAdress.getText().toString(),
                            editOtherDepartment.getText().toString(),
                            editOtherEmailId.getText().toString(),
                            editOtherGuideName.getText().toString(),
                            editOtherGuideEmailId.getText().toString(),
                            editOtherGstin.getText().toString(), "27"
                            , editOtherPassword.getText().toString(), "5",
                            editOtherUnivercity.getText().toString());

                    Toast.makeText(getActivity(), "Entered !!!", Toast.LENGTH_SHORT).show();

                }
            });
        }
        else
            Toast.makeText(getActivity(),"NOT MATCH",Toast.LENGTH_LONG).show();

        return view;
    }


}
