package gr.aueb.cf.teacherapp.core.exceptions;

public class EntityNotAuthorizedException extends EntityGenericException{

    private static final String DEFAULT_CODE = "Not authorized";

    public EntityNotAuthorizedException(String code , String message){
        super(message + DEFAULT_CODE , code);
    }
}
