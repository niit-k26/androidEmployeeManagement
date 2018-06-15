package vn.com.employeemng.employeemanagement;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterEmployee extends ArrayAdapter<Employee>{
    int resouces;
    ArrayList<Employee> employees;
    Context context;

    public AdapterEmployee(@NonNull Context context, int resource, @NonNull ArrayList<Employee> objects) {
        super(context, resource, objects);
        this.resouces=resource;
        this.employees=objects;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Holder holder = null;
        if(convertView == null){
           convertView = LayoutInflater.from(context).inflate(this.resouces,null);
           holder = new Holder();
           holder.tvFullName=convertView.findViewById(R.id.tvFullName);
           holder.tvPosition=convertView.findViewById(R.id.tvPosition);
           holder.tvAddress=convertView.findViewById(R.id.tvAddress);
           holder.tvSalary=convertView.findViewById(R.id.tvSalary);
           convertView.setTag(holder);
        }else{
            holder= (Holder)convertView.getTag();
        }
        Employee employee = getItem(position);
        holder.tvFullName.setText(employee.getName());
        holder.tvSalary.setText(employee.getSalary()+"");
        holder.tvAddress.setText(employee.getAddress());
        holder.tvPosition.setText(employee.getPosition());
        return convertView;
    }

    class Holder{
        public Holder() {

        }

        TextView tvFullName;
        TextView tvPosition;
        TextView tvSalary;
        TextView tvAddress;
    }
}
