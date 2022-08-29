# -*- coding: utf-8 -*-
"""
# -*- coding: utf-8 -*-
"""
"""Spyder Editor

This is a temporary script file."""
"""
"""
from flask import Flask,jsonify
from multiprocessing import Value
from flask import request
import csv
import random
import time
import socket
import pandas as pd

count=0;
x_value = 0;
Rpi_Temp = 0;
Rpi_Humi = 0;
Rpi_Co2 = 0;

g =Value('i',0)
g2=Value('i',0)
g3=Value('i',0)
# import request

app = Flask(__name__)
 ###########################################
 #######################################
fieldnames = ["x_value", "Rpi_Temp", "Rpi_Humi", "Rpi_Co2"]
Data = pd.read_csv('C:/Users/hp/Downloads/Rpi_original.csv')


#####################################
################################
def get_ip_address():
    """Find the current IP address of the device"""
    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    s.connect(("8.8.8.8", 80))
    ip_address=s.getsockname()[0]
    s.close()
    return ip_address

@app.route("/")
def showHomePage():
	return "Device 3"

@app.route("/node1",methods=["POST"])
def node1():
    x_value = Data.iloc[g.value,0]
    Rpi_Temp = Data.iloc[g.value,2]
    print(x_value,Rpi_Temp)
    g.value += 1
    p = str(Rpi_Temp)
    return p;
         
                
@app.route("/node2",methods=["POST"])
def node2():
    x_value = Data.iloc[g2.value,0]
    Rpi_Humi = Data.iloc[g2.value,1]
    print(x_value,Rpi_Humi)
    g2.value +=1;
    p = str(Rpi_Co2)
    return p;
    
@app.route("/node3", methods=["POST"])
def node3():
    x_value = Data.iloc[g3.value,0]
    Rpi_Co2 = Data.iloc[g3.value,3]
    print(x_value,Rpi_Co2)
    g3.value+=1;
    p=str(Rpi_Humi)
    return p;

if __name__ == "__main__":
    ip=get_ip_address()
    port=521
    app.run(host=ip,port=port,debug=True)
    
