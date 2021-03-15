package net.xdclass.online_xdclass.model.request;

public class SignInRequest {

    private String phone;
    private String pwd;

    @Override
    public String toString() {
        return "SignInRequest{" +
                "phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
