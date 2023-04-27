package test;

 import main.ATM;
 import org.junit.jupiter.api.AfterEach;
 import org.junit.jupiter.api.BeforeEach;
 import org.junit.jupiter.api.Test;

 import java.io.ByteArrayOutputStream;
 import java.io.PrintStream;
 import java.util.*;

 import static org.junit.jupiter.api.Assertions.*;

class ATMTests {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpForOutput() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void askMoneyWell() {
        var first = new ATM(1,100,1,0,0,0,0);
        first.askMoney(100);
        assertEquals("Take your money",outputStreamCaptor.toString().trim());
    }

    @Test
    public void askMoneyNotEnough() {
        var first = new ATM(1,100,1,0,0,0,0);
        first.askMoney(1000);
        assertEquals("Not enough money in ATM",outputStreamCaptor.toString().trim());
    }

    @Test
    public void askMoneyTooMuch() {
        var first = new ATM(1,100000,1000,0,0,0,0);
        first.askMoney(3000);
        assertEquals("You can't have so many money",outputStreamCaptor.toString().trim());
    }

    @Test
    public void askMoneyTooLittle() {
        var first = new ATM(1,100000,1000,0,0,0,0);
        first.askMoney(3);
        assertEquals("ATM doesn't have such little bills",outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void addMoneyWell() {
    var first = new ATM();
    first.addMoney(10, 10, 10, 10, 10);
    assertEquals(1850, first.getAccount());
    }
    @Test
    void addMoneyBy100(){
        var first= new ATM();
        first.addMoney(10,0,0,0,0);
        assertEquals(1000,first.getAccount());
        assertEquals(10,first.getX100());
        assertEquals(0,first.getX10());
    }
    @Test
    void addMoneyBy10(){
        var first= new ATM();
        first.addMoney(0,0,0,100,0);
        assertEquals(1000,first.getAccount());
        assertEquals(0,first.getX100());
        assertEquals(100,first.getX10());
    }
    @Test
    void addMoneyZero(){
        var first= new ATM();
        first.addMoney(0,0,0,0,0);
        assertEquals(0,first.getAccount());

    }
    @Test
    void toStringNull(){
        var first=new ATM();
        assertEquals("ATM {Number: 0 Cash: 0, hundred bills:0, fifty bills:0, twenty bills:0, ten bills:0, five bills:0}\n",first.toString());
    }
    @Test
    void toStringAllNull(){
        var first=new ATM(0,0,0,0,0,0,0);
        assertEquals("ATM {Number: 0 Cash: 0, hundred bills:0, fifty bills:0, twenty bills:0, ten bills:0, five bills:0}\n",first.toString());
    }
    @Test
    void toStringNotNull(){
        var first=new ATM(101,100,1,0,0,0,0);
        assertEquals("ATM {Number: 101 Cash: 100, hundred bills:1, fifty bills:0, twenty bills:0, ten bills:0, five bills:0}\n",first.toString());
    }
    @Test
    void compareToEquals(){
        var first=new ATM(101,100,1,0,0,0,0);
        var second=new ATM(29,100,1,0,0,0,0);
        assertEquals(0,first.compareTo(second));
    }
    @Test
    void compareToMore(){
        var first=new ATM(101,1000,10,0,0,0,0);
        var second=new ATM(29,100,1,0,0,0,0);
        assertEquals(1,first.compareTo(second));
    }
    @Test
    void compareToLess(){
        var first=new ATM(101,1000,10,0,0,0,0);
        var second=new ATM(29,100,1,0,0,0,0);
        assertEquals(-1,second.compareTo(first));
    }
    private ArrayList<ATM> list;
    private Iterator<ATM> itr;

    @BeforeEach
    public void setUpForIterator()
    {
        list = new ArrayList<ATM>();
        var first=new ATM(101,1000,10,0,0,0,0);
        var second=new ATM(29,100,1,0,0,0,0);
        list.add (first);
        list.add (second);
        itr = list.iterator();
    }


    // 2 Tests for Iterator method hasNext()

    @Test public void testHasNext_BaseCase()
    {
        assertTrue (itr.hasNext());
    }


    @Test public void testHasNext_C1()
    {
        itr.next(); itr.next();
        assertFalse (itr.hasNext());
    }


    // 2 Tests for Iterator method next()


    @Test public void testNext_BaseCase()
    {
        var firstCheck=new ATM(101,1000,10,0,0,0,0);
        assertEquals (firstCheck.toString(), itr.next().toString());
    }


    @Test public void testNext_C1()
    {
        list.add (null);
        itr = list.iterator();
        itr.next();
        itr.next();
        assertNull (itr.next());
    }



    // 3 Tests for Iterator method remove()

    @Test public void testRemove_BaseCase()
    {
        var firstCheck=new ATM(101,1000,10,0,0,0,0);
        itr.next();
        itr.remove();
        assertFalse (list.contains (firstCheck));
    }

    @Test public void testRemove_C1()
    {
        var secondCheck=new ATM(29,100,1,0,0,0,0);
        itr.next(); itr.next();
        itr.remove();
        assertFalse (list.contains (secondCheck));
    }


    @Test public void testRemove_C2()
    {
        var th=new ATM(56,150,1,1,0,0,0);
        list.add (null);
        list.add (th);
        itr = list.iterator();
        itr.next(); itr.next();
        itr.next();
        itr.remove();
        assertFalse (list.contains (null));
    }

}
