package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @Size(min = 3, max = 100)
    @NotBlank
    private String location;

    // 3.1 Within Employer, add a private property jobs of type List<Job> and initialize it to an empty ArrayList
    //3.2 Use the @OneToMany and @JoinColumn annotations on the jobs list in Employer to declare the relationship between data tables.
    // Recall that this annotation needs a name parameter.

    @OneToMany(mappedBy = "employer")
    @JoinColumn(name="employer_id")
    private final List<Job> jobs = new ArrayList<>();

    public Employer(String location) {
        this.location = location;
    }

    public Employer() {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }
}
