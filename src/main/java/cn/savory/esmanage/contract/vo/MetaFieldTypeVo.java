package cn.savory.esmanage.contract.vo;

public class MetaFieldTypeVo {

    private String name;

    private String remark;

    public MetaFieldTypeVo() {

    }

    public MetaFieldTypeVo(String name, String remark) {
        this.name = name;
        this.remark = remark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
