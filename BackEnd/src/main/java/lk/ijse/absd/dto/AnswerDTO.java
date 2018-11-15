package lk.ijse.absd.dto;

public class AnswerDTO {
    private int answerId;
    private String answerDescription;
    private QuestionsDTO questionsDTO;
    private String questionsCatogoryname;
    private String questionsBy;
    private String questionsDescription;
    private String answerBy;
    private UserDTO userDTO;
    private String status;

    public AnswerDTO() {
    }

    public AnswerDTO(int answerId, String answerDescription, QuestionsDTO questionsDTO, String questionsCatogoryname, String questionsBy, String questionsDescription, String answerBy, UserDTO userDTO, String status) {
        this.setAnswerId(answerId);
        this.setAnswerDescription(answerDescription);
        this.setQuestionsDTO(questionsDTO);
        this.setQuestionsCatogoryname(questionsCatogoryname);
        this.setQuestionsBy(questionsBy);
        this.setQuestionsDescription(questionsDescription);
        this.setAnswerBy(answerBy);
        this.setUserDTO(userDTO);
        this.setStatus(status);
    }


    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswerDescription() {
        return answerDescription;
    }

    public void setAnswerDescription(String answerDescription) {
        this.answerDescription = answerDescription;
    }

    public QuestionsDTO getQuestionsDTO() {
        return questionsDTO;
    }

    public void setQuestionsDTO(QuestionsDTO questionsDTO) {
        this.questionsDTO = questionsDTO;
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

    public String getAnswerBy() {
        return answerBy;
    }

    public void setAnswerBy(String answerBy) {
        this.answerBy = answerBy;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AnswerDTO{" +
                "answerId=" + answerId +
                ", answerDescription='" + answerDescription + '\'' +
                ", questionsDTO=" + questionsDTO +
                ", questionsCatogoryname='" + questionsCatogoryname + '\'' +
                ", questionsBy='" + questionsBy + '\'' +
                ", questionsDescription='" + questionsDescription + '\'' +
                ", answerBy='" + answerBy + '\'' +
                ", userDTO=" + userDTO +
                ", status='" + status + '\'' +
                '}';
    }
}

