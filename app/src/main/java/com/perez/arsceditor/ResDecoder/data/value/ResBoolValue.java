package com.perez.arsceditor.ResDecoder.data.value;

/**
 * @author Ryszard Wi?niewski <brut.alll@gmail.com>
 */
public class ResBoolValue extends ResScalarValue {
    private final boolean mValue;

    public ResBoolValue(boolean value, int rawIntValue, String rawValue) {
        super("bool", rawIntValue, rawValue);
        this.mValue = value;
    }

    @Override
    protected String encodeAsResValue() {
        return mValue ? "true" : "false";
    }

    public boolean getValue() {
        return mValue;
    }
}
