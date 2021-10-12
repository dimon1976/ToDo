package entity;

public enum Status {
    NEW("Новый"), IN_PROGRESS("В работе"), PLANNED("Запланировано"), CLOSED("Завершено");

    private String translation;

    Status(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
}
