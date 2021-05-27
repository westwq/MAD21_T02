package sg.edu.np.mad.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    public DBHandler(@Nullable Context context) {
        super(context, "T02DB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USERS (NAME TEXT, AGE INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USERS"); //by right, check for old version, patch up the schema
        onCreate(db);
    }

    public void addUser(User user)
    {
        ContentValues values = new ContentValues();
        values.put("name", user.getName());
        values.put("age", user.getAge());

        SQLiteDatabase db = getWritableDatabase();
        db.insert("USERS", null, values);
        db.close();
    }

    /**
     * select * from users where name = "xxxx";
     *
     * name = *";select * from xxx;
     * @param name
     * @return
     */
    public ArrayList<User> getUser(String name)
    {
        SQLiteDatabase db = getWritableDatabase();
        //Cursor cursor = db.rawQuery("select * from users where name = \"" + name + "\"", null);
        Cursor cursor = db.rawQuery("select * from users", null);
        User u = null;
        ArrayList<User> list = new ArrayList<>();

        while(cursor.moveToNext())
        {
            u = new User();
            u.setName(cursor.getString(0));
            u.setAge(cursor.getInt(1));

            list.add(u);
        }

        cursor.close();
        db.close();

        return list;
    }
}
