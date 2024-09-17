package org.fillouh.fh_mediaplayer.observers;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> observers=new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObserver(double currentTime){
        for(Observer obs:observers){
            obs.update(currentTime);
        }
    }

    public void notifyObserver(){
        for(Observer obs:observers){
            obs.update();
        }
    }
}

