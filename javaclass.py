# -*- coding: utf-8 -*-

"""
Spyder Editor

This is a temporary script file.
"""
template=\
"""
package _PACKAGE_;
_IMPORT_
public class _JAVA_CLASS_NAME_ {
\t_JAVA_ATTRS_
\t_JAVA_SG_
\t_PLUS_
}
"""

def searchImport(types):
    
    body=\
"""import java.util.Map;
import java.util.HashMap;
%s
"""
    if "Date" in types:
        __ADD__=\
"""import java.sql.Timestamp;
import java.util.Date;

"""
    else:
        __ADD__="";
    return body%__ADD__


def AttrSet(attrs,types):
    gen=lambda x,y:"private %s %s;"%(x,y)
    return '\n\t'.join(gen(type_i,attr_i) for attr_i,type_i in zip(attrs,types))        
def SetterAndGetter(attrName,attrType):
    getter=\
    """
    public %s get%s(){
        return %s;
    }
    """%(attrType,attrName.capitalize(),attrName)
    setter=\
    """
    public void set%s(%s %s){
        this.%s=%s;
    }
    """%(attrName.capitalize(),attrType,attrName,attrName,attrName)
    if attrType=="Long":
        setter+=\
    """
    public void set%s(Integer %s){
        this.%s= Long.valueOf(%s.toString());
    }
    """%(attrName.capitalize(),attrName,attrName,attrName)
        
    return setter+'\n'+getter
def MethodSet(attrs,types):
    return '\n'.join( SetterAndGetter(attr_i,type_i) for attr_i,type_i in zip(attrs,types))    
def SwitchCaseSet(attrName,attrType):
    UnitCase=lambda KeyName,Type: \
"""
            case "%s":
                this.set%s( (%s) _SWITCH_VALUE );
                break;
"""%(KeyName,KeyName.capitalize(),Type) 
    defaultCase=lambda :\
"""
            default :
                System.out.println("setByKey-KeyNotFoundError");
                break;
"""
    Cases='\n'.join([UnitCase(KeyName,Type) for KeyName,Type in zip(attrName,attrType)]+[defaultCase()])
    return Cases

def GeneralSet(attrName,attrType):
    body=\
"""
    public boolean setByKey(String ATTR_NAME, Object _SWITCH_VALUE){
        if (_SWITCH_VALUE==null) {
            System.out.println("setByKey-ValueNullError");
            return false;
            }
        
        switch(ATTR_NAME){
%s
            }
        
        
        return true;
    }
"""%SwitchCaseSet(attrName,attrType)
    return body



    
    
def JavaEntity(json,other,package='entity'):
    attrs=json['Attributes']
    types=json['Types']
#    types=[i if i!="Long" else "BigInteger" for i in types]
    Name=json['ClassName']
    if len(attrs)!=len(types):
        print ('error: length of attributes not equals to that of  types. ')
        return
    body=template.replace("_JAVA_CLASS_NAME_",Name).replace("_IMPORT_",searchImport(types)).replace("_PACKAGE_",package)
    Attrs=AttrSet(attrs,types)
    Methods=MethodSet(attrs,types)+'\n'+GeneralSet(attrs,types)
    if type(other)==list:
       PLUS='\n'.join(deal(Name=Name,attrs=attrs,types=types) for deal in other)
    else:
        PLUS=""
    body=body.replace("_JAVA_ATTRS_",Attrs).replace("_JAVA_SG_",Methods).replace("_PLUS_",PLUS)
    return body
        
    







