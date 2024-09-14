public class Book {
    private String title;
    private String genre;
    private String writer;

    public Book(String title, String genre, String writer) {
        this.title = title;
        this.genre = genre;
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getWriter() {
        return writer;
    }

    public String toString() {
        return "Title: " + title + ", Genre: " + genre + ", Writer: " + writer;
    }

    public void print() {
        System.out.println(toString());
    }
}
