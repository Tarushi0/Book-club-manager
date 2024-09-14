public class BookList extends ObjectList {
    public BookList(int size) {
        super(size);
    }

    public Book getBook(int index) {
        return (Book) getObject(index);
    }
}
