package shfront.club.interactivestory.model;


public class Choice {
    private String xText;
    private int xNextPage;
    public Choice(String text, int nextPage) {
        xNextPage = nextPage;
        xText = text;
    }

    public String getText() {
        return xText;
    }

    public void setText(String text) {
        xText = text;
    }

    public int getNextPage() {
        return xNextPage;
    }

    public void setNextPage(int nextPage) {
        xNextPage = nextPage;
    }
}
