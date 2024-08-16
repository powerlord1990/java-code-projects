package javacode.projects.task1;


public class Main {
    public static void main(String[] args) {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder();
        customStringBuilder.append("This");
        System.out.println(customStringBuilder);
        customStringBuilder.insert(5, " is");
        customStringBuilder.append(" my custom StringBuilder");
        System.out.println(customStringBuilder);
        customStringBuilder.undo();
        System.out.println(customStringBuilder);
        customStringBuilder.reverse();
        System.out.println(customStringBuilder);
        customStringBuilder.undo();
        System.out.println(customStringBuilder);
    }
}
