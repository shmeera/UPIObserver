Collection of UPI Transactions: You are given the task of collecting UPI
transactions for 6 states. How will you design the application?
Requirements
● You will receive the UPI transaction message with you in real time.
● Once the message is received, you need to send a confirmation message
containing the details in a state specific format to each state.
● For Example: Maharashtra might require the pin code from where the UPI
transaction happened, whereas UP might require the Latitude and Longitude
of the area from which the transaction happened.
● Each state's confirmation message will be in a different format but the
sending mechanism is the same.

Solution:
1) Create a UPI transaction interface
    a) contains method for register, unregister and notify
2) Create the ConcreteUPI transaction class
    a) contains state data for transaction details (hard coded values)
    b) Keeps list of All observers(arrayList)
    c) Passes state data to update in the observer in notifyAll
    d) include a method to trigger notifications (data changed)
3) Create the Observer interface
    a) should only include update method (with state data as parameters)
    b) no need for any observers to talk to subject
4) Create the ConcreteObserver classes
    a) six classes that display the UPI transaction details for each state
5) Create the client to simulate some UPI transaction data
    a)create the observer objects and register them with the subject
    b) trigger changes in the subject which will cause all observers to be notified
    c) remove an observer and then re-trigger to see if that observer is no longer notified
6) Create the MessageFormatterStrategy interface
7) Create the ConcreteMessageFormatter classes
    a) six classes that format the UPI transaction details for each state
8) Create the client to simulate some UPI transaction data
    a)create the observer objects and register them with the subject
    b) trigger changes in the subject which will cause all observers to be notified
    c) remove an observer and then re-trigger to see if that observer is no longer notified

### Code work flow
The code workflow is designed around the Observer design pattern, which allows objects to observe and react to events happening in other objects. Here's how it works:

1. The `UPI` class is the subject that maintains a list of observers and notifies them when a transaction changes. It has methods to register and remove observers, and a method to notify all registered observers when a transaction changes.

2. The `Observer` interface defines the `update` method that all observers must implement. This method is called when the `UPI` class notifies the observers of a transaction change.

3. The `MaharashtraObserver` and `UPObserver` classes are concrete observers that implement the `Observer` interface. They each have a `MessageFormatterStrategy` object that they use to format the transaction details in a state-specific way.

4. The `MessageFormatterStrategy` interface defines the `formatMessage` method that all message formatters must implement. This method is used to format the transaction details in a state-specific way.

5. The `MaharashtraMessageFormatter` and `UPMessageFormatter` classes are concrete message formatters that implement the `MessageFormatterStrategy` interface. They each provide a state-specific implementation of the `formatMessage` method.

6. The `Client` class creates a `UPI` object and registers a `MaharashtraObserver` and a `UPObserver` with it. It then triggers a transaction change in the `UPI` object, which causes the `UPI` object to notify all registered observers. The observers then use their `MessageFormatterStrategy` objects to format the transaction details and print them out. The `Client` class then removes the `MaharashtraObserver` from the `UPI` object and triggers another transaction change to demonstrate that the `MaharashtraObserver` is no longer notified of transaction changes.

This design allows the application to send a confirmation message containing the transaction details in a state-specific format to each state when a UPI transaction message is received in real time. Each state's confirmation message can be in a different format, but the sending mechanism is the same.

MessageReceived
UPI (Subject)
transactionId
transactionStaus (FAIL, SUCCESS)

when success notify states
subscriber
transactionTime


UPI - transaction happened - messageReceived UPI - st1 st2 st3 -