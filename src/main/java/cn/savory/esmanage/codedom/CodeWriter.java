package cn.savory.esmanage.codedom;

public class CodeWriter {

    private final StringBuffer stringBuffer;

    public CodeWriter(StringBuffer stringBuffer) {
        this.stringBuffer = stringBuffer;
    }


    public CodeWriter write(String value) {
        stringBuffer.append(value);
        return this;
    }

    public CodeWriter writeLine(String value) {
        stringBuffer.append(value);
        stringBuffer.append("\n");
        return this;
    }

    public CodeWriter writeLine() {
        stringBuffer.append("\n");
        return this;
    }

}
