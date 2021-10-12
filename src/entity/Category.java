package entity;

public class Category {
    private String nameCategory;
    private int userId;

    public Category(String nameCategory, int userId) {
        this.nameCategory = nameCategory;
        this.userId = userId;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
