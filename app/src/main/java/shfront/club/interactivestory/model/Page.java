package shfront.club.interactivestory.model;


public class Page {
    private int xImageId;
    private String xText;
    private Choice xFirstChoice;
    private Choice xSecondChoice;
    private Boolean xIsFinal = false;

    public Boolean isFinal() {
        return xIsFinal;
    }

    public void setFinal(Boolean isFinal) {
        xIsFinal = isFinal;
    }

    public Page(int imageId, String text, Choice firstChoice, Choice secondChoice) {
        xImageId = imageId;
        xFirstChoice = firstChoice;
        xText = text;
        xSecondChoice = secondChoice;
    }
    public Page(int imageId, String text){
        xImageId = imageId;
        xText = text;
        xFirstChoice = null;
        xSecondChoice = null;
        xIsFinal = true;
    }
    public int getImageId() {
        return xImageId;
    }

    public void setImageId(int imageId) {
        xImageId = imageId;
    }

    public String getText() {
        return xText;
    }

    public void setText(String text) {
        xText = text;
    }

    public Choice getFirstChoice() {
        return xFirstChoice;
    }

    public void setFirstChoice(Choice firstChoice) {
        xFirstChoice = firstChoice;
    }

    public Choice getSecondChoice() {
        return xSecondChoice;
    }

    public void setSecondChoice(Choice secondChoice) {
        xSecondChoice = secondChoice;
    }
}
