package com.pfariasmunoz.observer.pattern.demo;

import java.util.ArrayList;
import java.util.List;



interface ISubject {
    
    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers();
    
}

//==========================================================================

class Observer {
    
    public void update() {
        System.out.println("flag value changed in Subject");
    }
    
}
//=========================================================================

class Subject implements ISubject {
    
    List<Observer> observerList = new ArrayList<Observer>();
    private int _flag;
    public int getFlag() {
        return _flag;
    }
    public void setFlag(int _flag) {
        this._flag = _flag; // flag value changed. So notify observers(s)
        notifyObservers();
    }

    @Override
    public void register(Observer o) {
        observerList.add(o);
    }

    @Override
    public void unregister(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observerList.size(); i++) {
            observerList.get(i).update();    
        }
    }
    
}

//=========================================================================
class ObserverPatternEx {
    
    public static void main(String[] args) {
        
        System.out.println("***Observer Pattern Demo***\n");
        
        Observer o1 = new Observer();
        Subject sub1 = new Subject();
        sub1.register(o1);
        System.out.println("Setting Flag = 5");
        sub1.setFlag(5);
        System.out.println("Setting Flag = 25");
        sub1.setFlag(25);
        sub1.unregister(o1);
        // No notification this time to o1. Since it is unregistered.
        System.out.println("Setting Flag = 50");
        sub1.setFlag(50);
    }
    
}
