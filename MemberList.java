public class MemberList extends ObjectList {
    public MemberList(int size) {
        super(size);
    }

    public Member search(int index) {
        return (Member) getObject(index);
    }

    public boolean remove(int index) {
        Member memberToRemove = search(index);
        if (memberToRemove == null || !super.remove(index)) {
            return false;
        }
        return true;
    }
}
