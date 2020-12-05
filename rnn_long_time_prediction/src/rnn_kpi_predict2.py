# -*- coding:utf-8 -*-
'''
Created on 2017年12月21日

@author: chch
'''

import tensorflow as tf
import numpy as np
# import matplotlib.pyplot as plt

from parameters2 import DATA_FILE, GRAPH_FILE, TIMESTEPS, PREDICTION_STEPS, PLOT3D_SAMPLES
from support_functions2 import convert_to_rnn_data_set, get_data_sample_from_json_file, plot_surfaces


def do_prediction():
    '''
    This example shows the prediction of KPI_001_3(RRCstpRequestFDD) for cell 33528-2
    '''
    # reading test set
    kpi_test =get_data_sample_from_json_file(DATA_FILE,'test_data')
    
    
    x=tf.placeholder(tf.float32, shape=[None,1,TIMESTEPS])
    y=tf.placeholder(tf.float32, shape=[None,PREDICTION_STEPS])
    labels=tf.reshape(y,[-1])
    
    # restore the saved model graph
    graph=tf.GraphDef()
    with open(GRAPH_FILE,'rb') as file:
        graph.ParseFromString(file.read())
        
    #restore prediction
    yy=tf.import_graph_def(graph, input_map={'input-x:0':x}, return_elements=['prediction:0'])
    predictions=tf.reshape(yy,[-1])
    
    #restore scale_factor
    scale_factor=tf.import_graph_def(graph, return_elements=['scale_factor:0'])
    
    # define local loss
    # I have to create loss by myself since the tensor loss could not be saved with a name when saving the trained model graph
    loss=tf.losses.mean_squared_error(labels=labels, predictions=predictions)

    with tf.Session() as sess:
        # scale the test set with scale_factor
        kpi_train_max=sess.run(scale_factor)[0]
        kpi_test_normalized=[v/kpi_train_max  for v in kpi_test]
        test_X , test_Y  = convert_to_rnn_data_set(kpi_test_normalized , time_steps=TIMESTEPS, predict_steps=PREDICTION_STEPS)
        
#         predicted_Y=sess.run(predictions,feed_dict={x:test_X})
        predicted_Y=sess.run(yy,feed_dict={x:test_X})[0]
        print('average test loss: %g'%(sess.run(loss,feed_dict={x:test_X, y:test_Y}),))
    
#     # plot normalized test data set and its prediction
#     plot_predicted, = plt.plot(predicted_Y, 'yx-', label='predicted')
#     plot_test, = plt.plot(test_Y, 'bx--', label='real')
# #     plot_predicted, = plt.plot(predicted_Y[1:], 'yx-', label='predicted')
# #     plot_test, = plt.plot(test_Y[:-1], 'bx--', label='real')
#     plt.legend([plot_predicted, plot_test],['predicted', 'real'])
#     plt.show()
        print(np.shape(predicted_Y))
        print(np.shape(test_Y))
        plot_surfaces(predicted_Y[:PLOT3D_SAMPLES], test_Y[:PLOT3D_SAMPLES])



if __name__ == '__main__':
    do_prediction()

