package com.xhj.user.entity;

import java.util.List;

public class Score {
    //A和B的所有好友数
    private int Union;
    //A和B的共同好友数
    private int Intersection;
    //A和B的共同好友列表
    private List<Integer> l;
    //此对象是A和B之间的关系
    private int A;
    private int B;
    //用户B的基本信息
    private UserDetailDisplay udd;
    //没加权重的得分
    private float score;
    //对每个共同好友加权重的得分
    private double wscore;
    
    //set和get方法
    public void setUdd(UserDetailDisplay udd){
    	this.udd=udd;
    }
    public UserDetailDisplay getUdd(){
    	return udd;
    }
    
    public double getWscore() {
        return wscore;
    }
    public void setWscore(double wscore) {
        this.wscore = wscore;
    }
    public float getScore() {
        return score;
    }
    public int getA() {
        return A;
    }
    public void setA(int a) {
        A = a;
    }
    public int getB() {
        return B;
    }
    public void setB(int b) {
        B = b;
    }
    public int getUnion() {
        return Union;
    }
    public void setUnion(int union) {
        Union = union;
    }
    public int getIntersection() {
        return Intersection;
    }
    public void setIntersection(int intersection) {
        Intersection = intersection;
        if(Union!=0){
            score=(float) Intersection/Union*100;
        }
    }
    public List getL() {
        return l;
    }
    public void setL(List l) {
        this.l = l;
    }
    @Override
    public String toString() {
        return "Score{" +
                "Union=" + Union +
                ", Intersection=" + Intersection +
                ", l=" + l +
                ", A=" + A +
                ", B=" + B +
                ", score=" + score +
                ", wscore="+wscore+
                '}';
    }
}
