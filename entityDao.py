# -*- coding: utf-8 -*-
"""
Created on Sun Feb 26 17:29:16 2017

@author: Thautwarm
"""

template=\
"""
package _PACKAGE_;
import _ENTITY_PACKAGE_;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import GraceJava.SQL;
import GraceJava.ToStr;
public class _ENTITY_CLASS_NAME_Dao extends SQL{

	public _ENTITY_CLASS_NAME_Dao() {
		setTypeMap(_ENTITY_CLASS_NAME_.getTypeMap());
		setTableName("_ENTITY_OBJ_NAME_");
	}
	public ArrayList<_ENTITY_CLASS_NAME_> selectEntity(String columns,String MatchValues){
		ArrayList<_ENTITY_CLASS_NAME_> _ENTITY_OBJ_NAME_List= new ArrayList<_ENTITY_CLASS_NAME_>();
		ResultSet res =Select(_ENTITY_CLASS_NAME_.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			_ENTITY_CLASS_NAME_ _ENTITY_OBJ_NAME_=new _ENTITY_CLASS_NAME_();
			for(String column:columnsKeys){
				
				Object obj=null;
				String type=this.TypeMap.get(column);
				switch (type){
    
				case "Integer":
					obj=res.getInt(column);
					break;
				case "String":
					obj=res.getString(column);
					break;
				case "Date":
					obj= ToStr.Timestamp2Date(res.getTimestamp(column));
					break;
				case "Double":
					obj= res.getDouble(column);
					break;
				case "Long":
					obj= res.getLong(column);
					break;
				default:
					break;
				}
				
				
				if (obj==null) {
					continue;
				}
				
				_ENTITY_OBJ_NAME_.setByKey(column, obj);
			}
			_ENTITY_OBJ_NAME_List.add(_ENTITY_OBJ_NAME_);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return _ENTITY_OBJ_NAME_List;
	}
	public ArrayList<_ENTITY_CLASS_NAME_> selectEntity(String columns,Object ...MatchValues){
		ArrayList<_ENTITY_CLASS_NAME_> _ENTITY_OBJ_NAME_List= new ArrayList<_ENTITY_CLASS_NAME_>();
		ResultSet res =Select(_ENTITY_CLASS_NAME_.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			_ENTITY_CLASS_NAME_ _ENTITY_OBJ_NAME_=new _ENTITY_CLASS_NAME_();
			for(String column:columnsKeys){
				
				Object obj=null;
				String type=this.TypeMap.get(column);
				switch (type){
    
				case "Integer":
					obj=res.getInt(column);
					break;
				case "String":
					obj=res.getString(column);
					break;
				case "Date":
					obj= ToStr.Timestamp2Date(res.getTimestamp(column));
					break;
				case "Double":
					obj= res.getDouble(column);
					break;
				case "Long":
					obj= res.getLong(column);
					break;
				default:
					break;
				}
				
				
				if (obj==null) {
					continue;
				}
				
				_ENTITY_OBJ_NAME_.setByKey(column, obj);
			}
			_ENTITY_OBJ_NAME_List.add(_ENTITY_OBJ_NAME_);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return _ENTITY_OBJ_NAME_List;
	}
     	public ArrayList<_ENTITY_CLASS_NAME_> selectEntity(_ENTITY_CLASS_NAME_ _ENTITY_OBJ_NAME_Select){
            String MatchValues=_ENTITY_OBJ_NAME_Select.toSQLValues();
		ArrayList<_ENTITY_CLASS_NAME_> _ENTITY_OBJ_NAME_List= new ArrayList<_ENTITY_CLASS_NAME_>();
		String columns=_ENTITY_CLASS_NAME_.toSQLColumns();
		ResultSet res =Select(_ENTITY_CLASS_NAME_.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			_ENTITY_CLASS_NAME_ _ENTITY_OBJ_NAME_=new _ENTITY_CLASS_NAME_();
			for(String column:columnsKeys){
				
					Object obj=null;
				String type=this.TypeMap.get(column);
				switch (type){
    
				case "Integer":
					obj=res.getInt(column);
					break;
				case "String":
					obj=res.getString(column);
					break;
				case "Date":
					obj= ToStr.Timestamp2Date(res.getTimestamp(column));
					break;
				case "Double":
					obj= res.getDouble(column);
					break;
				case "Long":
					obj= res.getLong(column);
					break;
				default:
					break;
				}
				
				
				if (obj==null) {
					continue;
				}
				
				_ENTITY_OBJ_NAME_.setByKey(column, obj);
			}
			_ENTITY_OBJ_NAME_List.add(_ENTITY_OBJ_NAME_);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return _ENTITY_OBJ_NAME_List;
	}
	public boolean add(_ENTITY_CLASS_NAME_ _ENTITY_OBJ_NAME_){
		if (isDuplicatedByKey("id",_ENTITY_OBJ_NAME_.getId()).equals("No")){
			return addEntity(_ENTITY_CLASS_NAME_.toSQLColumns(),_ENTITY_OBJ_NAME_.toSQLValues());
		}
            System.out.println("add_ENTITY_CLASS_NAME_Error-DuplicatedAdded.");
		return false;
	}
}
"""
def getDao(_ENTITY_CLASS_NAME_,_ENTITY_PACKAGE_=None,_PACKAGE_='dao'):
    _ENTITY_OBJ_NAME_=_ENTITY_CLASS_NAME_.lower()
    if not _ENTITY_PACKAGE_:_ENTITY_PACKAGE_='entity.%s'%_ENTITY_CLASS_NAME_;
    return template.replace("_ENTITY_CLASS_NAME_",_ENTITY_CLASS_NAME_).replace("_ENTITY_OBJ_NAME_",_ENTITY_OBJ_NAME_)\
.replace("_ENTITY_PACKAGE_",_ENTITY_PACKAGE_).replace("_PACKAGE_",_PACKAGE_)