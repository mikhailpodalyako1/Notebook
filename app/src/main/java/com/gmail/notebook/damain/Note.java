package com.gmail.notebook.damain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.StringRes;

public class Note implements Parcelable {
    @StringRes
    private int name;
    @StringRes
    private int description;
    @StringRes
    private int date;

    public Note(int name, int description, int date) {
        this.name = name;
        this.description = description;
        this.date = date;
    }

    protected Note(Parcel in) {
        name = in.readInt();
        description = in.readInt();
        date = in.readInt();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public int getName() {
        return name;
    }

    public int getDescription() {
        return description;
    }

    public int getDate() {
        return date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(name);
        dest.writeInt(description);
        dest.writeInt(date);
    }
}
