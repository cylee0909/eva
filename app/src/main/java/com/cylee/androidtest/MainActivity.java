package com.cylee.androidtest;

import android.os.Bundle;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Debug.waitForDebugger();
    setContentView(R.layout.activity_main);
    TestDataBaseHelper helper = new TestDataBaseHelper(this);
    TestTable t1 = new TestTable();
    t1.age = 10;
    t1.name = "hhh";
    helper.save(t1);

    List<TestTable> testTables = new ArrayList<>();
    for (int i = 0 ; i < 10; i++) {
      TestTable t = new TestTable();
      t.name = "tts"+String.valueOf(i);
      t.age = i * i;
      testTables.add(t);
    }

    long time = System.currentTimeMillis();
    //SQLiteDatabase db = helper.getWritableDatabase();
    //SQLiteStatement statement = db.compileStatement("insert into TestTable (_ID, name, age) values (?, ?, ?)");
    //try {
    //  db.beginTransaction();
    //  for (TestTable t : testTables) {
    //    statement.bindNull(0);
    //    statement.bindString(1, t.name);
    //    statement.bindLong(2, t.age);
    //    statement.executeInsert();
    //    statement.clearBindings();
    //  }
    //  db.setTransactionSuccessful();
    //} catch (Exception e) {
    //} finally {
    //  db.endTransaction();
    //}

    helper.save(testTables);

    Log.d("cylee", String.valueOf(System.currentTimeMillis() - time));

    AnotherTable table = new AnotherTable();
    table.b1 = false;
    table.f1 = 1.23f;
    table.text1 = "Haha";
    table.i1 = 12;
    helper.save(table);

    AnotherTable at = helper.find(AnotherTable.class, "I1 = ?", new String[]{String.valueOf(12)}).get(0);
    Log.d("cylee",at.b1+" "+at.f1+" "+at.text1+" "+at.i1);
  }
}
