package com.example.ma_orderfoodapp_n1;

import com.google.gson.annotations.SerializedName;

public class ResFoodTypeClass {

    @SerializedName("typeId")
    private int typeId;

    @SerializedName("typeName")
    private String typeName;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
