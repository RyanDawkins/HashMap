public class ListNode
{

    private String data;
    private ListNode previous;
    private ListNode next;

    public ListNode(String data)
    {
       this(data, null);
    }
    public ListNode(String data, ListNode previous)
    {
       this(data, previous, null);
    }
    public ListNode(String data, ListNode previous, ListNode next)
    {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

    public boolean lessThan(ListNode l)
    {
        if(this.getString().compareTo(l.getString()) < 0)
            return true;
        return false;
    }
    public boolean greaterThan(ListNode l)
    {
        if(this.getString().compareTo(l.getString()) > 0)
            return true;
        return false;
    }
    public boolean equals(ListNode l)
    {
        if(this.getString().equals(l.getString()))
            return true;
        return false;
    }

    public String getString()
    {
       return this.data;
    }

    public ListNode setNext(ListNode l)
    {
        this.next = l;
        return this;
    }
    public ListNode getNext()
    {
        return this.next;
    }
    public boolean hasNext()
    {
        if(this.next != null)
        {
           return true;
        }
        return false;
    }

    public ListNode setPrevious(ListNode l)
    {
        this.previous = l;
        return this;
    }
    public ListNode getPrevious()
    {
        return this.previous;
    }
    public boolean hasPrevious()
    {
        if(this.previous != null)
        {
            return true;
        }
        return false;
    }

    public ListNode insert(ListNode l)
    {
        if(!this.hasNext())
        {
            this.setNext(l);
        }
        else
        {
            ListNode old = this.getNext();
            this.next = l;
            l.setNext(old);
            old.setPrevious(this.next);
        }
        return l;
    }
}