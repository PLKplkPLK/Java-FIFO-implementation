package Fifo_Templ;

public class ExceptionFifo extends Exception{
    final static int MEM_OVERFLOW=0x01;
    final static int QUEUE_ISEMPTY=0x02;
    final static int OTHER_QUEUE_ERROR=0x04;

    public ExceptionFifo(int errCode){
        m_ErrCode = errCode;
    }
    public String getReason(){
        switch (m_ErrCode)
        {
            case MEM_OVERFLOW: return "ERROR: memory full?\n";
            case QUEUE_ISEMPTY:  return "ERROR: Queue is empty\n";
            default: return "Queue error\n";
        }
    }

    private int m_ErrCode;
}