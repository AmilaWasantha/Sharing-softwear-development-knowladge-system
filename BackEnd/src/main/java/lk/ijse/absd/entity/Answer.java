package lk.ijse.absd.entity;

import javax.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int answerId;

    @JoinColumn(name = "questionsId", referencedColumnName = "questionsId")
    @ManyToOne(optional = false)
    private Questions questions;

    private String questionsCatogoryname;

    private String questionsBy;

    @Column(length = 1000000)
    private String questionsDescription;

    @JoinColumn(name = "answerUserNic", referencedColumnName = "nic")
    @ManyToOne(optional = false)
    private User user;

    private String answerBy;

    @Column(length = 1000000)
    private String answerDescription;


    private String status;

    public Answer() {
    }

    public Answer(Questions questions, String questionsCatogoryname, String questionsBy, String questionsDescription, User user, String answerBy, String answerDescription, String status) {
        this.setQuestions(questions);
        this.setQuestionsCatogoryname(questionsCatogoryname);
        this.setQuestionsBy(questionsBy);
        this.setQuestionsDescription(questionsDescription);
        this.setUser(user);
        this.setAnswerBy(answerBy);
        this.setAnswerDescription(answerDescription);
        this.setStatus(status);
    }


    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    public String getQuestionsCatogoryname() {
        return questionsCatogoryname;
    }

    public void setQuestionsCatogoryname(String questionsCatogoryname) {
        this.questionsCatogoryname = questionsCatogoryname;
    }

    public String getQuestionsBy() {
        return questionsBy;
    }

    public void setQuestionsBy(String questionsBy) {
        this.questionsBy = questionsBy;
    }

    public String getQuestionsDescription() {
        return questionsDescription;
    }

    public void setQuestionsDescription(String questionsDescription) {
        this.questionsDescription = questionsDescription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAnswerBy() {
        return answerBy;
    }

    public void setAnswerBy(String answerBy) {
        this.answerBy = answerBy;
    }

    public String getAnswerDescription() {
        return answerDescription;
    }

    public void setAnswerDescription(String answerDescription) {
        this.answerDescription = answerDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", questions=" + questions +
                ", questionsCatogoryname='" + questionsCatogoryname + '\'' +
                ", questionsBy='" + questionsBy + '\'' +
                ", questionsDescription='" + questionsDescription + '\'' +
                ", user=" + user +
                ", answerBy='" + answerBy + '\'' +
                ", answerDescription='" + answerDescription + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
