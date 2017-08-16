package gamestore.app.utils;

import org.modelmapper.ModelMapper;

/**
 * Created by Todor Popov using Lenovo on 2.8.2017 г. at 1:49.
 */


public class ModelParser {
    private static ModelMapper modelMapper;

    public static ModelMapper getInstance(){
        if (modelMapper==null){
            modelMapper=new ModelMapper();
        }
        return modelMapper;
    }

    public static <T> T map(Object source, Class<T> destination) {
      return   source==null?null:ModelParser.getInstance().map(source,destination);
    }

}
