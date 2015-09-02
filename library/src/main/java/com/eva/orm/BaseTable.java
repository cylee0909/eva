package com.eva.orm;

/**
 * Created by cylee on 15/9/1.
 */
public class BaseTable {
  private Long _ID = null;
  public long _getDataBaseId() {
    return _ID;
  }

  public void _setDataBaseId(long id) {
    _ID = id;
  }
}
