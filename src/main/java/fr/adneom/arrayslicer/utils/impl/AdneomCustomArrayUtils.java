package fr.adneom.arrayslicer.utils.impl;


import fr.adneom.arrayslicer.utils.IAdneomArrayUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * List utility class <b>AdneomCustomArrayUtils</b>, used to chunk lists
 * The class is implemented using Guava library
 * @author Mohammed EL GADI
 * @param <T> Generic object
 * @version 1.0.0
 */
@Component
public class AdneomCustomArrayUtils<T> implements IAdneomArrayUtils<T> {

    public List<List<T>> partition(@Nullable final List<T> list, final int chunkSize) {
        List<List<T>> listTmp;
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        } else if (list.size() < chunkSize) {
            return Stream.of(list).collect(Collectors.toList());
        }

        listTmp = partition(list.subList(chunkSize, list.size()), chunkSize);
        if (CollectionUtils.isEmpty(listTmp)) {
            return Stream.of(list.subList(0, chunkSize)).collect(Collectors.toList());
        } else {
            return new ArrayList<List<T>>() {{
                add(list.subList(0, chunkSize));
                addAll(listTmp);
            }};
        }
    }

}
