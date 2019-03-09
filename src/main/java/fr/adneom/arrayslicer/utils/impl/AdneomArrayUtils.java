package fr.adneom.arrayslicer.utils.impl;


import fr.adneom.arrayslicer.utils.IAdneomArrayUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;


import java.util.*;

import java.util.stream.Collectors;

/**
 *
 * Class Iml
 * @author Mohammed EL GADI
 * @param <T> Generic object
 * @version 1.0.0
 */
@Component
public class AdneomArrayUtils<T> implements IAdneomArrayUtils<T> {

    @Override
    public List<List<T>> partition(@Nullable final List<T> list, final int chunkSize) {
        List<List<T>> result = Collections.emptyList();
        if (!CollectionUtils.isEmpty(list)) {
            if (list.size() < chunkSize) {
                result = new ArrayList(list);
            } else {
                result = list.stream()
                        .collect(Collectors.groupingBy(s -> list.indexOf(s) / chunkSize))
                        .values().stream().collect(Collectors.toList());
            }
        }
        return result;
    }


}
