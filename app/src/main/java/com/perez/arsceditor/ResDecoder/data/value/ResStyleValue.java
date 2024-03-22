package com.perez.arsceditor.ResDecoder.data.value;

import java.io.IOException;

import com.perez.arsceditor.ResDecoder.ARSCCallBack;
import com.perez.arsceditor.ResDecoder.GetResValues;
import com.perez.arsceditor.ResDecoder.IO.Duo;
import com.perez.arsceditor.ResDecoder.data.ResResource;

/**
 * @author Ryszard Wi?niewski <brut.alll@gmail.com>
 */
public class ResStyleValue extends ResBagValue implements GetResValues {
    private final Duo<ResReferenceValue, ResScalarValue>[] mItems;

    @SuppressWarnings("unchecked")
    ResStyleValue(ResReferenceValue parent, Duo<Integer, ResScalarValue>[] items, ResValueFactory factory) {
        super(parent);
        mItems = new Duo[items.length];
        for(int i = 0; i < items.length; i++) {
            mItems[i] = new Duo<ResReferenceValue, ResScalarValue>(factory.newReference(items[i].m1, null),
                    items[i].m2);
        }
    }

    @Override
    public void getResValues(ARSCCallBack back, ResResource res) throws IOException {
        for(int i = 0; i < mItems.length; i++) {
            Duo<ResReferenceValue, ResScalarValue> item = mItems[i];
            back.back(res.getConfig().toString(), res.getResSpec().getType().getName(), res.getResSpec().getName(),
                      item.m2.encodeResValue());
        }
    }
}
