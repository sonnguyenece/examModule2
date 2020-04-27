import java.util.regex.Pattern;

public class Contact {
    private int phoneNum;
    private String group;
    private String fullName;
    private boolean gender;
    private String address;
    private String dateOfBirth;
    private String email;
    private final String PHONENUM_REGEX = "^d{9,12}$";
    private final String ADDRESS_REGEX="[a-zA-Z]+\\-[a-zA-Z]+";
    private final String DATE_REGEX="[0-9]{4}\\-[0-9]{2}\\-[0-9]{2}";
    private final String EMAIL_REGEX =   "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    Contact() {
    }

    ;

    Contact(int phoneNum, String group, String fullName, boolean gender
            , String address, String dateOfBirth, String email) {
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.fullName = fullName;
        this.gender = gender;
        this.group = group;
        this.phoneNum = phoneNum;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean checkNum(int phoneNum) {
        String numString = Integer.toString(phoneNum);
        Pattern pattern = Pattern.compile(PHONENUM_REGEX);
        return pattern.matcher(numString).matches();
    }
    public boolean checkAddrees(String address){
        Pattern pattern = Pattern.compile(ADDRESS_REGEX);
        return pattern.matcher(address).matches();
    }
    public boolean checkDate(String date){
        Pattern pattern = Pattern.compile(DATE_REGEX);
        return pattern.matcher(date).matches();
    }
    public boolean checkMail(String mail){
        Pattern pattern = Pattern.compile(DATE_REGEX);
        return pattern.matcher(mail).matches();
    }
}
