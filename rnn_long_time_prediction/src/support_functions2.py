# -*- coding:utf-8 -*-
'''
Created on 2017年12月21日

@author: chch
'''

import numpy as np

def normalize(sequence):
    sequence_max=max(sequence)
    return [(value+0.0)/sequence_max for value in sequence], sequence_max


def generate_error(sequence, error_ratio=1.0, start_offset=1500, stop_offset=1800):
    return [v*error_ratio if i>=start_offset and i<=stop_offset else v for i,v in enumerate(sequence)]
    
    
# def convert_to_rnn_data_set(seq,time_steps=10):
#     X = []
#     y = []
# 
#     for i in range(len(seq) - time_steps):
#         X.append([seq[i: i + time_steps]])
#         y.append([seq[i + time_steps]])
#     return np.array(X, dtype=np.float32), np.array(y, dtype=np.float32)
    
def convert_to_rnn_data_set(seq,time_steps=10,predict_steps=20):
    X = []
    y = []

    for i in range(len(seq) - time_steps - predict_steps):
        X.append([seq[i: i + time_steps]])
#         y.append([seq[i + time_steps + predict_steps]])
        y.append(seq[i + time_steps: i + time_steps + predict_steps])
    return np.array(X, dtype=np.float32), np.array(y, dtype=np.float32)
    

def get_data_sample_from_json_file(file_name, key_name):
    import json
    
    with open(file_name, 'rt') as file:
        obj=json.load(file)
        return obj[key_name]
    
    

def plot_surfaces(surface_1,surface_2):
    import numpy as np
    import matplotlib.pyplot as plt
    from matplotlib import cm
    from mpl_toolkits.mplot3d import Axes3D
    
    dim_x1,dim_y1=np.shape(surface_1)
    dim_x2,dim_y2=np.shape(surface_2)
    
    dim_x=max(dim_x1,dim_x2)
    dim_y=max(dim_y1,dim_y2)
    X=np.arange(dim_x)
    Y=np.arange(dim_y)
    X, Y = np.meshgrid(Y, X)
    Z1=surface_1
    Z2=surface_2
    print([Z1])
    print([Z2])
    
    
    fig = plt.figure()
    ax = Axes3D(fig)
    ax.plot_surface(X, Y, Z1, rstride=1, cstride=1, cmap=cm.viridis, alpha=0.7)
    ax.plot_surface(X, Y, Z2, rstride=1, cstride=1, cmap=cm.coolwarm , alpha=0.3)
    
    plt.show()






def test01():
    from parameters import DATA_FILE
    
    print(get_data_sample_from_json_file(DATA_FILE, 'train_data'))
    print(get_data_sample_from_json_file(DATA_FILE, 'test_data'))
    
def test02():
    from parameters import DATA_FILE
    
    train_data=get_data_sample_from_json_file(DATA_FILE, 'train_data')
    rnn_train_data=convert_to_rnn_data_set(train_data, time_steps=4, predict_steps=6)
    X,Y=rnn_train_data
    
    
    print(X)
    print(Y)
    
if __name__ == '__main__':
#     test01()
    test02()

