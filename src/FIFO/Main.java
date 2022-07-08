package FIFO;

import Fifo_Templ.ExceptionFifo;
import Fifo_Templ.Fifo;

public class Main {

    public static void main(String[] args) {
	    try{
            Fifo kolejka = new Fifo();
            kolejka.QFEnqueue(2.3);
            kolejka.QFEnqueue(6.5);
            kolejka.QFEnqueue(-1.6);
            kolejka.QFPrint();
            kolejka.QFClear();
            kolejka.QFDequeue();
        }
        catch( OutOfMemoryError e )
        {
            System.out.println(e.getMessage());
        }
        catch( ExceptionFifo e )
        {
            System.out.println(e.getReason());
        }
    }
}

/*
import TFifo_Templ.TExceptionFifo;
import TFifo_Templ.TFifo;

public class Main {

    public static void main(String[] args) {
        try{
            TFifo kolejka = new TFifo(3);
            kolejka.TFEnqueue(2.3);
            kolejka.TFEnqueue(-1.6);
            kolejka.TFEnqueue(4.5);
            kolejka.TFPrint();
            kolejka.TFClear();
            kolejka.TFDequeue();
        }
        catch( TExceptionFifo e )
        {
            System.out.println(e.getReason());
        }
        catch( OutOfMemoryError e )
        {
            System.out.println(e.getMessage());
        }
    }
}*/
