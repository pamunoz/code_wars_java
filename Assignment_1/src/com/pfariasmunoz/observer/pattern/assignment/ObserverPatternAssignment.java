package com.pfariasmunoz.observer.pattern.assignment;

import java.util.*;

interface IObserver {
    void update(int value);    
}
interface ISubject {
    void register(IObserver o);
    void unregister(IObserver o);
    void notifyObserver(int value);
}
class Observer implements IObserver {
    private int id = 0;
    private String name = this.getClass().getSimpleName();

    public Observer() {
        id++;        
    }
    
    
    @Override
    public void update(int value) {
        System.out.println(name + ", with id: " + id + ": " +   "myValue in Subject is now: " + value);        
    }
    
}
class Subject implements ISubject {
    private int myValue;
    private List<IObserver> observerList = new ArrayList<>();

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
        notifyObserver(myValue);
    }

    @Override
    public void register(IObserver o) {
        observerList.add(o);
    }

    @Override
    public void unregister(IObserver o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObserver(int value) {
        for (IObserver observer : observerList) {
            observer.update(value);
        }
    }
       
}

public class ObserverPatternAssignment {
    
    Observer[] observers = new Observer[5];
    Subject[] subjects = new Subject[5];
    
    public static void main(String[] args) {
        
        ArrayList<Observer> observers = new ArrayList<>();
        ArrayList<Subject> subjects = new ArrayList<>();

        Observer ob1 = new Observer();
        Observer ob2 = new Observer();
        Observer ob3 = new Observer();
        Observer ob4 = new Observer();
        Observer ob5 = new Observer();
        
        Subject sb1 = new Subject();
        Subject sb2 = new Subject();
        Subject sb3 = new Subject();
        Subject sb4 = new Subject();
        Subject sb5 = new Subject(); 
        for (int i = 0; i < 6; i++) {
           
            Observer ob = new Observer();
            Subject sb = new Subject();
            observers.add(ob);
            subjects.add(sb);            
        }
        for (int i = 0; i < subjects.size(); i++) {
            Random generator = new Random();
            int temp = generator.nextInt(100);
            
            if (i % 2 == 0) {
                
                subjects.get(i).register(observers.get(i));
                subjects.get(i).setMyValue(temp);
            } 
            
        }
         
            
       
        
    }
    
}
