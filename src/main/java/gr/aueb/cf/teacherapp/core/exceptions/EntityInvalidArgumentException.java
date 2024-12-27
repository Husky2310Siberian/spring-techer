package gr.aueb.cf.teacherapp.core.exceptions;

public class EntityInvalidArgumentException extends EntityGenericException{

    private static final String DEFAULT_CODE = "Invalid Argument";

    public EntityInvalidArgumentException(String code , String message){
        super(message + DEFAULT_CODE , code);
    }
}
