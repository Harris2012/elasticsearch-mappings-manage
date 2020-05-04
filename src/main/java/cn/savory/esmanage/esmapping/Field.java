package cn.savory.esmanage.esmapping;

public class Field {

    private String fieldName;

    private String fieldType;

    private Integer ignoreAbove;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public Integer getIgnoreAbove() {
        return ignoreAbove;
    }

    public void setIgnoreAbove(Integer ignoreAbove) {
        this.ignoreAbove = ignoreAbove;
    }
}
