package exams.indigo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class for resolve question one of test assessment
 */
public class QuestionOne {

    /**
     * store list map in a string-type
     * @param lstMap
     * @return String
     */
    public String storeMap(List<Map<String, String>> lstMap) {
        StringBuilder stResult = new StringBuilder();

        for(int i = 0; i < lstMap.size(); i++) {
            Map<String, String> map = lstMap.get(i);

            Object[] arrkey = map.keySet().toArray();
            for (int j = 0; j < arrkey.length; j ++) {
                String key = arrkey[j].toString();
                String value = map.get(key);

                stResult.append(key);
                stResult.append(Constant.EQUAL);
                stResult.append(map.get(arrkey[j]));

                // Check next map is exist
                if(j < arrkey.length - 1){
                    stResult.append(Constant.SEMICOLON);
                }
            }
            if(i < lstMap.size() - 1) {
                stResult.append(Constant.NEW_ITEM);
            }
        }

        return stResult.toString();
    }

    /**
     *
     * @param textMap
     * @return List<Map<String, String>>
     */
    public List<Map<String, String>> loadMap(String textMap) {
        List<Map<String, String>> lstResult = new ArrayList<>();

        String[] items = textMap.split(Constant.NEW_ITEM);

        for(String item : items) {
            String[] lstMap = item.split(Constant.SEMICOLON);
            Map<String, String> map = new HashMap<>();

            for(String stMap : lstMap) {
                String[] entryMap = stMap.split(Constant.EQUAL);
                map.put(entryMap[0], entryMap[1]);
            }

            lstResult.add(map);
        }

        return lstResult;
    }
}
