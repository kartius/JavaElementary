package lesson14.hotel.dataModel;

import java.util.Objects;

public class Bucket {
    private char bucket;

    public char getBucket() {
        return bucket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bucket bucket1 = (Bucket) o;
        return bucket == bucket1.bucket;
    }

    @Override
    public int hashCode() {

        return Objects.hash(bucket);
    }
}
