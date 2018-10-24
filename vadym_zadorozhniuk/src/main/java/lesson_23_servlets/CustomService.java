package lesson_23_servlets;

import java.util.HashMap;
import java.util.Map;

public class CustomService {

    private Map<Integer, CustomModel> models = new HashMap<>();

    public CustomService() {
        CustomModel model = new CustomModel();
        model.setId(1);
        model.setName("TestModel");
        models.put(model.getId(), model);

    }


    public void add(CustomModel customModel){
        models.put(customModel.getId(), customModel);

    }

    public CustomModel get (int id){
        return models.get(id);
    }
}
