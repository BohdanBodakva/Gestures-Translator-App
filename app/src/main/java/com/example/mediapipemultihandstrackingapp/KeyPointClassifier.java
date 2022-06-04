package com.example.mediapipemultihandstrackingapp;

import com.google.common.collect.ImmutableList;

import org.tensorflow.lite.Interpreter;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class KeyPointClassifier {
    private final String MODEL_PATH = "model/keypoint_classifier/keypoint_classifier.tflite";
    private final Interpreter interpreter;
    private final int inputIndex;
    private final int outputIndex;

    public Interpreter getInterpreter(){
        return this.interpreter;
    }

    public int getInputIndex() {
        return this.inputIndex;
    }

    public int getOutputIndex() {
        return this.outputIndex;
    }

    public String getMODEL_PATH() {
        return this.MODEL_PATH;
    }

    public KeyPointClassifier(String modelPath){
        this.interpreter = new Interpreter(new File(MODEL_PATH));
        this.interpreter.allocateTensors();
        this.inputIndex = this.interpreter.getInputIndex("index");
        this.outputIndex = this.interpreter.getOutputIndex("index");
    }

    public int call(List<ImmutableList<Double>> landmarkList){
        List<Double> res = new LinkedList<>();
        this.interpreter.run(landmarkList, res);
        int mxInd = 0;
        for (int i=1; i<res.size(); i++){
            if (res.get(i) > res.get(mxInd)){
                mxInd = i;
            }
        }
        return mxInd;
    }
}
