package entity;

public enum Status {
    NEW("�����"), IN_PROGRESS("� ������"), PLANNED("�������������"), CLOSED("���������");

    private String translation;

    Status(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
}
