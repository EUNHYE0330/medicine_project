package me.dm7.barcodescanner.zxing.sample;

import android.os.Parcel;
import android.os.Parcelable;

public class Drug implements Parcelable {

    private String company;
    private String name;
    private String image;
    private String barcode;

    private String drugeffect;
    private String take;
    private String caution;
    private String withwarm;
    private String event;
    private String store;

    private int id;

    public String getCompany() { return company;   }
    public void setCompany(String company) { this.company = company;   }
    public String getName() { return name;   }
    public void setName(String name) { this.name = name;   }
    public String getImage() { return image;   }
    public void setImage(String image) { this.image = image;   }
    public String getBarcode() { return barcode;   }
    public void setBarcode(String barcode) { this.barcode = barcode;   }
    public int getId() { return id;   }
    public void setId(int id) { this.id = id;   }
    public String getDrugEffect() {
        return drugeffect;
    }
    public void setDrugEffect(String drugeffect) {
        this.drugeffect = drugeffect;
    }
    public String getTake() {
        return take;
    }
    public void setTake(String take) {
        this.take = take;
    }
    public String getCaution() {
        return caution;
    }
    public void setCaution(String caution) {
        this.caution = caution;
    }
    public String getWithWarm() {
        return withwarm;
    }
    public void setWithWarm(String withwarm) {
        this.withwarm = withwarm;
    }
    public String getEvent() {
        return event;
    }
    public void setEvent(String event) {
        this.event = event;
    }
    public String getStore() {
        return store;
    }
    public void setStore(String store) {
        this.store = store;
    }

    public Drug() {
        this.company = "EMPTY";
        this.name = "EMPTY";
        this.image = "EMPTY";
        this.barcode = "EMPTY";
        this.take = "EMPTY";
        this.caution = "EMPTY";
        this.withwarm = "EMPTY";
        this.event = "EMPTY";
        this.store = "EMPTY";
        this.drugeffect = "EMPTY";
    }

    public Drug(String company, String name, String image, String barcode) {
        this.company = company;
        this.name = name;
        this.image = image;
        this.barcode = barcode;
    }

    protected Drug(Parcel in) {
        company = in.readString();
        name = in.readString();
        image = in.readString();
        barcode = in.readString();
    }

    public static final Creator<Drug> CREATOR = new Creator<Drug>() {
        @Override
        public Drug createFromParcel(Parcel in) { return new Drug(in); }

        @Override
        public Drug[] newArray(int size) { return new Drug[size]; }
    };


    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(company);
        parcel.writeString(name);
        parcel.writeString(image);
        parcel.writeString(barcode);
    }
}
