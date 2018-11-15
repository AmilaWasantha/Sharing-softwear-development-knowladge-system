package lk.ijse.absd.entity;

import javax.persistence.*;

@Entity
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionsId;
    @Column(length = 1000000)
    private String description;
    private String userName;
    private String userEmail;
    @ManyToOne(optional = false)
    private User user;
    @ManyToOne(optional = false)
    private QuestionsCatogory questionsCatogory;

    public Questions() {
    }

    public Questions(String description, String userName, String userEmail, User user, QuestionsCatogory questionsCatogory) {
        this.setDescription(description);
        this.setUserName(userName);
        this.setUserEmail(userEmail);
        this.setUser(user);
        this.setQuestionsCatogory(questionsCatogory);
    }

    public int getQuestionsId() {
        return questionsId;
    }

    public void setQuestionsId(int questionsId) {
        this.questionsId = questionsId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public QuestionsCatogory getQuestionsCatogory() {
        return questionsCatogory;
    }

    public void setQuestionsCatogory(QuestionsCatogory questionsCatogory) {
        this.questionsCatogory = questionsCatogory;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "questionsId=" + questionsId +
                ", description='" + description + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", user=" + user +
                ", questionsCatogory=" + questionsCatogory +
                '}';
    }
}
