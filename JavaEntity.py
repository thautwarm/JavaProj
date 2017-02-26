# -*- coding: utf-8 -*-
"""
Created on Sun Feb 26 16:16:31 2017

@author: Thautwarm
"""

from javaclass import JavaEntity
from sqlclass import InitWithTypeMapSet,toSQLValuesSet,toSQLColumnsSet


def GraceJavaEntity(jsons):
    Names=[]
    for json in jsons:
        Name=json['ClassName']
        body=JavaEntity(json,other=[toSQLValuesSet,toSQLColumnsSet,InitWithTypeMapSet])
        to="entity/%s.java"%Name
        with open(to,'w') as file:
            file.write(body)
        Names.append(Name)
    return Names
        

        
            
    