package fr.adneom.arrayslicer.utils;

import com.google.common.collect.Lists;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

public interface IAdneomArrayUtils<T> {

    /**
     * <p>Utility method used for slicing list of items<br>
     * to multiple sublist having specified size (chunkSize)<br>
     * Using java8 Collectors library to chunk list</p>
     *
     * <h3>Example 1 :</h3>
     * <ul>
     *      <li>Inputs : list = [1,2,3,4,5] and chunkSize = 2</li>
     *      <li>Output: [ [1,2], [3,4], [5] ]</li>
     * </ul>
     *
     * <h3>Example 2 :</h3>
     * <ul>
     *     <li>Inputs : list = [1,2,3,4,5] and chunkSize = 3</li>
     *     <li>Output: [ [1,2,3], [4,5] ]</li>
     * </ul>
     *
     * <h3>Example 3 :</h3>
     * <ul>
     *      <li>Inputs : list = [1,2,3,4,5] and chunkSize = 1</li>
     *      <li>Output: [ [1], [2], [3], [4], [5] ]</li>
     * </ul>
     * <br>
     * <br>
     * <b>NB : If the input list is Empty, il will return an empty collection</b>
     *
     * @param list the input list to chunk
     * @param chunkSize the size of sublists
     * @return List containing sublists chunked
     */
    public List<List<T>> partition(@Nullable final List<T> list, final int chunkSize);
}
