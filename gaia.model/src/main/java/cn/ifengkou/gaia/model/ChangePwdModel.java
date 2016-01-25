package cn.ifengkou.gaia.model;

/**
 * Created by Sloong on 2016/1/25.
 */
public class ChangePwdModel {
    private String oldPasswordCiphertext;
    private String newPasswordCiphertext;

    public String getOldPasswordCiphertext() {
        return oldPasswordCiphertext;
    }

    public void setOldPasswordCiphertext(String oldPasswordCiphertext) {
        this.oldPasswordCiphertext = oldPasswordCiphertext;
    }

    public String getNewPasswordCiphertext() {
        return newPasswordCiphertext;
    }

    public void setNewPasswordCiphertext(String newPasswordCiphertext) {
        this.newPasswordCiphertext = newPasswordCiphertext;
    }
}
