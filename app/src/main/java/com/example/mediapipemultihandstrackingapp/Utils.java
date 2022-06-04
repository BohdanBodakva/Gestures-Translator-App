package com.example.mediapipemultihandstrackingapp;

import com.google.common.collect.ImmutableList;
import com.google.mediapipe.formats.proto.LandmarkProto;

import java.util.LinkedList;
import java.util.List;

public abstract class Utils {
    public List<ImmutableList<Double>> calcLandmarkList(double imageWidth, double imageHeight, LandmarkProto.NormalizedLandmarkList landmarks){
        List<ImmutableList<Double>> res = new LinkedList<>();
        for (LandmarkProto.NormalizedLandmark landmark: landmarks.getLandmarkList()){
            res.add(ImmutableList.of(landmark.getX() * imageWidth, landmark.getY() * imageHeight));
        }
        return res;
    }

    public List<Double> calcBoundingRect(float imageWidth, float imageHeight, LandmarkProto.NormalizedLandmarkList landmarks){
        List<ImmutableList<Double>> points = calcLandmarkList(imageWidth, imageHeight, landmarks);
        List<Double> res = new LinkedList<>();
        res.add(Double.valueOf(imageWidth));
        res.add(Double.valueOf(imageHeight));
        res.add(Double.valueOf(0));
        res.add(Double.valueOf(0));
        for (List<Double> point: points){
            res.set(0, Math.min(res.get(0), point.get(0)));
            res.set(1, Math.min(res.get(1), point.get(1)));
            res.set(2, Math.max(res.get(2), point.get(0)));
            res.set(3, Math.max(res.get(3), point.get(1)));
        }
        return res;
    }

    public List<ImmutableList<Double>> preprocessLandmark(List<ImmutableList<Double>> landmarkList){
        double baseX = landmarkList.get(0).get(0);
        double baseY = landmarkList.get(0).get(1);
        double max = 0;
        List<ImmutableList<Double>> tmpList = new LinkedList<>();
        for (int i=0; i<landmarkList.size(); i++){
            tmpList.add(ImmutableList.of(landmarkList.get(i).get(0)-baseX, landmarkList.get(i).get(1)-baseY));
            max = Math.max(max, Math.max(tmpList.get(i).get(0), tmpList.get(i).get(1)));
        }
        for (int i=0; i<tmpList.size(); i++){
            tmpList.set(i, ImmutableList.of(tmpList.get(i).get(0)/max, tmpList.get(i).get(1)/max));
        }
        return tmpList;
    }
}
