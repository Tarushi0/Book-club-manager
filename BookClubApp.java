import java.util.Scanner;

public class BookClubApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookClub bookClub = new BookClub();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a Member");
            System.out.println("2. Get Members Monthly Payment");
            System.out.println("3. List all Members (include their book choices)");
            System.out.println("4. Find a book choice for a particular member");
            System.out.println("5. Remove a Member");
            System.out.println("6. Get number of payments made (per Member)");
            System.out.println("7. Get total payments made (for the entire club)");
            System.out.println("8. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addMember(bookClub, scanner);
                    break;
                case 2:
                    getMembersMonthlyPayment(bookClub, scanner);
                    break;
                case 3:
                    listAllMembers(bookClub);
                    break;
                case 4:
                    findBookChoiceForMember(bookClub, scanner);
                    break;
                case 5:
                    removeMember(bookClub, scanner);
                    break;
                case 6:
                    getNumberOfPaymentsMade(bookClub, scanner);
                    break;
                case 7:
                    getTotalPaymentsMade(bookClub);
                    break;
                case 8:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }
        }
    }

    private static void addMember(BookClub bookClub, Scanner scanner) {
    System.out.print("Enter member name: ");
    String name = scanner.nextLine();
    System.out.print("Enter member address: ");
    String address = scanner.nextLine();
    System.out.print("Enter member phone: ");
    String phone = scanner.nextLine();

    Member newMember = new Member(name, address, phone, 12); 

    System.out.print("Does the member want to pay in full? (yes/no): ");
    String paymentChoice = scanner.nextLine().toLowerCase();

    if (paymentChoice.equals("yes")) {
        double fullPaymentAmount = 60.0;
        Payment fullPayment = new Payment(fullPaymentAmount);
        newMember.makePayment(fullPayment);
    }

    System.out.print("Enter the book title chosen by the member: ");
    String bookTitle = scanner.nextLine();
    System.out.print("Enter the book genre: ");
    String bookGenre = scanner.nextLine();
    System.out.print("Enter the book writer: ");
    String bookWriter = scanner.nextLine();

    Book chosenBook = new Book(bookTitle, bookGenre, bookWriter);
    bookClub.getBookList().add(chosenBook);

    if (bookClub.getMembersList().add(newMember)) {
        System.out.println("Member added successfully.");
    } else {
        System.out.println("Failed to add member. Club is full.");
    }
}


    private static void getMembersMonthlyPayment(BookClub bookClub, Scanner scanner) {
        System.out.print("Enter member name: ");
        String memberName = scanner.nextLine();
        Member member = searchMember(bookClub, memberName);

        if (member != null) {
            System.out.println("Member's Monthly Payments:");
            for (int i = 0; i < member.getPayments().getTotal(); i++) {
                member.getPayments().getPayment(i).print();
            }
        } else {
            System.out.println("Member not found.");
        }
    }

    private static void listAllMembers(BookClub bookClub) {
        System.out.println("All Members:");
        for (int i = 0; i < bookClub.getMembersList().getTotal(); i++) {
            Member member = bookClub.getMembersList().search(i);
            member.print();
            System.out.println("Books Chosen:");
            for (int j = 0; j < bookClub.getBookList().getTotal(); j++) {
                bookClub.getBookList().getBook(j).print();
            }
            System.out.println("------------------------");
        }
    }

    private static void findBookChoiceForMember(BookClub bookClub, Scanner scanner) {
        System.out.print("Enter member name: ");
        String memberName = scanner.nextLine();
        Member member = searchMember(bookClub, memberName);

        if (member != null) {
            System.out.println("Books Chosen by " + memberName + ":");
            for (int j = 0; j < bookClub.getBookList().getTotal(); j++) {
                bookClub.getBookList().getBook(j).print();
            }
        } else {
            System.out.println("Member not found.");
        }
    }

    private static void removeMember(BookClub bookClub, Scanner scanner) {
        System.out.print("Enter member name to remove: ");
        String memberName = scanner.nextLine();
        Member member = searchMember(bookClub, memberName);

        if (member != null) {
            if (bookClub.deleteMember(member)) {
                System.out.println("Member removed successfully.");
            } else {
                System.out.println("Failed to remove member.");
            }
        } else {
            System.out.println("Member not found.");
        }
    }

    private static void getNumberOfPaymentsMade(BookClub bookClub, Scanner scanner) {
        System.out.print("Enter member name: ");
        String memberName = scanner.nextLine();
        Member member = searchMember(bookClub, memberName);

        if (member != null) {
            System.out.println("Number of payments made by " + memberName + ": " + member.getPayments().getTotal());
        } else {
            System.out.println("Member not found.");
        }
    }

    private static void getTotalPaymentsMade(BookClub bookClub) {
        double totalPayments = 0;

        for (int i = 0; i < bookClub.getMembersList().getTotal(); i++) {
            totalPayments += bookClub.getMembersList().search(i).getPayments().calculateTotalPaid();
        }

        System.out.println("Total payments made by the entire club: " + totalPayments);
    }

private static Member searchMember(BookClub bookClub, String memberName) {
    for (int i = 0; i < bookClub.getMembersList().getTotal(); i++) {
        Member member = bookClub.getMembersList().search(i);
        if (member != null && member.getPerson().getName().equalsIgnoreCase(memberName)) {
            return member;
        }
    }
    return null;
}
}