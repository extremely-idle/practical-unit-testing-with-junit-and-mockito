package exercise3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class HashMapTest {

    private Map<String, Integer> map;

    @Before
    public void init() {
        map = new HashMap<>();
    }

    @Test
    public void should_GetObject_WhenObjectHasBeenPut() {
        // Arrange
        map.put("first", 1);

        // Act
        Integer value = map.get("first");

        // Assert
        assertTrue("Value can be retrieved", 1 == value);
    }

    @Test
    public void should_OverwriteExistingObject_When_SecondObjectAddedWithSameKey() {
        // Arrange
        map.put("first", 1);
        map.put("first", 2);

        // Act
        Integer value = map.get("first");

        // Assert
        assertTrue("Pair value was overwritten", 2 == value);
    }

    @Test
    public void should_EmptyMap_WhenCleared() {
        // Arrange
        map.put("first", 1);
        map.put("second", 2);

        // Act
        map.clear();

        // Assert
        assertTrue("Map is empty", map.isEmpty());
    }

    @Test
    public void should_BeAbleToUseNullAsAKey() {
        // Arrange, Act
        map.put(null, 3);

        // Assert
        assertTrue("Map isn't empty", !map.isEmpty());
        assertTrue("Map contains a pair with a null key", map.containsKey(null));
    }
}
