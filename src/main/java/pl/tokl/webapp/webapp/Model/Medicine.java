package pl.tokl.webapp.webapp.Model;

import javax.persistence.*;

@Entity
@Table(name = "Medicines")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String substance;
    private String dose;
    private int units;
    private int packages;

    public Medicine(Long id, String name, String substance, String dose, int units, int packages) {
        this.id = id;
        this.name = name;
        this.substance = substance;
        this.dose = dose;
        this.units = units;
        this.packages = packages;
    }

    public Medicine() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubstance() {
        return substance;
    }

    public String getDose() {
        return dose;
    }

    public int getUnits() {
        return units;
    }

    public int getPackages() {
        return packages;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubstance(String substance) {
        this.substance = substance;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public void setPackages(int packages) {
        this.packages = packages;
    }
}
