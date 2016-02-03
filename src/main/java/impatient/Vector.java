package impatient;

public class Vector {

    public int x;
    public int y;
    public int z;

    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector vector = (Vector) o;

        return x == vector.x && y == vector.y && z == vector.z;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }

    public Vector add(Vector addend) {
        return new Vector(x + addend.x, y + addend.y, z + addend.z);
    }
}
