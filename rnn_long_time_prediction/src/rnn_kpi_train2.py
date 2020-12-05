# -*- coding:utf-8 -*-
'''
Created on 2017年12月21日

@author: chch
'''

import numpy as np
import tensorflow as tf
import matplotlib.pyplot as plt

from parameters2 import DATA_FILE, GRAPH_FILE, TIMESTEPS, HIDDEN_SIZE, NUM_LAYERS, TRAINING_STEPS, BATCH_SIZE, PRINT_INTERVAL, PREDICTION_STEPS, PLOT3D_SAMPLES
from support_functions2 import normalize, convert_to_rnn_data_set, get_data_sample_from_json_file, plot_surfaces

def lstm_model(X, y, hidden_size=30, num_layers=2, num_outputs=1):
    cell = tf.contrib.rnn.MultiRNNCell([tf.contrib.rnn.BasicLSTMCell(hidden_size, state_is_tuple=True) for _ in range(num_layers)])

    output, _ = tf.nn.dynamic_rnn(cell, X, dtype=tf.float32)
    output = tf.reshape(output, [-1, hidden_size])
    
    # 通过无激活函数的全联接层计算线性回归，并将数据压缩成一维数组的结构。
    predictions = tf.contrib.layers.fully_connected(output, num_outputs, None)
    predictions = tf.identity(predictions, name='prediction')
    
    # 将predictions和labels调整统一的shape
    labels_reshaped = tf.reshape(y, [-1])
    predictions_reshaped=tf.reshape(predictions, [-1])
    
    loss = tf.losses.mean_squared_error(predictions_reshaped, labels_reshaped)
    
    train_op = tf.contrib.layers.optimize_loss(loss,
                                               tf.contrib.framework.get_global_step(),
                                               optimizer="Adagrad",
                                               learning_rate=0.1,
                                               name='train_op')
    
    return predictions, loss, train_op


def do_train_and_test():
    '''
    This example train model and predict for KPI_001_3(RRCstpRequestFDD) for cell 33528-2
    Note that:
        You need to empty the directory "Model" before you re-run the test if any of the following RNN model parameter is changed:
            TIMESTEPS
            HIDDEN_SIZE
            NUM_LAYERS
    '''
    
    # assign first TRAINING_SAMPLES samples as training set
    kpi_train=get_data_sample_from_json_file(DATA_FILE, 'train_data')
    # assign rest samples as test set
    kpi_test =get_data_sample_from_json_file(DATA_FILE,'test_data')
    
    # get normalized training data and max value of KPI training set
    kpi_train_normalized,kpi_train_max = normalize(kpi_train)
    # scale down the test set according to the max value of the KPI training set
    kpi_test_normalized=[v/kpi_train_max for v in kpi_test]
    
    # converts training and test set to the RNN data set format
    train_X, train_Y = convert_to_rnn_data_set(kpi_train_normalized, time_steps=TIMESTEPS,predict_steps=PREDICTION_STEPS)
    test_X , test_Y  = convert_to_rnn_data_set(kpi_test_normalized , time_steps=TIMESTEPS,predict_steps=PREDICTION_STEPS)
    
    # create RNN inference model
    x=tf.placeholder(tf.float32, shape=[None,1,TIMESTEPS], name='input-x')
    y=tf.placeholder(tf.float32, shape=[None,PREDICTION_STEPS], name='input-y')
    
    scale_factor=tf.constant(kpi_train_max,dtype=tf.float32,name='scale_factor')
    
    predictions, loss, train_op=lstm_model(x, y, hidden_size=HIDDEN_SIZE, num_layers=NUM_LAYERS, num_outputs=PREDICTION_STEPS)
    
    number_of_training_samples=np.shape(train_X)[0]
    
    with tf.Session() as sess:
        sess.run(tf.global_variables_initializer())
        sess.run(scale_factor)
        for i in range(TRAINING_STEPS):
            j=0
            while(BATCH_SIZE*j < number_of_training_samples):
                offset=j*BATCH_SIZE
                if BATCH_SIZE*(j+1) < number_of_training_samples:
                    mini_batch_x=train_X[offset:offset+BATCH_SIZE]
                    mini_batch_y=train_Y[offset:offset+BATCH_SIZE]
                else:
                    mini_batch_x=train_X[offset:]
                    mini_batch_y=train_Y[offset:]
                    
                sess.run(train_op,feed_dict={x:mini_batch_x, y:mini_batch_y})
                j=j+1
                
            if (i%PRINT_INTERVAL) ==0:
                print("step %d, average loss: training=%g, test=%g"%(i,
                                                                     sess.run(loss,feed_dict={x:train_X,y:train_Y}),
                                                                     sess.run(loss,feed_dict={x:test_X,y:test_Y})))
                
        print("final average loss: training=%g, test=%g"%(sess.run(loss,feed_dict={x:train_X,y:train_Y}),
                                                          sess.run(loss,feed_dict={x:test_X,y:test_Y})))
        
        graph=tf.graph_util.convert_variables_to_constants(sess,
                                                           sess.graph_def,
                                                           output_node_names=['prediction', 'scale_factor'])
        tf.train.write_graph(graph,'.', GRAPH_FILE, as_text=False)
        
        predicted=sess.run(predictions,feed_dict={x:test_X})
        
        print(np.shape(test_Y))
        print(np.shape(predicted))
    
#     # plot normalized test data set and its prediction
#     plot_predicted, = plt.plot(predicted, 'yx-', label='predicted')
#     plot_test, = plt.plot(test_Y, 'bx--', label='real')
#     plt.legend([plot_predicted, plot_test],['predicted', 'real'])
#     plt.show()
    plot_surfaces(predicted[:PLOT3D_SAMPLES], test_Y[:PLOT3D_SAMPLES])
    
    
    
        

if __name__ == '__main__':
    do_train_and_test()
#     do_train()
    


