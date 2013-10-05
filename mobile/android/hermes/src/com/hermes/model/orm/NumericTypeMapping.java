/*
 * Copyright 2012 Ross Bamford
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package com.hermes.model.orm;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/*
 * TODO: this could be folded into StringTypeMapping, by having a flag that
 * determines whether or not we sqlescape the resulting string...?
 * 
 *     Obviously would make things more difficult when load()ing...
 */
public class NumericTypeMapping implements TypeMapping {
  private Class<?> mJavaType; 
  private String mSqlType;
  
  public NumericTypeMapping(Class<?> type, String sqlType) {
    mJavaType = type;
    mSqlType = sqlType;      
  }

  public Class<?> javaType() {
    return mJavaType;
  }

  public String sqlType(Class<?> concreteType) {
    return mSqlType;
  }

  public String encodeValue(SQLiteDatabase db, Object value) {
    return value.toString();
  }

  // TODO this will cause exceptions when trying to unbox into smaller types...
  //        or worse, silently lose data... Look into this!
  public Object decodeValue(SQLiteDatabase db, Class<?> expectedType, Cursor c, int columnIndex) {
    return c.getInt(columnIndex);
  }
}