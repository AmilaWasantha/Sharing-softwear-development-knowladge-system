package lk.ijse.absd.dto;

public class QuestionsCatogoryDTO {
    private String catogoryName;
    private String description;

    public QuestionsCatogoryDTO() {
    }

    public QuestionsCatogoryDTO(String catogoryName, String description) {
        this.setCatogoryName(catogoryName);
        this.setDescription(description);
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
        return "QuestionsCatogoryDTO{" +
                "catogoryName='" + catogoryName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
