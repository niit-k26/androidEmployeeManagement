package vn.com.employeemng.employeemanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DALEmployee {
    DBHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;
    Context context;

    public DALEmployee(Context context) {
        this.context = context;
        dbHelper = new DBHelper(this.context);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    //create
    public long addEmployee(Employee employee){
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",employee.getId());
        contentValues.put("name",employee.getName());
        contentValues.put("position",employee.getPosition());
        contentValues.put("address",employee.getAddress());
        contentValues.put("salary",employee.getSalary());
        return sqLiteDatabase.insert(DBHelper.TABLE_EMPLOYEE,null,contentValues);
    }


    //retrieve
    public ArrayList<Employee> getAllEmployee(){
        ArrayList<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM "+DBHelper.TABLE_EMPLOYEE;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        if(cursor!=null && cursor.moveToFirst()){
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String position = cursor.getString(cursor.getColumnIndex("position"));
                String address= cursor.getString(cursor.getColumnIndex("address"));
                Float salary = cursor.getFloat(cursor.getColumnIndex("salary"));

                Employee employee = new Employee();
                employee.setId(id);
                employee.setAddress(address);
                employee.setPosition(position);
                employee.setSalary(salary);
                employee.setName(name);

                employees.add(employee);
            }while (cursor.moveToNext());
            cursor.close();
            return employees;
        }
        return null;
    }

    //update
    public int updateEmployee(Employee employee, int id){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",employee.getName());
        contentValues.put("position",employee.getPosition());
        contentValues.put("address",employee.getAddress());
        contentValues.put("salary",employee.getSalary());
        return sqLiteDatabase.update(DBHelper.TABLE_EMPLOYEE,contentValues,"id = "+id,null);
    }

    //delete
    public int deleteEmployee(int id){
        return sqLiteDatabase.delete(DBHelper.TABLE_EMPLOYEE,"id = "+id,null);
    }

    public void close(){
        if(sqLiteDatabase!=null){
            sqLiteDatabase.close();
        }
    }

}
