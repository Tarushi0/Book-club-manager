public class BookClub {
    private MemberList members;
    private BookList books;
    private int year;

    public BookClub() {
        this.members = new MemberList(5); 
        this.books = new BookList(100);
        this.year = 2023;
    }

    public MemberList getMembersList() {
        return members;
    }

    public BookList getBookList() {
        return books;
    }

    public int getTotalMembers() {
        return members.getTotal();
    }

    public boolean deleteMember(Member member) {
        int index = -1;
        for (int i = 0; i < members.getTotal(); i++) {
            if (members.search(i) == member) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            members.remove(index);
            return true;
        }

        return false;
    }

    public String toString() {
        return "Year: " + year + ", Total Members: " + getTotalMembers();
    }

    public void print() {
        System.out.println(toString());
    }
}
