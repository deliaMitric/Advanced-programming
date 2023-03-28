package Homework;

public class Book extends Document{
    private int numberOfChapters;

    public Book(int id, String title, String location, int numberOfChapters) {
        this.setId(id);
        this.setTitle(title);
        this.setLocation(location);
        this.numberOfChapters = numberOfChapters;
    }

    public int getNumberOfChapters() {
        return numberOfChapters;
    }

    public void setNumberOfChapters(int numberOfChapters) {
        this.numberOfChapters = numberOfChapters;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + getId() +
                ", title=" + getTitle() +
                ", location=" + getLocation() +
                ", tags=" + getTags() +
                ", articleNumber=" + numberOfChapters +
                '}';
    }
    @Override
    public String getType() {
        return "Book";
    }
}
