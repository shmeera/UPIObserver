package org.example.upitransactionobserver;

import java.util.ArrayList;

interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}
/*Create the ConcreteUPI transaction class
a) contains state data for transaction details (hard coded values)
b) Keeps list of All observers(arrayList)
c) Passes state data to update in the observer in notifyAll
d) include a method to trigger notifications (data changed)
*/
class UPI implements Subject {
    private String transactionId;
    private String transactionStatus;
  //list of Observer
    private ArrayList<Observer> observers;
    public UPI() {
        observers = new ArrayList<Observer>();
    }
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(transactionId, transactionStatus);
        }
    }
    public void transactionChanged() {
        transactionId = "123456";
        transactionStatus = "Success";
        notifyObservers();
    }
//
//    public void registerStateObservers() {
//        registerObserver(new MaharashtraObserver(new MaharashtraMessageFormatter()));
//        registerObserver(new UPObserver(new UPMessageFormatter()));
//        // Register the remaining four state observers...
//    }
}



