package com.hermes.model.orm;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.hermes.model.orm.Entity.EntityMapping;

/**
 * Standard mapping for {@link Entity} subclasses. Automatically saves the
 * model if it's transient during encoding, when called from a 
 * {@link Entity#save()}. When called for query creation, will throw
 * an exception if the object is transient. Encodes value as an 
 * INTEGER with the value being the model's primary key.
 */
public class EntityTypeMapping implements TypeMapping {
  private static final String TAG = "EntityTypeMapping";
  
  public Class<?> javaType() {
    return Entity.class;
  }

  public String sqlType(Class<?> concreteType) {    
    @SuppressWarnings("unchecked")
    EntityMapping map = Entity.getEntityMapping((Class<? extends Entity>)concreteType);
    
    // TODO ON_UPDATE, ON_DELETE etc.
    
    return "INTEGER REFERENCES " + map.mTableName + "(" + map.mPrimaryKeyColumnName + ")";
  }
  
  public String encodeValue(SQLiteDatabase db, Object value) {
    Entity model = (Entity)value;
    
    if (model.isTransient()) {
      if (db == null) {
        throw new IllegalArgumentException("Transient object doesn't make sense here");
      } else {
        return TypeMapper.encodeValue(db, model.save(db));
      }
    } else {    
      return TypeMapper.encodeValue(db, model.getPrimaryKeyValue());
    }
  }

  // TODO Fix this, it's a mess:
  //
  //            * It's hardcoded for int primary keys
  //            * It's inefficient
  //            * It's generally a mess...
  public Object decodeValue(SQLiteDatabase db, Class<?> expectedType, Cursor c, int columnIndex) {
    if (Entity.class.isAssignableFrom(expectedType)) {
      @SuppressWarnings("unchecked")
      Class<? extends Entity> expEntityType = (Class<? extends Entity>)expectedType;

      // TODO could use Query here? Maybe Query could have a primaryKey() method to select by prikey?
      EntityMapping map = Entity.getEntityMappingEnsureSchema(db, expEntityType);
      String sql = "SELECT * FROM " + map.mTableName + " WHERE " + map.mPrimaryKeyColumnName + "=" + c.getInt(columnIndex) + " LIMIT 1";
      Log.v(TAG, sql);
      Cursor valc = db.rawQuery(sql, null);
      if (valc.moveToFirst()) {
        return map.load(db, valc);
      } else {
        return null;
      }      
    } else {
      throw new IllegalArgumentException("EntityTypeMapping can only be used with Entity subclasses");
    }
  }
}
