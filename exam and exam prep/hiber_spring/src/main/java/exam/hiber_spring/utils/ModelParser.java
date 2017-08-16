package exam.hiber_spring.utils;

import org.modelmapper.ModelMapper;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 2.8.2017 г. at 1:49.
 */


public class ModelParser {
    private static ModelMapper modelMapper;

    public static ModelMapper getInstance() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
        }
        return modelMapper;
    }

    public static <T> T map(Object source, Class<T> destination) {
        return source == null ? null : ModelParser.getInstance().map(source, destination);
    }

    public static <T> List<T> map(Iterable source, Class<T> destination) {

        List<T> list = new LinkedList<>();
        for (Object o : source) {
            T mapped = ModelParser.map(o, destination);
            list.add(mapped);
        }
        return list;

    }

}
