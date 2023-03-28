package Homework;


public class Article extends Document {

    private int articleNumber;
    private StringBuffer partOf = new StringBuffer(100);

    public Article(int id, String title, String location, int articleNumber, String partOf) {
        this.setId(id);
        this.setTitle(title);
        this.setLocation(location);
        this.articleNumber = articleNumber;
        this.partOf.replace(0,100,partOf);
    }

    public int getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(int articleNumber) {
        this.articleNumber = articleNumber;
    }

    public StringBuffer getPartOf() {
        return partOf;
    }

    public void setPartOf(StringBuffer partOf) {
        this.partOf = partOf;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + getId() +
                ", title=" + getTitle() +
                ", location=" + getLocation() +
                ", tags=" + getTags() +
                ", articleNumber=" + articleNumber +
                ", partOf" + partOf +
                '}';
    }
    @Override
    public String getType() {
        return "Article";
    }
}
