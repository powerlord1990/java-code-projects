package javacode.projects.core.task1;

import java.util.LinkedList;
import java.util.List;

public class CustomStringBuilder {
    private StringBuilder stringBuilder;
    private final List<Snapshot> history;

    public CustomStringBuilder() {
        this.stringBuilder = new StringBuilder();
        this.history = new LinkedList<>();
        saveSnapshot();
    }

    private void saveSnapshot(){
        history.add(new Snapshot(toString()));
    }

    public void append(String text){
        stringBuilder.append(text);
        saveSnapshot();
    }

    public void insert(int offset, String text){
        stringBuilder.insert(offset, text);
        saveSnapshot();
    }

    public void replace(int start, int end, String str) {
        stringBuilder.replace(start, end, str);
        saveSnapshot();
    }

    public void delete(int start, int end) {
        stringBuilder.delete(start, end);
        saveSnapshot();
    }

    public void reverse() {
        stringBuilder.reverse();
        saveSnapshot();
    }

    public String toString() {
        return stringBuilder.toString();
    }

    public void undo() {
        if (history.size() > 1) {
            history.remove(history.size() - 1);
            String previousState = history.get(history.size() - 1).getStage();
            stringBuilder = new StringBuilder(previousState);
        }
    }

}
