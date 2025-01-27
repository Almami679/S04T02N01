package cat.itacademy.s04.t02.n01.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fruits")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    private String name;
    
    private int quantityKg;

    protected Fruit() {
    }

    public Fruit(String name, int quantityKg) {
        this.name = name;
        this.quantityKg = quantityKg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantityKg(int quantityKg) {
        this.quantityKg = quantityKg;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantityKg() {
        return quantityKg;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantityKg=" + quantityKg +
                '}';
    }
}
