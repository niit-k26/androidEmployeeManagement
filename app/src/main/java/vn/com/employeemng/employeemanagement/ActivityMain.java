package vn.com.employeemng.employeemanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityMain extends AppCompatActivity{
    ListView lstView;
    Button btnAdd;
    AdapterEmployee adapterEmployee;
    ArrayList<Employee> employees = new ArrayList<Employee>();
    DALEmployee dalEmployee;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstView=(ListView)findViewById(R.id.lstView);
        btnAdd=(Button)findViewById(R.id.btnAdd);

        //do du lieu vao listview
        dalEmployee = new DALEmployee(getApplicationContext());
        //employees=dalEmployee.getAllEmployee();

       // if(employees==null){
        employees = new ArrayList<>();
       // }

        adapterEmployee = new AdapterEmployee(getApplicationContext(),R.layout.row_item_employee,employees);
        lstView.setAdapter(adapterEmployee);

        //handle event cho btnAdd
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ActivityAdd.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        employees.clear();
        ArrayList<Employee> hihi = dalEmployee.getAllEmployee();
        for (int i = 0 ; i < hihi.size();i++){
           employees.add(hihi.get(i));
        }
        //employees = dalEmployee.getAllEmployee();
        adapterEmployee.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(dalEmployee!=null) {
            dalEmployee.close();
        }
    }
}
