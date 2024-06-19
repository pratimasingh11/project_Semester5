package project_Semester5;
import java.sql.*;

import java.util.ArrayList;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseOperation {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/library";
    private static final String USER = "root"; // Your database username
    private static final String PASS = "*PR@tiM@*25^"; // Your database password

    // Method to write student data to the database
    public static void writeStudentData(Student student) {
        String sql = "INSERT INTO students (first_name, last_name, gender, program, section) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getFirstName());
            pstmt.setString(2, student.getLastName());
            pstmt.setString(3, student.getGender());
            pstmt.setString(4, student.getProgram());
            pstmt.setString(5, student.getSection());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to read student data from the database
    public static ArrayList<Student> readStudent() {
        ArrayList<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Student student = new Student(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("gender"),
                        rs.getString("program"),
                        rs.getString("section")
                );
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    // Method to write book data to the database
    public static void writeBookData(Book book) {
        String sql = "INSERT INTO books (author_name, title, publication_name, subject) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getAuthorName());
            pstmt.setString(2, book.getTitle());
            pstmt.setString(3, book.getPublicationName());
            pstmt.setString(4, book.getSubject());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to read book data from the database
    public static ArrayList<Book> readBook() {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Book book = new Book(
                        rs.getString("author_name"),
                        rs.getString("title"),
                        rs.getString("publication_name"),
                        rs.getString("subject")
                );
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    // Method to write book issue data to the database
    public static void writeBookIssued(BookIssue bookIssue) {
        String sql = "INSERT INTO book_issues (student_id, book_id, issue_date, due_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, bookIssue.getStudentId());
            pstmt.setInt(2, bookIssue.getBookId());
            pstmt.setString(3, bookIssue.getIssueDate());
            pstmt.setString(4, bookIssue.getDueDate());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to read book issue data from the database
    public static ArrayList<BookIssue> readBookIssue() {
        ArrayList<BookIssue> bookIssues = new ArrayList<>();
        String sql = "SELECT * FROM book_issues";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                BookIssue bookIssue = new BookIssue(
                        rs.getInt("student_id"),
                        rs.getInt("book_id"),
                        rs.getString("issue_date"),
                        rs.getString("due_date")
                );
                bookIssues.add(bookIssue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookIssues;
    }

	public static int getStudentIdByName(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int getBookIdByTitle(String bookTitle) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static Book getBookById(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}
}
