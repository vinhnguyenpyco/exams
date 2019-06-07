package exams.myexercise.questionone;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Test for question one
 */
public class StoreAndLoadTest {

    @Test
    public void testSuccessStoreMap() {
        Map<String, String> mapOne = new HashMap<>();
        mapOne.put("key1", "value1");
        mapOne.put("key2", "value2");

        Map<String, String> mapTwo = new HashMap<>();
        mapTwo.put("key3", "value3");
        mapTwo.put("key4", "value4");

        Map<String, String> mapThree = new HashMap<>();
        mapThree.put("key5", "value5");
        mapThree.put("key6", "value6");

        List<Map<String, String>> lstMap = new ArrayList<>();

        lstMap.add(mapOne);
        lstMap.add(mapTwo);
        lstMap.add(mapThree);

        QuestionOne quesOne = new QuestionOne();
        String storeMap = quesOne.storeMap(lstMap);

        assertEquals("key1=value1;key2=value2\nkey3=value3;key4=value4\nkey5=value5;key6=value6\n", storeMap);
    }

    @Test
    public void testSuccessLoadMap() {
        String textMap = "key1=value1;key2=value2\nkey3=value3;key4=value4\nkey5=value5;key6=value6\n";

        QuestionOne quesOne = new QuestionOne();
        List<Map<String, String>> lstMap = quesOne.loadMap(textMap);

        assertEquals(3, lstMap.size());
    }
}
