package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("group")
public class GroupData {
@XStreamOmitField
private int id = Integer.MAX_VALUE;
    private String name;
    private String headr;
    private String footer;


    public String getName() {
        return name;
    }

    public String getHeadr() {
        return headr;
    }

    public String getFooter() {
        return footer;
    }
    public int getId() {
        return id;
    }

    public GroupData withId(int id) {
        this.id = id;
        return this;
    }
    public GroupData withName(String name) {
        this.name = name;
        return this;
    }

    public GroupData withHeader(String headr) {
        this.headr = headr;
        return this;
    }

    public GroupData withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupDate = (GroupData) o;

        if (id != groupDate.id) return false;
        return name != null ? name.equals(groupDate.name) : groupDate.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "GroupDate{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }



}
