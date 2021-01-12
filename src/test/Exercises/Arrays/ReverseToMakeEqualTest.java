package Exercises.Arrays;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.*;

public class ReverseToMakeEqualTest {

    @Test
    public void cannotBeEqualsSinceEitherIsNull(){
        int[] nullified = null;
        int[] nonEmpty = {1, 2};
        assertFalse(canBeEqual(nullified, nonEmpty));
        assertFalse(canBeEqual(nonEmpty, nullified));
    }

    @Test
    public void cannotBeEqualsDueDifferentSizes(){
        int[] two = {1, 2};
        int[] three = {1, 2, 3};
        assertFalse(canBeEqual(two, three));
    }

    @Test
    public void canBeEqualWithOneElement(){
        int[] source = {1};
        int[] target = {1};
        assertTrue(canBeEqual(source, target));
    }

    @Test
    public void cannotBeEqualWithOneElement(){
        int[] source = {1};
        int[] target = {2};
        assertFalse(canBeEqual(source, target));
    }

    @Test
    public void canBeEqualWithTwoElements(){
        int[] source = {1, 2};
        int[] target = {2, 1};
        assertTrue(canBeEqual(source, target));
    }

    @Test
    public void cannotBeEqualWithTwoElements(){
        int[] source = {1, 2};
        int[] target = {2, 3};
        assertFalse(canBeEqual(source, target));
    }

    @Test
    public void canBeEqual(){
        int[] source = {1, 2, 3, 4};
        int[] target = {2, 3, 1, 4};
        assertTrue(canBeEqual(source, target));
    }

    @Test
    public void cannotBeEqual(){
        int[] source = {1, 2, 3, 4};
        int[] target = {2, 3, 5, 4};
        assertFalse(canBeEqual(source, target));
    }

    public boolean canBeEqual(int[] source, int[] target){
        if (source == null || target == null) return false;
        if (source.length != target.length) return false;
        Map map = new HashMap<Integer, Boolean>();
        for (Integer number : source){
            map.put(number, true);
        }
        for(Integer number : target){
            if (!map.containsKey(number)){
                return false;
            }
        }
        return true;
    }

}