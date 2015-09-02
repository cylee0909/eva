package com.cylee.androidtest;

import android.content.Context;
import com.eva.orm.BaseDataBaseHelper;
import com.eva.orm.BaseTable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cylee on 15/9/1.
 */
public class TestDataBaseHelper extends BaseDataBaseHelper {

  public TestDataBaseHelper(Context context) {
    super(context, "TestDb.db", 1);
  }

  @Override public List<Class<? extends BaseTable>> getTableClasses() {
    List<Class<? extends BaseTable>> tables = new ArrayList<Class<? extends BaseTable>>();
    tables.add(TestTable.class);
    tables.add(AnotherTable.class);
    return tables;
  }
}
