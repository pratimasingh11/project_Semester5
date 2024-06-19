package project_Semester5;

public class Book {
    private String authorName;
    private String title;
    private String publicationName;
    private String subject;

    public Book(String authorName, String title, String publicationName, String subject) {
        this.authorName = authorName;
        this.title = title;
        this.publicationName = publicationName;
        this.subject = subject;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublicationName() {
        return publicationName;
    }

    public void setPublicationName(String publicationName) {
        this.publicationName = publicationName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}


