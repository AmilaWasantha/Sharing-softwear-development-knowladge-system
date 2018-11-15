package lk.ijse.absd.entity;

import org.hibernate.annotations.Columns;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class QuestionsCatogory {
    @Id
    private String catogoryName;
    @Column(length = 1000000)
    private String description;

    public QuestionsCatogory() {
    }

    public QuestionsCatogory(String catogoryName, String description) {
        this.setCatogoryName(catogoryName);
        this.setDescription(description);
    }

    public QuestionsCatogory(String catogoryName) {
        this.setCatogoryName(catogoryName);
    }


    public String getCatogoryName() {
        return catogoryName;
    }

    public void setCatogoryName(String catogoryName) {
        this.catogoryName = catogoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "QuestionsCatogory{" +
                "catogoryName='" + catogoryName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
