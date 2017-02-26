# -*- coding: utf-8 -*-
"""
Created on Sun Feb 26 16:42:51 2017

@author: Thautwarm
"""

import json
from JavaEntity import GraceJavaEntity
jsons=json.load(open(r"C:\Users\Thautwarm\Desktop\jtest.json"))
Names=GraceJavaEntity(jsons)
from entityDao import getDao
for name in Names:
    body=getDao(name)
    filename="dao/%sDao.java"%name
    print (filename)
    with open(filename,'w') as file:
        file.write(body)