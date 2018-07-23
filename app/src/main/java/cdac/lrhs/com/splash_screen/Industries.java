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

public class Industries extends Fragment
{
    Button btindustryLogin;
    TextInputEditText editIndustryName,editIndustryContact,editIndustryCompanyName,editIndustryAddress,
            editIndustryState, editIndustryGstin,editEmailId, editPassword,editRepassword;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
          View view = inflater.inflate(R.layout.industries_layout,container,false);
          editIndustryName=view.findViewById(R.id.IndustryName);
          editIndustryContact=view.findViewById(R.id.IndustryContact);
          editIndustryCompanyName=view.findViewById(R.id.IndustryCompanyName);
          editIndustryAddress=view.findViewById(R.id.IndustryAddress);
          editIndustryState=view.findViewById(R.id.IndustryState);
          editIndustryGstin=view.findViewById(R.id.IndustryGstin);
          editEmailId=view.findViewById(R.id.IndustryEmailId);
          editPassword=view.findViewById(R.id.IndustryPassword);
          editRepassword=view.findViewById(R.id.IndustryRePassword);
          btindustryLogin=view.findViewById(R.id.btnindustryLogin);

          btindustryLogin.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  String pass1 = editPassword.getText().toString();
                  String pass2 = editRepassword.getText().toString();
                  String name = editIndustryName.getText().toString();
                  String contact = editIndustryContact.getText().toString();
                  String email = editEmailId.getText().toString();


                  if(name==null){
                      Toast.makeText(getActivity(), "Enter name", Toast.LENGTH_LONG).show();
                  }
                  else if(contact.length()<10) {
                      Toast.makeText(getActivity(), "Enter correct mobile no", Toast.LENGTH_LONG).show();
                  }
                  else if(pass1 == null){
                      Toast.makeText(getActivity(), "password field is blank", Toast.LENGTH_LONG).show();
                  }
                  else {

                      if(pass1.equals(pass2)){
                          BackgroundTask bgindtask = new BackgroundTask(getActivity());
                          bgindtask.execute("register", editIndustryName.getText().toString(),
                                  editIndustryContact.getText().toString(),
                                  editIndustryAddress.getText().toString(),
                                  editIndustryCompanyName.getText().toString(),
                                  editEmailId.getText().toString(),
                                  "--", "--",
                                  editIndustryGstin.getText().toString(),
                                  "27",
                                  editPassword.getText().toString(), "4",
                                  editIndustryCompanyName.getText().toString()
                          );
                      }else{
                          Toast.makeText(getActivity(), "Password should match !!!", Toast.LENGTH_LONG).show();
                      }


                      editIndustryName.setText("");
                      editIndustryContact.setText("");
                      editIndustryCompanyName.setText("");
                      editIndustryAddress.setText("");
                      editIndustryState.setText("");
                      editIndustryGstin.setText("");
                      editEmailId.setText("");
                      editPassword.setText("");
                      editRepassword.setText("");
                      btindustryLogin.setText("");

                  }
                  }
              });
          return view;
    }
}
