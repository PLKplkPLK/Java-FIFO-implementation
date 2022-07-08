package TFifo_Templ;


import static TFifo_Templ.TExceptionFifo.OTHER_QUEUE_ERROR;
import static TFifo_Templ.TExceptionFifo.QUEUE_ISEMPTY;

public class TFifo<T>
{
    public TFifo( int size ) throws TExceptionFifo {
        if(size < 1) throw new TExceptionFifo(OTHER_QUEUE_ERROR);
        q = (T[])new Object[size];
        setHead(0);
        setTail(0);
        setElemNo(0);
        setMaxSize(size);
    }
    public boolean  TFEmpty(){
        return getElemNo()==0;
    }
    public void TFEnqueue( T x  ) throws TExceptionFifo{
        if( getElemNo() == getMaxSize() ) throw new TExceptionFifo(OTHER_QUEUE_ERROR);
        setQ(getTail(), x);
        setElemNo(getElemNo()+1);
        setTail( (getTail()+1) % getMaxSize() );
    }
    public T TFDequeue() throws TExceptionFifo {
        if(TFEmpty()) throw new TExceptionFifo(QUEUE_ISEMPTY);
        T p = getQ(getHead());
        setQ(getHead(),null);
        setHead( (getHead()+1) % getMaxSize() );
        setElemNo( getElemNo() - 1 );
        return p;
    }
    public void TFClear(){
        try
        {while(getElemNo()!=0) TFDequeue();}
        catch(TExceptionFifo e)
        {System.out.println(e.getReason());}
        setHead(0);
        setTail(0);
    }
    public void TFPrint() throws TExceptionFifo{
        if(TFEmpty()) throw new TExceptionFifo(QUEUE_ISEMPTY);
        int k = getHead();
        for(int i = 0; i < getElemNo(); i++){
            System.out.println((i+1)+". nKey = "+getQ(k));
            if (++k == getMaxSize()) k = 0;
        }
    }

    public T getQ(int i) {
        return q[i];
    }

    public void setQ(int i, T q) {
        this.q[i] = q;
    }

    public int getMaxSize() {
        return mMaxSize;
    }

    public void setMaxSize(int mMaxSize) {
        this.mMaxSize = mMaxSize;
    }

    public int getHead() {
        return mHead;
    }

    public void setHead(int mHead) {
        this.mHead = mHead;
    }

    public int getTail() {
        return mTail;
    }

    public void setTail(int mTail) {
        this.mTail = mTail;
    }

    public int getElemNo() {
        return mElemNo;
    }

    public void setElemNo(int mElemNo) {
        this.mElemNo = mElemNo;
    }

    private T [] q;
    private int mMaxSize;  // ZBEDNE - mozna uzyc q.length
    private int mHead;     // indeks pierwszego elem do popbrania z kolejki
    private int mTail;     // indeks pierwzego wolnego miejsca w kolejce
    private int mElemNo;   // ilosc elementow w kolejce
}