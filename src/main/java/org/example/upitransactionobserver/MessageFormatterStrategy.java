package org.example.upitransactionobserver;
interface MessageFormatterStrategy {
    String formatMessage(String transactionId, String transactionStatus);
}

class MaharashtraMessageFormatter implements MessageFormatterStrategy {
    @Override
    public String formatMessage(String transactionId, String transactionStatus) {
        return "Maharashtra: Transaction ID: " + transactionId + ", Status: " + transactionStatus + ", Pin code: 400001";
    }
}

class UPMessageFormatter implements MessageFormatterStrategy {
    @Override
    public String formatMessage(String transactionId, String transactionStatus) {
        return "UP: Transaction ID: " + transactionId + ", Status: " + transactionStatus + ", Latitude: 26.8467, Longitude: 80.9462";
    }
}

// Similarly, create MessageFormatter classes for the remaining four states
