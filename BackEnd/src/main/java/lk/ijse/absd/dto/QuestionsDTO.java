package lk.ijse.absd.dto;

public class QuestionsDTO {
    private int questionsId;
    private String description;
    private String userName;
    private String userEmail;
    private UserDTO userDTO;
    private QuestionsCatogoryDTO questionsCatogoryDTO;

    public QuestionsDTO() {
    }

    public QuestionsDTO(int questionsId, String description, String userName, String userEmail, UserDTO userDTO, QuestionsCatogoryDTO questionsCatogoryDTO) {
        this.setQuestionsId(questionsId);
        this.setDescription(description);
        this.setUserName(userName);
        this.setUserEmail(userEmail);
        this.setUserDTO(userDTO);
        this.setQuestionsCatogoryDTO(questionsCatogoryDTO);
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public QuestionsCatogoryDTO getQuestionsCatogoryDTO() {
        return questionsCatogoryDTO;
    }

    public void setQuestionsCatogoryDTO(QuestionsCatogoryDTO questionsCatogoryDTO) {
        this.questionsCatogoryDTO = questionsCatogoryDTO;
    }

    @Override
    public String toString() {
        return "QuestionsDTO{" +
                "questionsId=" + questionsId +
                ", description='" + description + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userDTO=" + userDTO +
                ", questionsCatogoryDTO=" + questionsCatogoryDTO +
                '}';
    }
}
