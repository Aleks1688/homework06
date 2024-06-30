import java.util.Objects;

public class Notebook {
    int ram;
    int hdd;
    String operSystem;
    String color;

    public Notebook(int ram, int hdd, String operSystem, String color) {
        this.ram = ram;
        this.hdd = hdd;
        this.operSystem = operSystem;
        this.color = color;
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    public String getOperSystem() {
        return operSystem;
    }

    public String getColor() {
        return color;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public void setOperSystem(String operSystem) {
        this.operSystem = operSystem;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String result = "RAM: " + ram + System.lineSeparator()
                + "HDD: " + hdd + System.lineSeparator()
                + "Operation System: " + operSystem + System.lineSeparator()
                + "Color: " + color + System.lineSeparator();

        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Notebook notebook = (Notebook) obj;

        return ram == notebook.ram && hdd == notebook.hdd
        && operSystem.equals(notebook.operSystem) && color.equals(notebook.color);
    }

    @Override
    public int hashCode(){
        return Objects.hash(ram, hdd, operSystem, color);
    }
}
