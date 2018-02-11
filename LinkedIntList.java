import java.util.NoSuchElementException;

public class LinkedIntList
{
    private ListNode front;

    public LinkedIntList()
    {
        this.front = null;
    }

    public void add(int value)
    {
        if(this.front == null)
            this.front = new ListNode(value);
        else
        {
            ListNode current = this.front;

            while (current.next != null)
            {
                current = current.next;
            }

            current.next = new ListNode(value);
        }
    }

    public int size()
    {
        ListNode current = this.front;
        int count = 0;

        while (current != null)
        {
            current = current.next;
            count++;
        }
        return count;
    }

    public int get(int index)
    {
        ListNode current = this.front;

        for (int i = 0; i <index ; i++)
        {
            current = current.next;
        }
        return current.getData();
    }

    //  Exercise 1
    public void set(int index, int value)
    {
        if (index == 0)
            this.front.setData(value);
        else
        {
            ListNode current = this.front;

            for (int i = 0; i <index ; i++)
            {
                current = current.next;
            }
            current.setData(value);
        }
    }

    //  Exercise 2
    @Override
    public String toString()
    {
        if (this.front == null)
        {
            return "[]";
        }
        else
        {
            String result = "[" + front.getData();
            ListNode current = this.front.next;

            while (current != null)
            {
                result += ", " + current.getData();
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    //  Exercise 3
    public int indexOf(int value)
    {
        ListNode current = this.front;

        int count = 0;
        while (current != null)
        {
            if (current.getData() == value) return count;
            current = current.next;
            count++;
        }
        return -1;
    }

    //  Exercise 4
    public int min() throws NoSuchElementException
    {
        if (this.front == null)
        {
            throw new NoSuchElementException();
        }
        else
        {
            ListNode current = this.front;
            int min = current.getData();

            while (current != null)
            {
                if (current.getData() < min) min = current.getData();
                current = current.next;
            }
            return min;
        }
    }

    //  Exercise 5
    public boolean isSorted()
    {
        if (this.front == null) return true;
        else
        {
            ListNode current = this.front;
            int currentValue = current.getData();
            while (current.next != null)
            {
                if (current.next.getData() < currentValue) return false;
                currentValue = current.next.getData();
                current = current.next;
            }
            return true;
        }
    }

    //  Exercise 6
    public int lastIndexOf(int value)
    {
        if (this.front == null) return -1;
        else
        {
            ListNode current = this.front;
            int index = -1;
            int count = 0;

            while (current != null)
            {
                if (current.getData() == value) index = count;
                count++;
                current = current.next;
            }
            return index;
        }
    }

    //  Exercise 7
    public int countDublicates()
    {
        if (this.front == null) return 0;
        else
        {
            ListNode current = this.front;
            int dublicates = 0;

            while (current.next != null)
            {
                if (current.getData() == current.next.getData()) dublicates++;
                current = current.next;
            }
            return dublicates;
        }
    }

    //  Exercise 8
    public boolean hasTwoConsecutive()
    {
        if (this.front == null) return false;
        else
        {
            ListNode current = this.front;

            while (current.next != null)
            {
                if (current.getData() == (current.next.getData()-1)) return true;
                current = current.next;
            }
            return false;
        }
    }

    //  Exercise 9
    public int deleteBack()
    {
        if (this.front == null) throw new NoSuchElementException();
        else
        {
            int dataDeleted = -1;
            ListNode current = this.front;

            while (current.next.next != null)
            {
                current = current.next;
            }
            dataDeleted = current.next.getData();
            current.next = null;
            return dataDeleted;
        }
    }

    //  Exercise 15
    public LinkedIntList removeEvens()
    {
        LinkedIntList list2 = new LinkedIntList();

        ListNode current = front.next;

        list2.add(front.getData());

        front = current;

        while(current.next != null)
        {
            list2.add(current.next.getData());
            current.next = current.next.next;
            current = current.next;
        }
        return list2;
    }

    //  Exercise 17
    public void doubleList()
    {
        if (this.front != null)
        {

            ListNode current = this.front;
            int max = 0;

            while (current != null)
            {
                current = current.next;
                max++;
            }


            current = this.front;
            int count = 0;

            while (count  < max)
            {
                this.add(current.getData());
                current = current.next;
                count++;
            }
        }
    }

    //  Exercise 20
    public void reverse()
    {
        ListNode current = this.front;
        ListNode prev = null;
        ListNode next;

        while (current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        this.front = prev;
    }
}
