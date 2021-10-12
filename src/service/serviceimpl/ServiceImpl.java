package service.serviceimpl;

public interface ServiceImpl {
    void addTask(int userId);
    void removeTask(int userId);
    void editTask(int userId);
    void printTask(int userId);
    void printTaskId(int userId);
    void printTaskStatus(int userId);
    void editTaskStatus(int userId);
    void selectTaskCategory(int userId);
}
