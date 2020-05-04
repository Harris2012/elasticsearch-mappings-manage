package cn.savory.esmanage.codedom;

public class DataValue extends DataValueOrObject {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static DataValue fromBooleanValue(boolean value) {
        DataValue dataValue = new DataValue();
        dataValue.setValue(value ? "true" : "false");
        return dataValue;
    }

    public static DataValue fromIntValue(int value) {
        DataValue dataValue = new DataValue();
        dataValue.setValue(String.valueOf(value));
        return dataValue;
    }

    public static DataValue fromLongValue(long value) {
        DataValue dataValue = new DataValue();
        dataValue.setValue(String.valueOf(value));
        return dataValue;
    }

    public static DataValue fromStringValue(String value) {
        DataValue stringValue = new DataValue();
        stringValue.setValue("\"" + value + "\"");
        return stringValue;
    }


    public void setValue(boolean value) {
        this.value = value ? "true" : "false";
    }

    public void setValue(int value) {
        this.value = String.valueOf(value);
    }

    public void setValue(long value) {
        this.value = String.valueOf(value);
    }
}
