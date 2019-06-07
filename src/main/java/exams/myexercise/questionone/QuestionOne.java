package exams.myexercise.questionone;

import exams.myexercise.constant.Constant;

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

            stResult.append(Constant.NEW_ITEM);
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
        Map<String, String> map = new HashMap<>();

        StringBuilder stBuilder = new StringBuilder();
        String key = "";
        String value = "";

        for(char character : textMap.toCharArray()){
            switch (character) {
                case Constant.EQUAL:
                    key = stBuilder.toString();

                    stBuilder = new StringBuilder();
                    break;
                case Constant.SEMICOLON:
                    value = stBuilder.toString();

                    map.put(key, value);

                    stBuilder = new StringBuilder();
                    break;
                case Constant.NEW_ITEM:
                    value = stBuilder.toString();

                    map.put(key, value);
                    lstResult.add(map);

                    map = new HashMap<>();
                    stBuilder = new StringBuilder();
                    break;
                default:
                    stBuilder.append(character);
            }
        }

        return lstResult;
    }
}
