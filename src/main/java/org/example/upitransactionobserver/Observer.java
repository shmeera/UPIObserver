package org.example.upitransactionobserver;

 interface Observer {
//     Create the Observer interface
//     a) should only include update method (with state data as parameters)
//     b) no need for any observers to talk to subject

        public void update(String transactionId, String transactionStatus);
}

class MaharashtraObserver implements Observer {
    private MessageFormatterStrategy formatter;

    public MaharashtraObserver(MessageFormatterStrategy formatter) {
        this.formatter = formatter;
    }

    @Override
    public void update(String transactionId, String transactionStatus) {
        String message = formatter.formatMessage(transactionId, transactionStatus);
        System.out.println(message);
    }
}

class UPObserver implements Observer {
    private MessageFormatterStrategy formatter;

    public UPObserver(MessageFormatterStrategy formatter) {
        this.formatter = formatter;
    }

    @Override
    public void update(String transactionId, String transactionStatus) {
        String message = formatter.formatMessage(transactionId, transactionStatus);
        System.out.println(message);
    }
}

// Similarly, modify the remaining four Observer classes