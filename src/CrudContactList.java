

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CrudContactList {
    private ArrayList<Contact> contactsList;
    private boolean isAdded;
    private int quantity;

    public CrudContactList() {
        contactsList = new ArrayList<Contact>();

    }

    public ArrayList<Contact> getContactsList() {
        return contactsList;
    }

    public void setContactsList(ArrayList<Contact> contactsList) {
        this.contactsList = contactsList;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public void setAdded(boolean added) {
        isAdded = added;
    }

    public void showAllContact() {
        System.out.println("So dien thoai       Nhom        Ho ten     " +
                " Gioi tinh        Dia chi        Ngay sinh          Email");
        String gender;
        for (Contact contact :
                contactsList) {
            if (contact.isGender()) {
                gender = "Nam";
            } else {
                gender = "Nu";
            }
            System.out.printf("-10%d-10%s-15%s-5%s-15%s-10%s-15%s", contact.getPhoneNum(),
                    contact.getGroup(), contact.getFullName(), gender, contact.getAddress(),
                    contact.getDateOfBirth(), contact.getEmail());
        }
    }


    public void addContact(Contact contact) {
        isAdded = false;
        for (Contact c :
                contactsList) {
            if (contact.getPhoneNum() == c.getPhoneNum()) {
                System.out.println("So lien lac da ton tai");
                return;
            }
        }
        this.contactsList.add(contact);
        System.out.println("Contact Added!");
        isAdded = true;
    }

    public void searchByName(String name) {
        for (Contact contact :
                contactsList) {
            if ((contact.getFullName()).contains(name)){
                System.out.printf("-10%d-10%s-15%s-5%s-15%s-10%s-15%s", contact.getPhoneNum(),
                        contact.getGroup(), contact.getFullName(), contact.isGender(), contact.getAddress(),
                        contact.getDateOfBirth(), contact.getEmail());
            }
            else System.out.println("Khong tim thay ten lien lac!");
        }
    }
    public void searchByNum(int num) {
        String numString = Integer.toString(num);
        for (Contact contact :
                contactsList) {
            String contactString = Integer.toString(contact.getPhoneNum());
            if (contactString.contains(numString)){
                System.out.printf("-10%d-10%s-15%s-5%s-15%s-10%s-15%s", contact.getPhoneNum(),
                        contact.getGroup(), contact.getFullName(), contact.isGender(), contact.getAddress(),
                        contact.getDateOfBirth(), contact.getEmail());
            }
            else System.out.println("Khong tim thay so lien lac!");
        }
    }

}
