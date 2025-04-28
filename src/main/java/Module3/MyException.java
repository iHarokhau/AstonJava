package Module3;

import java.io.IOException;

public class MyException extends IOException {

    public MyException(){
        super();
    }

    public MyException (String message){
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}
