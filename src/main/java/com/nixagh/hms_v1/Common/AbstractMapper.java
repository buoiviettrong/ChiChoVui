package com.nixagh.hms_v1.Common;

import com.nixagh.hms_v1.modals.UserModal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class  AbstractMapper<T> {
  public abstract List<T> map(ResultSet rs) throws SQLException;
}