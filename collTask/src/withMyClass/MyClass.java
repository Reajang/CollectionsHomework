package withMyClass;

import java.util.Objects;

public class MyClass {
    private String string;
    private Integer count = 1;

    public MyClass(String string) {
        this.string = string;
    }

    public MyClass(String string, Integer count) {
        this.string = string;
        this.count = count;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyClass myClass = (MyClass) o;
        return string.equals(myClass.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string);
    }

    @Override
    public String toString() {
        return string + " count = " + count;
    }
}
