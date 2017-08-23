package com.javarush.task.task23.task2304;

import java.util.List;
import java.util.Map;

/*
Inner 3
*/
//public class Solution {
//
//    private List<Task> tasks;
//    private List<String> names;
//
//    private DbDataProvider taskDataProvider = new TaskDataProvider();
//    private DbDataProvider nameDataProvider = new NameDataProvider();
//
//    public void refresh() {
//        Map taskCriteria = ViewMock.getFakeTasksCriteria();
//        taskDataProvider.refreshAllData(taskCriteria);
//
//        Map nameCriteria = ViewMock.getFakeNamesCriteria();
//        nameDataProvider.refreshAllData(nameCriteria);
//    }
//
//    private interface DbDataProvider<T> {
//        void refreshAllData(Map criteria);
//    }
//
//    class Task {
//    }
//
//    public static void main(String[] args) {
//
//    }
//}

public class Solution {

    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    public void refresh() {
        Map taskCriteria = ViewMock.getFakeTasksCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = ViewMock.getFakeNamesCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    class Task {
    }



    private class TaskDataProvider implements DbDataProvider<Task>{
        @Override
        public void refreshAllData(Map criteria) {
            tasks = DbMock.getFakeTasks(criteria);
        }
    }

    private class NameDataProvider implements DbDataProvider<String>{
        @Override
        public void refreshAllData(Map criteria) {
            names = DbMock.getFakeNames(criteria);
        }
    }

    public static void main(String[] args) {

    }

}