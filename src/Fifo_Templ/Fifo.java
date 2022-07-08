package Fifo_Templ;

import static Fifo_Templ.ExceptionFifo.QUEUE_ISEMPTY;

public class Fifo<T>
{
    private class FifoItem<T>
    {
        private T        mKey;
        private FifoItem mNext;

        public FifoItem(){
            setNext(null);
            setKey(null);
        }
        public FifoItem( T key  ){
            setKey(key);
            setNext(null);
        }
        public T getKey(){
            return mKey;
        }
        public void setKey(T key){
            mKey = key;
        }
        public FifoItem getNext(){
            return mNext;
        }
        public void setNext( FifoItem item ){
            mNext = item;
        }
    }
    //-------------
    public Fifo(){
        mHead = mTail = new FifoItem();
    }
    public boolean  QFEmpty(){
        return getHead().getNext() == null;
    }
    public void QFEnqueue( T x  ){
        FifoItem nitem = new FifoItem(x);
        getTail().setNext(nitem);
        setTail(nitem);
    }
    public T QFDequeue() throws ExceptionFifo {
        if(QFEmpty()) throw new ExceptionFifo(QUEUE_ISEMPTY);
        T p = (T)getHead().getNext().getKey();
        getHead().setNext(getHead().getNext().getNext());
        if(QFEmpty()) setTail(getHead());
        return p;
    }
    public void  QFClear(){
        try{ while(!QFEmpty()) QFDequeue(); }
        catch(ExceptionFifo e) {System.out.println(e.getReason());}
        setTail(getHead());
    }
    public void QFPrint() throws ExceptionFifo{
        if(QFEmpty()) throw new ExceptionFifo(QUEUE_ISEMPTY);
        FifoItem t = getHead().getNext();
        int i = 1;
        System.out.println("Drukowanie listy:");
        while(t != null){
            System.out.println(i+". "+t.getKey());
            t = t.getNext();
        }
    }

    public void setHead(FifoItem i){
        mHead = i;
    }
    public void setTail(FifoItem i){
        mTail = i;
    }
    public FifoItem getHead(){
        return mHead;
    }
    public FifoItem getTail(){
        return mTail;
    }

    private FifoItem mHead;
    private FifoItem mTail;
}