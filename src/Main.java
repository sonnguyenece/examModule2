import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CrudContactList contactList = new CrudContactList();
        Scanner scn = new Scanner(System.in);
        int selection;
        do {
            System.out.println("------Chuong trinh quan ly danh ba------");
            System.out.println("Chon chuc nang theo so(de tiep tuc)");
            System.out.println("1.Xem danh sach");
            System.out.println("2.Them moi");
            System.out.println("3.Cap nhat");
            System.out.println("4.Xoa");
            System.out.println("5.Tim kiem");
            System.out.println("6.Doc tu file");
            System.out.println("7.Ghi vao file");
            System.out.println("8.Thoat");
            selection = scn.nextInt();


            switch (selection) {
                case 1:
                    contactList.showAllContact();
                    break;
                case 2:
                    addPhoneNum(scn, contactList);
                    break;
                case 3:
                    while (true) {
                        boolean change = true;
                        System.out.println("Nhap so dien thoai can sua");
                        int editNum = scn.nextInt();
                        scn.nextLine();
                        for (int i = 0; i < contactList.getContactsList().size(); i++) {
                            if (editNum == contactList.getContactsList().get(i).getPhoneNum()) {
                                addPhoneNum(scn, contactList);
                                if (contactList.isAdded()) {
                                    contactList.getContactsList().remove(i);
                                } else {
                                    System.out.println("Thay doi khong hop le");
                                    change = false;
                                }
                            }
                        }
                        if (change) {
                            System.out.println("Khong tim thay so dien thoai can sua");
                        }
                        System.out.println("Nhap lai : ");
                        String reInput = scn.nextLine();
                        if (reInput == "" || reInput == null) break;
                    }

                case 4:
                    while (true) {
                        System.out.println("Nhap so dien thoai muon xoa");
                        int delNum = scn.nextInt();
                        boolean del = true;
                        scn.nextLine();
                        for (int i = 0; i < contactList.getContactsList().size(); i++) {
                            addPhoneNum(scn, contactList);
                            if (contactList.isAdded()) {
                                contactList.getContactsList().remove(i);
                            } else {
                                System.out.println("Thay doi khong hop le");
                                del = false;
                            }
                        }
                        if (del) {
                            System.out.println("Khong tim thay so dien thoai can xoa");
                        }
                        System.out.println("Nhap lai : ");
                        String reInput = scn.nextLine();
                        if (reInput == "" || reInput == null) break;
                    }
                case 5:
                        System.out.println("Tim kiem theo");
                        System.out.println("1.Theo ten");
                        System.out.println("2.Theo so dien thoai");
                        int sel = scn.nextInt();
                        scn.nextLine();
                        if (sel == 1) {
                            String nameSearch = scn.nextLine();
                            contactList.searchByName(nameSearch);
                        } else {
                            int numSearch = scn.nextInt();
                            contactList.searchByNum(numSearch);
                        }
                        break;

                case 6:
                case 7:
            }


        } while (selection != 8);
    }

    private static void addPhoneNum(Scanner scn, CrudContactList contactList) {
        Contact contact = new Contact();
        System.out.println("Nhap so dien thoai");
        try {
            int num = scn.nextInt();
            if (contact.checkNum(num)) {
                contact.setPhoneNum(num);
            }
        } catch (Exception e) {
            System.out.println("So nhap vao khong hop le!");
            return;
        }

        System.out.println("Nhap ten nhom");
        scn.nextLine();
        String group = scn.nextLine();
        if (group != "" && group != null) {
            contact.setGroup(group);
        } else return;

        System.out.println("Nhap ten lien lac");
        String fullName = scn.nextLine();
        if (fullName != "" && fullName != null) {
            contact.setFullName(fullName);
        } else return;

        System.out.println("Nhap gioi tinh (Nam/Nu)");
        String gender = scn.nextLine();
        if (gender.equalsIgnoreCase("Nam")) {
            contact.setGender(true);
        } else if (gender.equalsIgnoreCase("Nu")) {
            contact.setGender(false);
        } else return;

        System.out.println("Nhap dia chi");
        String address = scn.nextLine();
        if (contact.checkAddrees(address)) {
            contact.setAddress(address);
        } else return;

        System.out.println("Nhap ngay sinh");
        String dateOfBirth = scn.nextLine();
        if (contact.checkDate(dateOfBirth)) {
            contact.setDateOfBirth(dateOfBirth);
        } else return;

        System.out.println("Nhap email");
        String email = scn.nextLine();
        if (contact.checkMail(email)) {
            contact.setEmail(email);
        } else return;

        contactList.addContact(contact);
    }

}
