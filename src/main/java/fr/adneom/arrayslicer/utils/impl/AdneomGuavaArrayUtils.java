package fr.adneom.arrayslicer.utils.impl;

import com.google.common.collect.Lists;
import fr.adneom.arrayslicer.utils.IAdneomArrayUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * List utility class AdneomGuavaArrayUtils, used to chunk lists
 * The class is implemented using Guava library
 * @author Mohammed EL GADI
 * @param <T> Generic object
 * @version 1.0.0
 */
@Component
public class AdneomGuavaArrayUtils<T> implements IAdneomArrayUtils<T> {

    @Override
    public List<List<T>> partition(@Nullable final List<T> list, final int chunkSize) {
        List<List<T>> result = Collections.emptyList();
        if (!CollectionUtils.isEmpty(list)) {
            result = Lists.partition(list, chunkSize);
        }
        return result;
    }
}
