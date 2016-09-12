package edu.nku.csc364.bursar;

import java.util.*;

public class BursarOfficeJavaService {


    PriorityQueue<Student> q = new PriorityQueue<>((s1, s2) -> {
        if( s1.getGpa() > s2.getGpa() ) {
            return -1;
        } else if (s1.getGpa() == s2.getGpa()) {
            if (s1.getName().equals(s2.getName())) {
                return s1.getToken() - s2.getToken();
            } else {
                return s1.getName().compareTo(s2.getName());
            }
        }
        return 1;
    });

    public void receiveEvent(Event<Student> event) {
        if( event.getType() == EventType.NEW_REQUEST ) {
            q.offer(event.getData());
        } else {
            q.poll();
        }

    }

    public List<String> runReport() {
        if( q.isEmpty() ) {
            return Collections.singletonList("EMPTY");
        } else {
            List<String> list = new ArrayList<>();
            while (!q.isEmpty()) {
                list.add(q.poll().getName());
            }
            return list;
        }
    }
}
