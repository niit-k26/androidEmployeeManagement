package vn.com.employeemng.employeemanagement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityAdd extends AppCompatActivity {
    EditText edtFullName,edtPosition,edtSalary,edtAddress,edtIdentity;
    Button btnAdd;
    DALEmployee dalEmployee;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        edtFullName=findViewById(R.id.edtFullName);
        edtPosition=findViewById(R.id.edtPosition);
        edtSalary=findViewById(R.id.edtSalary);
        edtAddress=findViewById(R.id.edtAddress);
        edtIdentity=findViewById(R.id.edtIdentity);

        btnAdd=(Button)findViewById(R.id.btn);
        dalEmployee = new DALEmployee(getApplicationContext());
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtFullName= edtFullName.getText().toString();
                String txtPosition = edtPosition.getText().toString();
                String txtSalary = edtSalary.getText().toString();
                String txtAddress = edtAddress.getText().toString();
                String identity = edtIdentity.getText().toString();

                if(txtFullName.equalsIgnoreCase("")
                        || txtAddress.equalsIgnoreCase("")
                        || txtPosition.equalsIgnoreCase("")
                        || txtSalary.equalsIgnoreCase("")
                        ){
                    Toast.makeText(getApplicationContext(),"All field required",Toast.LENGTH_SHORT).show();
                  return;
                }

                Employee employee = new Employee();
                employee.setName(txtFullName);
                employee.setAddress(txtAddress);
                employee.setPosition(txtPosition);
                employee.setSalary(Float.parseFloat(txtSalary));
                employee.setId(Integer.parseInt(identity));
                dalEmployee.addEmployee(employee);

                //reset form
                edtFullName.setText("");
                edtPosition.setText("");
                edtSalary.setText("");
                edtAddress.setText("");

            }
        });
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(dalEmployee!=null){
            dalEmployee.close();
        }
    }
}
