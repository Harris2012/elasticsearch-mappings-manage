package cn.savory.esmanage.codedom;

import com.google.common.collect.Lists;

import java.util.List;

public class DataArray {
    public List<DataValueOrObject> items;

    public List<DataValueOrObject> getItems() {
        return items;
    }

    public void setItems(List<DataValueOrObject> items) {
        this.items = items;
    }

    public DataArray addDataValue(DataValue dataValue) {
        if (this.items == null) {
            this.items = Lists.newArrayList();
        }
        this.items.add(dataValue);
        return this;
    }

    public DataArray addDataObject(DataObject dataObject) {
        if (this.items == null) {
            this.items = Lists.newArrayList();
        }
        this.items.add(dataObject);
        return this;
    }

    public DataObject addDataObject() {
        if (this.items == null) {
            this.items = Lists.newArrayList();
        }
        DataObject dataObject = new DataObject();
        this.items.add(dataObject);
        return dataObject;
    }
}
