package cn.savory.esmanage.codedom;

public class GenerateOptions {
    public String tabString = "    ";

    private int indentSize = 0;

    public String indentString = "";

    public String getTabString() {
        return tabString;
    }

    public void setTabString(String tabString) {
        this.tabString = tabString;
    }

    public int getIndentSize() {
        return indentSize;
    }

    public void setIndentSize(int indentSize) {
        this.indentSize = indentSize;
        buildIndentString();
    }


    public String getIndentString() {
        return indentString;
    }

    /// <summary>
    /// 增加缩进
    /// </summary>
    public void pushIndent() {
        this.indentSize = this.indentSize + 1;

        buildIndentString();
    }

    /// <summary>
    /// 减少缩进
    /// </summary>
    public void popIndent() {
        if (this.indentSize > 0) {
            this.indentSize = this.indentSize - 1;
        }

        buildIndentString();
    }

    /// <summary>
    /// 构建缩进
    /// </summary>
    /// <returns></returns>
    private void buildIndentString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.indentSize; i++) {
            builder.append(this.tabString);
        }
        this.indentString = builder.toString();
    }
}
