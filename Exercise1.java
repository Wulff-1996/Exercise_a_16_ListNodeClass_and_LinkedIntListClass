public class Exercise1
{
    private ListNode front;

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
}
