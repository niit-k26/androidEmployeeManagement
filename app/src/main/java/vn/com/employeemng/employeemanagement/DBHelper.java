package vn.com.employeemng.employeemanagement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "employees";
    public static final String TABLE_EMPLOYEE = "employee";
    Context context;

    public DBHelper(Context context) {
        super(context, DBNAME, null, 1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE "+TABLE_EMPLOYEE+"(id integer primary key," +
                " name TEXT," +
                " position TEXT," +
                " address TEXT," +
                " salary FLOAT)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query ="DROP TABLE IF EXISTS "+TABLE_EMPLOYEE;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);
    }
}
