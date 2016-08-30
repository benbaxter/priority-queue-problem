package edu.nku.csc364.bursar;


public class Event<T> {

    EventType type;
    T data;

    public Event(EventType type) {
        this(type, null);
    }

    public Event(EventType type, T data) {
        this.type = type;
        this.data = data;
    }

    public EventType getType() {
        return type;
    }

    public T getData() {
        return data;
    }
}
