# -*- coding:utf-8 -*-
'''
Created on 2017年12月21日

@author: chch
'''
import csv
import json
from parameters import DATA_FILE, KPI_CSV_FILE, TRAINING_SAMPLES


def get_kpi_from_csv_file(filename):
    with open(filename) as csvfile:
        kpi_reader=csv.reader(csvfile)
        return [[int(s) for s in line] for line in kpi_reader][0]
        
        
def save_as_json_file(obj, filename):
    with open(filename, 'wt') as file:
        print(json.dumps(obj, indent=4), file=file)

def generate_data_sets():
    kpi_raw=get_kpi_from_csv_file(KPI_CSV_FILE)
    train_data=kpi_raw[:TRAINING_SAMPLES]
    test_data =kpi_raw[TRAINING_SAMPLES:]
    save_as_json_file({'train_data': train_data,
                       'test_data' : test_data }, 
                      DATA_FILE)
    

if __name__ == '__main__':
    generate_data_sets()
