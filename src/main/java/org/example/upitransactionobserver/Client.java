package org.example.upitransactionobserver;

public class Client {
    public static void main(String[] args) {
        // create a UPI object
        UPI upi = new UPI();

        // create a MaharashtraObserver object
        MaharashtraObserver maharashtraObserver = new MaharashtraObserver(new MaharashtraMessageFormatter());

        // register the MaharashtraObserver
        upi.registerObserver(maharashtraObserver);

        // register all other state observers
        upi.registerObserver(new UPObserver(new UPMessageFormatter()));
        // Register the remaining four state observers...

        // in real app you would have some logic to call this function when a transaction message is received in real time
        upi.transactionChanged();

        // remove the MaharashtraObserver
        upi.removeObserver(maharashtraObserver);

        // now only remaining observers get the notification
        upi.transactionChanged();
    }
}