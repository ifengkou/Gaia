package cn.ifengkou.gaia.controller.exception;

/**
 * Created by Sloong on 2015/12/19.
 */
public class ResourceIsNotExistException extends Exception {
    public ResourceIsNotExistException() {
        super("the resource is not exist");
    }
    public ResourceIsNotExistException(String message) {
        super(message);
    }
}
