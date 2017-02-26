# -*- coding: utf-8 -*-
"""
Created on Sun Feb 26 13:20:51 2017

@author: Thautwarm
"""
def EntityWrapper(func):
    def _func(**kw2):
        attrs=kw2['attrs']
        types=kw2['types']
        return func(attrs,types)
    return _func
    
def InitWithTypeMapSet(Name,attrs,types):
    Unit = lambda x,y:\
"""
    TypeMap.put("%s","%s");"""%(x,y) 
    body=\
"""
    public static Map<String,String> %s(){
    Map<String,String> TypeMap=new HashMap<String,String>();
    %s
    return TypeMap;
    }
"""%("getTypeMap",'\n'.join(Unit(attr_i,type_i) for attr_i,type_i in zip(attrs,types) ))
    return body
    
@EntityWrapper
def toSQLValuesSet(attrs,types):
    tosql=[attr_i if type_i!="Date" else '(new Timestamp (%s.getTime()))'%attr_i  for attr_i,type_i in zip(attrs,types)]
    body=\
"""
    public String toSQLValues(){
        return %s;
    }
"""%("""+","+""".join(tosql))
    return body
    
@EntityWrapper
def toSQLColumnsSet(attrs,types):
    body=\
"""
    public static String toSQLColumns(){
        return "%s";
    }
"""%(','.join(attrs))
    return body

    
    