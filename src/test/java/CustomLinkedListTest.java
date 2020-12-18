import customLinkedList.CustomLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTest {
    CustomLinkedList<String> names = new CustomLinkedList<>();

    @Before
    public void prepare(){
        names.clear();
        names.add("Boris");
        names.add("Ivan");
        names.add("Svetlana");
    }

    @Test
    public void addTest(){
        Assert.assertTrue(names.add("Ignat"));
    }

    @Test
    public void addAndGetTest(){
        names.clear();
        names.add("Samuel");
        Assert.assertEquals("Samuel", names.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getOutOfBoundIndexTest(){
        names.get(3);
    }

    @Test
    public void removeTest(){
        Assert.assertTrue(names.remove("Ivan"));
    }
    @Test
    public void removeAlreadyRemovedTest(){
        names.remove("Ivan");
        Assert.assertFalse(names.remove("Ivan"));
    }

    @Test
    public void removeNotExistValueTest(){
        Assert.assertFalse(names.remove("Fedor"));
    }

    @Test
    public void sizeTest(){
        Assert.assertEquals(3, names.size());
    }

    @Test
    public void clearAndSizeTest(){
        names.clear();
        Assert.assertEquals(0, names.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void clearAndGetTest(){
        names.clear();
        names.get(0);
    }

    @Test
    public void reverseTest(){
        CustomLinkedList<String> expectedList= new CustomLinkedList();
        expectedList.add("Svetlana");
        expectedList.add("Ivan");
        expectedList.add("Boris");
        names.reverseList();
        Assert.assertEquals(expectedList, names);
    }
}
